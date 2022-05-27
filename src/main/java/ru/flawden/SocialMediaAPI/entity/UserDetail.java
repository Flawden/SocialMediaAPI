package ru.flawden.SocialMediaAPI.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "user_details")
@Data
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserDetail() {}


    public UserDetail(User user, String firstname, String lastname) {
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDetail(Long id, User user, String firstname, String lastname) {
        this.id = id;
        this.user = user;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}