package com.mayank.kafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.kafka.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
	this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam String message) {
	producerService.sendMessage(message);
    }
}
