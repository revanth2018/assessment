package com.charterassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.charterassessment.entity"})
public class CharterAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharterAssessmentApplication.class, args);
    }

}
