package com.yazlab.coachingApp.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="coaches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private int coachId;

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

    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "experience")
    private String experience;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "is_active")
    private boolean isActive;
}