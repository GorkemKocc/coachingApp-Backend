package com.yazlab.coachingApp.business.requests.progressRecord;

import com.yazlab.coachingApp.entities.concretes.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgressRecordRequest {
    private int recordId;
    private int userId;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal bodyFatPercentage;
    private BigDecimal muscleMass;
    private BigDecimal bodyMassIndex;
    private Date recordDate;
}
