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

    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;

    @Column(name = "goals", nullable = false)
    private String goals;

    @Column(name = "sets", nullable = false)
    private int sets;

    @Column(name = "repetitions", nullable = false)
    private int repetitions;

    @Column(name = "video_guide_url")
    private String videoGuideUrl;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "duration", nullable = false)
    private int duration;

}
