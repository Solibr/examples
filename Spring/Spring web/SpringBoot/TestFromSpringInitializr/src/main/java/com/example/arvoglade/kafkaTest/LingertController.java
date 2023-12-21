package com.example.arvoglade.kafkaTest;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LingertController {

    public final KafkaTemplate<String, String> kafkaTemplate;

    public static List<String> messageList = new ArrayList<>();

    @GetMapping("/kafka/{message}")
    public String postInKafkaByGetRequest(@PathVariable String message) {
        kafkaTemplate.send("first", message);
        return "done";
    }

    @KafkaListener(topics = "first", groupId = "1")
    public void listner(String message) {
        messageList.add(message);
    }

    @GetMapping("/kafka/getAll")
    public List<String> getAll() {
        return messageList;
    }
}
