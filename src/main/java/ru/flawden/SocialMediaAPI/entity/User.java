package ru.flawden.SocialMediaAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "usrs")
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User() {

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
