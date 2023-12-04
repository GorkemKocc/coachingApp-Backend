package com.yazlab.coachingApp.dataAccess.abstracts;

import com.yazlab.coachingApp.entities.concretes.NutritionPlan;
import com.yazlab.coachingApp.entities.concretes.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NutritionPlanRepository extends JpaRepository<NutritionPlan,Integer> {
    List<NutritionPlan> findByUser_UserId(int userId);
}
