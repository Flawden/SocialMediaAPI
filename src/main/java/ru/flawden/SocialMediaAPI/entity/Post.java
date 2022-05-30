package ru.flawden.SocialMediaAPI.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String tag;
    private Long author_id;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "author_id")
//    private User author;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "reciever_id")
//    private User reciever;

    public Post(Long id, String text, String tag, Long author_id) {
        this.id = id;
        this.text = text;
        this.tag = tag;
        this.author_id = author_id;
    }

    public Post(String text, String tag, Long author_id) {
        this.text = text;
        this.tag = tag;
        this.author_id = author_id;
    }
}
