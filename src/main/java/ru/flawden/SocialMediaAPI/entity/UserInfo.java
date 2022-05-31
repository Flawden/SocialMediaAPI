package ru.flawden.SocialMediaAPI.entity;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "user_info")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
    @Column(name = "phone_number")
    private String phoneNumber;
    private LocalDate birthdate;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserInfo() {}


    public UserInfo(String firstname, String lastname,String phoneNumber, String birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.birthdate = LocalDate.parse(birthdate);
    }

    public UserInfo(String firstname, String lastname, String middlename,String phoneNumber, String birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.phoneNumber = phoneNumber;
        this.birthdate = LocalDate.parse(birthdate);
    }

}