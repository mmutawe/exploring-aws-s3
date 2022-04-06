package com.mmutawe.explore.awsdemo.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
