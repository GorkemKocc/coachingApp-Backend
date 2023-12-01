package com.yazlab.coachingApp.business.requests.user;

import com.yazlab.coachingApp.entities.concretes.Coach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePicture;
    private int coachId;
    private boolean isActive;
}
