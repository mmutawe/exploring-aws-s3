package com.mmutawe.explore.awsdemo.profile;

import com.mmutawe.explore.awsdemo.datastore.UserProfileMockedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataAccessRepository {

    private final UserProfileMockedRepository userProfileMockedRepository;

    @Autowired
    public UserProfileDataAccessRepository(UserProfileMockedRepository userProfileMockedRepository) {
        this.userProfileMockedRepository = userProfileMockedRepository;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileMockedRepository.getUserProfiles();
    }
}
