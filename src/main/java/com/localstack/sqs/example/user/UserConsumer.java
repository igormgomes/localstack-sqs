package com.localstack.sqs.example.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class UserConsumer {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @SqsListener(value = "${user.producer-queue}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void consume(String payload, MessageHeaders messageHeaders, Acknowledgment acknowledgment) {
        log.info("message={}", payload);
        log.info("headers={}", messageHeaders);

        var userConsumerRequest = this.objectMapper.readValue(payload, UserConsumerRequest.class);
        log.info("User={}", userConsumerRequest);

        acknowledgment.acknowledge();
    }
}
