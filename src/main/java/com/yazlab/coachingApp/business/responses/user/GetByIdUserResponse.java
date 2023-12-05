package com.yazlab.coachingApp.business.responses.user;

import com.yazlab.coachingApp.entities.concretes.Coach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdUserResponse {

    private int userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private byte[] profilePicture;
    private boolean isActive;
    private Coach coach;
    private String goal;
}

