package ru.flawden.SocialMediaAPI.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "user_info")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserInfo() {}


    public UserInfo(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserInfo(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}