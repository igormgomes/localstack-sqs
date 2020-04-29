package com.localstack.sqs.example.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    private String producerQueue;
}
