package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.NutritionPlanService;
import com.yazlab.coachingApp.business.requests.nutritionPlan.CreateNutritionPlanRequest;
import com.yazlab.coachingApp.business.requests.nutritionPlan.UpdateNutritionPlanRequest;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetAllNutritionPlansResponse;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetByIdNutritionPlanResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.NutritionPlanRepository;
import com.yazlab.coachingApp.dataAccess.abstracts.UserRepository;
import com.yazlab.coachingApp.entities.concretes.NutritionPlan;
import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NutritionPlanManager implements NutritionPlanService {
    private NutritionPlanRepository nutritionPlanRepository;
    private ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    @Override
    public List<GetAllNutritionPlansResponse> getAll(int userId) {
        List<NutritionPlan> nutritionPlans = nutritionPlanRepository.findByUser_UserId(userId);

        if(nutritionPlans != null){
            List<GetAllNutritionPlansResponse> plansResponse = nutritionPlans.stream()
                    .map(plan -> modelMapperService.forResponse()
                            .map(plan, GetAllNutritionPlansResponse.class))
                    .collect(Collectors.toList());
            return plansResponse;
        } else {
            return Collections.emptyList(); // veya başka bir uygun değer
        }
    }

    @Override
    public void add(CreateNutritionPlanRequest createNutritionPlanRequest) {

        NutritionPlan nutritionPlan = new NutritionPlan();

        nutritionPlan.setMeal(createNutritionPlanRequest.getMeal());
        nutritionPlan.setMealDay(createNutritionPlanRequest.getMealDay());
        nutritionPlan.setCalorie(createNutritionPlanRequest.getCalorie());
        nutritionPlan.setGoal(createNutritionPlanRequest.getGoal());
        nutritionPlan.setActive(createNutritionPlanRequest.isActive());

        User user = userRepository.findById(createNutritionPlanRequest.getUserId()).orElseThrow();
        nutritionPlan.setUser(user);

        nutritionPlanRepository.save(nutritionPlan);
    }

    @Override
    public void update(UpdateNutritionPlanRequest updateNutritionPlanRequest) {
        NutritionPlan nutritionPlan = modelMapperService.forRequest()
                .map(updateNutritionPlanRequest, NutritionPlan.class);

        nutritionPlanRepository.save(nutritionPlan);
    }
}
