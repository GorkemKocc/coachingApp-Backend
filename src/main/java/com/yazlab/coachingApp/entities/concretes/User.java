package com.yazlab.coachingApp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;



@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

   // @Column(name = "messages", columnDefinition = "jsonb")
    //private List<Message> messages;

    @Column(name = "profile_picture")
    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "coach", referencedColumnName = "coach_id")
    private Coach coach;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "goal")
    private String goal;

   }
