package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.NutritionPlanService;
import com.yazlab.coachingApp.business.requests.nutritionPlan.CreateNutritionPlanRequest;
import com.yazlab.coachingApp.business.requests.nutritionPlan.UpdateNutritionPlanRequest;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetAllNutritionPlansResponse;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetByIdNutritionPlanResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.NutritionPlanRepository;
import com.yazlab.coachingApp.entities.concretes.NutritionPlan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NutritionPlanManager implements NutritionPlanService {
    private NutritionPlanRepository nutritionPlanRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllNutritionPlansResponse> getAll() {
        List<NutritionPlan> nutritionPlans = nutritionPlanRepository.findAll();

        List<GetAllNutritionPlansResponse> plansResponse = nutritionPlans.stream()
                .map(plan -> modelMapperService.forResponse()
                        .map(plan, GetAllNutritionPlansResponse.class))
                .collect(Collectors.toList());

        return plansResponse;
    }

    @Override
    public GetByIdNutritionPlanResponse getById(int id) {
        NutritionPlan nutritionPlan = nutritionPlanRepository.findById(id).orElseThrow();

        GetByIdNutritionPlanResponse response = modelMapperService.forResponse()
                .map(nutritionPlan, GetByIdNutritionPlanResponse.class);

        return response;
    }

    @Override
    public void add(CreateNutritionPlanRequest createNutritionPlanRequest) {
        NutritionPlan nutritionPlan = modelMapperService.forRequest()
                .map(createNutritionPlanRequest, NutritionPlan.class);

        nutritionPlanRepository.save(nutritionPlan);
    }

    @Override
    public void update(UpdateNutritionPlanRequest updateNutritionPlanRequest) {
        NutritionPlan nutritionPlan = modelMapperService.forRequest()
                .map(updateNutritionPlanRequest, NutritionPlan.class);

        nutritionPlanRepository.save(nutritionPlan);
    }
}
