package com.yazlab.coachingApp.dataAccess.abstracts;

import com.yazlab.coachingApp.entities.concretes.NutritionPlan;
import com.yazlab.coachingApp.entities.concretes.ProgressRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRecordRepository extends JpaRepository<ProgressRecord,Integer> {
    List<ProgressRecord> findByUser_UserId(int userId);
}
