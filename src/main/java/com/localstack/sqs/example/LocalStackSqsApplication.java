package com.localstack.sqs.example;

import com.localstack.sqs.example.user.UserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UserProperties.class)
public class LocalStackSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalStackSqsApplication.class, args);
	}

}
