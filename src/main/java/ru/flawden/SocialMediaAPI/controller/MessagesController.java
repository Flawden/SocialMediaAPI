package ru.flawden.SocialMediaAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.flawden.SocialMediaAPI.MessageDTO;
import ru.flawden.SocialMediaAPI.entity.Message;
import ru.flawden.SocialMediaAPI.service.MessagesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessagesController {

    private MessagesService messagesService;

    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messagesService.getAllUsers();
    }

    @GetMapping("/{id}")
    public List<Message> getAllUsersFromUser(@PathVariable Long id) {
        return messagesService.getAllUsersFromUser(id);
    }

    @PostMapping
    public void addMessage(@RequestBody MessageDTO message, @RequestParam Long id1, Long id2) {
        messagesService.addMessage(message, id1, id2);
    }

}
