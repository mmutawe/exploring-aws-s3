package com.mmutawe.explore.awsdemo.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {
    private UUID userProfileId;
    private String username;
    private String userProfileDataLink;

    public UserProfile(UUID userProfileId, String username, String userProfileDataLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileDataLink = userProfileDataLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserProfileDataLink() {
        return Optional.ofNullable(userProfileDataLink);
    }

    public void setUserProfileDataLink(String userProfileDataLink) {
        this.userProfileDataLink = userProfileDataLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfile that = (UserProfile) o;

        if (!userProfileId.equals(that.userProfileId)) return false;
        if (!Objects.equals(username, that.username)) return false;
        return Objects.equals(userProfileDataLink, that.userProfileDataLink);
    }

    @Override
    public int hashCode() {
        int result = userProfileId.hashCode();
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userProfileDataLink != null ? userProfileDataLink.hashCode() : 0);
        return result;
    }
}
