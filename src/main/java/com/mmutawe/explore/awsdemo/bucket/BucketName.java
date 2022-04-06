package com.mmutawe.explore.awsdemo.bucket;

public enum BucketName {

    PROFILE_IMAGE("mmutawe-images-test-001");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
