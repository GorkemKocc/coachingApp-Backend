package com.yazlab.coachingApp.business.requests.user;

import com.yazlab.coachingApp.entities.concretes.Coach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isActive = true;
    private int coachId;
    private String messages;
    private String profilePicture;
    private String goal;
}
