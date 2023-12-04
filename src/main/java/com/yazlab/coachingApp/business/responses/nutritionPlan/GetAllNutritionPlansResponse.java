package com.yazlab.coachingApp.business.responses.nutritionPlan;

import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNutritionPlansResponse {

    private int planId;
    private int userId;
    private String goal;
    private String meal;
    private String mealDay;
    private int calorie;
    private boolean isActive;
}
