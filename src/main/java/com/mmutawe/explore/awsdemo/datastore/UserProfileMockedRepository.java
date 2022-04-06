package com.mmutawe.explore.awsdemo.datastore;


import com.mmutawe.explore.awsdemo.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileMockedRepository {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(
                UUID.randomUUID(),
                "Kuriboh",
                null));

        USER_PROFILES.add(new UserProfile(
                UUID.randomUUID(),
                "Meepo",
                null));

    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
