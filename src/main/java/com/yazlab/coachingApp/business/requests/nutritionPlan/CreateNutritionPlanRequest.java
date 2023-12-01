package com.yazlab.coachingApp.business.requests.nutritionPlan;

import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNutritionPlanRequest {

    private int userId;
    private String goals;
    private String dailyMeals;
    private int calorieTarget;
}
