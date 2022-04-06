package com.mmutawe.explore.awsdemo.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {

    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3) {
//        System.out.println("******");
        this.s3 = s3;
    }

    public void save(
            String path,
            String fileName,
            Optional<Map<String, String>> optionalMetaData,
            InputStream inputStream) {

        ObjectMetadata objectMetadata = new ObjectMetadata();
        optionalMetaData.ifPresent(
                map -> {
                    if(!map.isEmpty()){
                        map.forEach(objectMetadata::addUserMetadata);
                    }
                }
        );

        try {
            s3.putObject(path, fileName, inputStream, objectMetadata);
        } catch (AmazonServiceException exception){
            throw new IllegalStateException("Unable to store data to S3.", exception);
        }
    }
}
