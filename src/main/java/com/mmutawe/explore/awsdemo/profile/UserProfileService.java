package com.mmutawe.explore.awsdemo.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDataAccessRepository repository;

    @Autowired
    public UserProfileService(UserProfileDataAccessRepository repository) {
        this.repository = repository;
    }

    List<UserProfile> getUserProfiles(){
        return repository.getUserProfiles();
    }

    public void uploadUserProfileData(UUID userProfileId, MultipartFile file) {

    }
}
