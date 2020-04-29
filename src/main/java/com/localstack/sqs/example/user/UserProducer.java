package com.localstack.sqs.example.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class UserProducer {

    private final QueueMessagingTemplate messageTemplate;
    private final UserProperties userConfiguration;

    public void publish(UserRequest userRequest) {
        var producerQueue = this.userConfiguration.getProducerQueue();
        log.info("Sending to queue={}, body={}", producerQueue, userRequest);
        this.messageTemplate.convertAndSend(producerQueue, userRequest);
    }
}