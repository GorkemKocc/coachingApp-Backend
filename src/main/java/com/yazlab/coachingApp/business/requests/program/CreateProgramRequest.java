package com.yazlab.coachingApp.business.requests.program;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgramRequest {
    private int userId;
    private String exercise;
    private String goal;
    private int sets;
    private int reps;
    private String videoGuideUrl;
    private Date startDate;
    private String duration;
    private boolean isActive = true;
}
