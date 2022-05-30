package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.MessageDTO;
import ru.flawden.SocialMediaAPI.entity.Message;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.repository.MessageRepository;
import ru.flawden.SocialMediaAPI.repository.UserRepository;

import java.util.List;

@Service
public class MessagesService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessagesService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }
    public List<Message> getAllUsers() {
        return messageRepository.findAll();
    }

    public void addMessage(MessageDTO message, Long id1, Long id2) {
        User u1 = userRepository.findById(id1).orElseThrow(() -> new RuntimeException());
        User u2 = userRepository.findById(id2).orElseThrow(() -> new RuntimeException());

        Message newMessage = new Message(message.getText(), message.getTag(), u1.getId(), u2.getId());
        messageRepository.save(newMessage);
    }

    public List<Message> getAllUsersFromUser(Long id) {
        return messageRepository.findByAuthorid(id);
    }
}
