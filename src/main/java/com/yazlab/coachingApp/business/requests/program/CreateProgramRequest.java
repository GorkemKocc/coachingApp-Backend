package com.yazlab.coachingApp.business.requests.program;

import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgramRequest {
    private int userId;
    private String exerciseName;
    private String goals;
    private int sets;
    private int repetitions;
    private String videoGuideUrl;
    private Date startDate;
    private int duration;
}
