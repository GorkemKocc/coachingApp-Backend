package com.yazlab.coachingApp.business.responses.program;

import com.yazlab.coachingApp.entities.concretes.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgramsResponse {
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
