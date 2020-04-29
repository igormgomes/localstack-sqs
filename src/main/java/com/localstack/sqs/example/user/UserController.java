package com.localstack.sqs.example.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserProducer userProducer;

    @PostMapping
    public ResponseEntity publish(@Valid @RequestBody UserRequest userRequest) {
        this.userProducer.publish(userRequest);
        return ResponseEntity.accepted().build();
    }
}