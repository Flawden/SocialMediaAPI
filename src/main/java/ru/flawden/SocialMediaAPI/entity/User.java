
package ru.flawden.SocialMediaAPI.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "t_user")
@Data
@NoArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @OneToMany
    private List<User> subscribers;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void addSubscriber(User user) {
        subscribers.add(user);
    }

}