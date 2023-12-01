package com.yazlab.coachingApp.webApi.controllers;

import com.yazlab.coachingApp.business.abstracts.ProgramService;
import com.yazlab.coachingApp.business.abstracts.UserService;
import com.yazlab.coachingApp.business.requests.program.CreateProgramRequest;
import com.yazlab.coachingApp.business.requests.program.UpdateProgramRequest;
import com.yazlab.coachingApp.business.requests.user.CreateUserRequest;
import com.yazlab.coachingApp.business.requests.user.UpdateUserRequest;
import com.yazlab.coachingApp.business.responses.program.GetAllProgramsResponse;
import com.yazlab.coachingApp.business.responses.program.GetByIdProgramResponse;
import com.yazlab.coachingApp.business.responses.user.GetAllUsersResponse;
import com.yazlab.coachingApp.business.responses.user.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
@AllArgsConstructor
@CrossOrigin
public class ProgramsController {
    private ProgramService programService;

    @GetMapping("getAll")
    public List<GetAllProgramsResponse> getAll(){
        return programService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgramResponse getById(@PathVariable int id){
        return programService.getById(id);
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
