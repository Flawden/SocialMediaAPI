
package ru.flawden.SocialMediaAPI.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private UserInfo userInfo;

    @OneToMany
    private List<User> subscribers;

    public User(String email, String password, UserInfo userInfo){
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
    }

    public User(Long id, String email, String password, UserInfo userInfo) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
    }

    public void addSubscriber(User user) {
        subscribers.add(user);
    }

}