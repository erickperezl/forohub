// src/main/java/com/foro/hub/TopicController.java
package com.foro.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic, @AuthenticationPrincipal User user) {
        topic.setUserId(user.getId());
        return topicRepository.save(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
