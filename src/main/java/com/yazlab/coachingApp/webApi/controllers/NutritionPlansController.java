package com.yazlab.coachingApp.webApi.controllers;

import com.yazlab.coachingApp.business.abstracts.NutritionPlanService;
import com.yazlab.coachingApp.business.requests.nutritionPlan.CreateNutritionPlanRequest;
import com.yazlab.coachingApp.business.requests.nutritionPlan.UpdateNutritionPlanRequest;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetAllNutritionPlansResponse;
import com.yazlab.coachingApp.business.responses.nutritionPlan.GetByIdNutritionPlanResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutritionPlan")
@AllArgsConstructor
@CrossOrigin
public class NutritionPlansController {
    private NutritionPlanService nutritionPlanService;

    @GetMapping("getAll")
    public List<GetAllNutritionPlansResponse> getAll(){
        return nutritionPlanService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdNutritionPlanResponse getById(@PathVariable int id){
        return nutritionPlanService.getById(id);
    }

    @PostMapping("add")
    public void add(@RequestBody() CreateNutritionPlanRequest createNutritionPlanRequest)
    {
        this.nutritionPlanService.add(createNutritionPlanRequest);
    }
    @PutMapping("update")
    public void update(@RequestBody() UpdateNutritionPlanRequest createNutritionPlanRequest)
    {
        this.nutritionPlanService.update(createNutritionPlanRequest);
    }

}
