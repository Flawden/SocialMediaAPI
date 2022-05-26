package ru.flawden.SocialMediaAPI.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "user_details")
@Data
public class UserDetail {

    @Id
    private Long id;
    private String firstname;
    private String lastname;

}
