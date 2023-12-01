package com.yazlab.coachingApp.business.requests.progressRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgressRecordRequest {
    private int userId;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal bodyFatPercentage;
    private BigDecimal muscleMass;
    private BigDecimal bodyMassIndex;
    private Date recordDate;
}
