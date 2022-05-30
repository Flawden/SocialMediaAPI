package ru.flawden.SocialMediaAPI.controller;

import org.springframework.web.bind.annotation.*;
import ru.flawden.SocialMediaAPI.dto.MessageDTO;
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
    public List<Message> getAllMessagesFromUser(@PathVariable Long id) {
        return messagesService.getAllUsersFromUser(id);
    }

    @PostMapping
    public void addMessage(@RequestBody MessageDTO message, @RequestParam Long author_id, Long reciever_id) {
        messagesService.addMessage(message, author_id, reciever_id);
    }

}
