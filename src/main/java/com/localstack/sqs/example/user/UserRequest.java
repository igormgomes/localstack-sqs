package com.localstack.sqs.example.user;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class UserRequest {

    @NotBlank
    private String id;
    @NotBlank
    private String name;
}