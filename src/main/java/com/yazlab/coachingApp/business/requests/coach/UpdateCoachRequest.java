package com.yazlab.coachingApp.business.requests.coach;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCoachRequest {

    private int coachId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private byte[] profilePicture;
    private String specialization;
    private String experience;
    private String contactInfo;
    private boolean isActive;


}
