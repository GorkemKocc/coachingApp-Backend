package com.yazlab.coachingApp.business.responses.nutritionPlan;

import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdNutritionPlanResponse {private int planId;
    private User user;
    private String goals;
    private String dailyMeals;
    private int calorieTarget;
}
