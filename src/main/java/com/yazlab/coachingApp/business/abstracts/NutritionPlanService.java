package com.yazlab.coachingApp.business.abstracts;

import com.yazlab.coachingApp.business.requests.nutritionPlan.CreateNutritionPlanRequest;
import com.yazlab.coachingApp.business.requests.nutritionPlan.UpdateNutritionPlanRequest;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetAllNutritionPlansResponse;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetByIdNutritionPlanResponse;

import java.util.List;

public interface NutritionPlanService {
    List<GetAllNutritionPlansResponse> getAll(int userId);
   // GetByIdNutritionPlanResponse getById(int id);
    void add(CreateNutritionPlanRequest createNutritionPlanRequest);
    void update(UpdateNutritionPlanRequest updateNutritionPlanRequest);
}
