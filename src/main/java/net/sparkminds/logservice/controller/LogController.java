package net.sparkminds.logservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.sparkminds.logservice.service.KafkaListenerService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class LogController {

    private final KafkaListenerService kafkaListenerService;

    @KafkaListener(topics = "${kafka.topic_name}", groupId = "${kafka.group_id}")
    public void listener(String message) {
        kafkaListenerService.createLog(message);
    }
}
