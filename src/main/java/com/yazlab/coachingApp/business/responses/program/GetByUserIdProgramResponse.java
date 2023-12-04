package com.yazlab.coachingApp.business.responses.program;

import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdProgramResponse {
    private int programId;
    private User user;
    private String exerciseName;
    private String goals;
    private int sets;
    private int reps;
    private String videoGuideUrl;
    private Date startDate;
    private String duration;
    private boolean isActive;

}
