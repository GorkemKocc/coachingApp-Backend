package com.yazlab.coachingApp.business.responses.progressRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgressRecordsResponse {
    private int recordId;
    private int userId;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal bodyFatPercentage;
    private BigDecimal muscleMass;
    private BigDecimal bodyMassIndex;
    private Date recordDate;
}
