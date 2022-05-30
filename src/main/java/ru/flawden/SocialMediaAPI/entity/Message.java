package ru.flawden.SocialMediaAPI.entity;

import lombok.*;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.repository.MessageRepository;

import javax.persistence.*;
import java.util.Optional;

@Entity
@NoArgsConstructor
@Data
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String tag;
    private Long author_id;
    private Long reciever_id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "author_id")
//    private User author;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "reciever_id")
//    private User reciever;

    public Message(Long id, String text, String tag, Long author_id, Long reciever_id) {
        this.id = id;
        this.text = text;
        this.tag = tag;
        this.author_id = author_id;
        this.reciever_id = reciever_id;
    }

    public Message(String text, String tag, Long author_id, Long reciever_id) {
        this.text = text;
        this.tag = tag;
        this.author_id = author_id;
        this.reciever_id = reciever_id;
    }
}
