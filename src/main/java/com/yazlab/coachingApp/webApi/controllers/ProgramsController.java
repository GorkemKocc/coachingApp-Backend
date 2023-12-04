package com.yazlab.coachingApp.webApi.controllers;

import com.yazlab.coachingApp.business.abstracts.ProgramService;
import com.yazlab.coachingApp.business.requests.program.CreateProgramRequest;
import com.yazlab.coachingApp.business.requests.program.UpdateProgramRequest;
import com.yazlab.coachingApp.business.responses.program.GetAllProgramsResponse;
import com.yazlab.coachingApp.business.responses.program.GetByUserIdProgramResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
@AllArgsConstructor
@CrossOrigin
public class ProgramsController {
    private ProgramService programService;

    @GetMapping("/{id}")
    public List<GetAllProgramsResponse> getAll(int userId){
        return programService.getAll(userId);
    }

    @PostMapping("add")
    public void Add(@RequestBody() CreateProgramRequest createProgramRequest)
    {
        this.programService.add(createProgramRequest);
    }
    @PutMapping("update")
    public void Update(@RequestBody() UpdateProgramRequest updateProgramRequest)
    {
        this.programService.update(updateProgramRequest);
    }
}
