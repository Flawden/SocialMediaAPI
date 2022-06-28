package ru.flawden.SocialMediaAPI.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    private String fileName;
    private Date departure_date;
    private Long author_id;

    @PrePersist
    private void created() {
        departure_date = new Date();
    }

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

    public Post(String text, String tag, Long author_id, String fileName) {
        this.text = text;
        this.tag = tag;
        this.author_id = author_id;
        this.fileName = fileName;
    }
}
