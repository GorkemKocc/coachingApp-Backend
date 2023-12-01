package com.yazlab.coachingApp.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "progress_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgressRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int recordId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @Column(name = "height", nullable = false)
    private BigDecimal height;

    @Column(name = "body_fat_percentage")
    private BigDecimal bodyFatPercentage;

    @Column(name = "muscle_mass")
    private BigDecimal muscleMass;

    @Column(name = "body_mass_index")
    private BigDecimal bodyMassIndex;

    @Column(name = "record_date", nullable = false)
    private Date recordDate;
}
