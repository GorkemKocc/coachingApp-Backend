package com.yazlab.coachingApp.business.requests.program;

import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgramRequest {
    private int programId;
    private int userId;
    private String exercise;
    private String goal;
    private int sets;
    private int reps;
    private String videoGuideUrl;
    private Date startDate;
    private String duration;
    private boolean isActive;
}
