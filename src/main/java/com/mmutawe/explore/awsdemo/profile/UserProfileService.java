package com.mmutawe.explore.awsdemo.profile;

import com.mmutawe.explore.awsdemo.bucket.BucketName;
import com.mmutawe.explore.awsdemo.filestore.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserProfileService {

    private final FileStore fileStore;
    private final UserProfileDataAccessRepository repository;

    @Autowired
    public UserProfileService(UserProfileDataAccessRepository repository, FileStore fileStore) {
        this.repository = repository;
        this.fileStore = fileStore;
    }

    List<UserProfile> getUserProfiles(){
        return repository.getUserProfiles();
    }

    public void uploadUserProfileData(UUID userProfileId, MultipartFile file) {

        if (file.isEmpty()) {
            throw new IllegalStateException("File is empty");
        }

        UserProfile user = repository.getUserProfiles().stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-length", String.valueOf(file.getSize()));

        String path = String.format(
                "%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                user.getUserProfileId());

        String fileName = String.format(
                "%s-%s",
                file.getOriginalFilename(),
                UUID.randomUUID());

        try {
            fileStore.write(path, fileName, Optional.of(metadata), file.getInputStream());
            user.setUserProfileDataLink(fileName);
        } catch (IOException e) {
            throw new IllegalStateException("File can not be uploaded.",e);
        }
    }

    public byte[] downloadUserProfileData(UUID userProfileId) {

        UserProfile user = repository.getUserProfiles().stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        String path = String.format(
                "%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                user.getUserProfileId());

        return user.getUserProfileDataLink()
                .map(key -> fileStore.read(path, key))
                .orElse(new byte[0]);
    }
}
