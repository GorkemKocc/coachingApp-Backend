package com.yazlab.coachingApp.webApi.controllers;

import com.yazlab.coachingApp.business.abstracts.CoachService;
import com.yazlab.coachingApp.business.requests.coach.CreateCoachRequest;
import com.yazlab.coachingApp.business.requests.coach.UpdateCoachRequest;
import com.yazlab.coachingApp.business.responses.coach.GetAllClientsResponse;
import com.yazlab.coachingApp.business.responses.coach.GetAllCoachesResponse;
import com.yazlab.coachingApp.business.responses.coach.GetByIdCoachResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
@AllArgsConstructor
@CrossOrigin
public class CoachesController {
    private CoachService coachService;

    @GetMapping("getAll")
    public List<GetAllCoachesResponse> getAll(){
        return coachService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCoachResponse getById(@PathVariable int id){
        return coachService.getById(id);
    }

    @PostMapping("add")
    public void coachAdd(@RequestBody() CreateCoachRequest createCoachRequest)
    {
        this.coachService.add(createCoachRequest);
    }
    @PutMapping("update")
    public void coachUpdate(@RequestBody() UpdateCoachRequest updateCoachRequest)
    {
        this.coachService.update(updateCoachRequest);
    }
    @GetMapping("getAllClients/{coachId}")
    public List<GetAllClientsResponse> getAllClientsResponses(@PathVariable int coachId){
        return coachService.getAllClients(coachId);
    }
}
