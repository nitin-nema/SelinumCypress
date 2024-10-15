package com.example.SelinumCypress;

import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaE2ETest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String messageReceived;

    @KafkaListener(topics = "test-topic")
    public void listen(String message) {
        this.messageReceived = message;
    }

    @Test
    public void testKafkaMessageFlow() {
        kafkaTemplate.send("test-topic", "Hello World");

        // Wait for listener to receive the message
        await().until(() -> messageReceived.equals("Hello World"));
    }
}
