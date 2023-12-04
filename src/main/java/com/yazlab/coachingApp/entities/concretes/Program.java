package com.yazlab.coachingApp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name="programs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private int programId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(name = "exercise", nullable = false)
    private String exercise;

    @Column(name = "goal", nullable = false)
    private String goal;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "sets", nullable = false)
    private int sets;

    @Column(name = "reps", nullable = false)
    private int reps;

    @Column(name = "video_guide_url")
    private String videoGuideUrl;

    @Column(name = "is_active")
    private boolean isActive;
}
