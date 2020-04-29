package com.localstack.sqs.example.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
class UserConsumerRequest {

    private String id;
    private String name;
}