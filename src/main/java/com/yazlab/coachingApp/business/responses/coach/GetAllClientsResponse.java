package com.yazlab.coachingApp.business.responses.coach;

import com.yazlab.coachingApp.entities.concretes.Coach;
import com.yazlab.coachingApp.entities.concretes.NutritionPlan;
import com.yazlab.coachingApp.entities.concretes.Program;
import com.yazlab.coachingApp.entities.concretes.ProgressRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllClientsResponse {

    private int userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String email;
    private String phoneNumber;
    private String goal;

    private String profilePicture;
    private boolean isActive;
}
