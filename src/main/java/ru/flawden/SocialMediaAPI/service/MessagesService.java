package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.dto.MessageDTO;
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

    public void addMessage(MessageDTO message, Long author_id, Long reciever_id) {
        User author = userRepository.findById(author_id).orElseThrow(() -> new RuntimeException());
        User recoever = userRepository.findById(reciever_id).orElseThrow(() -> new RuntimeException());

        Message newMessage = new Message(message.getText(), message.getTag(), author.getId(), recoever.getId());
        messageRepository.save(newMessage);
    }

    public List<Message> getAllUsersFromUser(Long id) {
        return messageRepository.findByAuthorid(id);
    }
}
