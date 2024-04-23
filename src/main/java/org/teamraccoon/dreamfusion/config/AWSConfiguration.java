package org.teamraccoon.dreamfusion.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Getter
@Configuration
public class AWSConfiguration {

    @Value(value = "${aws-bucket-name}")
    private String awsBucket;

    public S3Client createS3Client() {
        Region region = Region.EU_WEST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        return s3;
    }

}
