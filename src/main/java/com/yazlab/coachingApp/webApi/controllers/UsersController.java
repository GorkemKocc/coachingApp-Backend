package com.yazlab.coachingApp.webApi.controllers;

import com.yazlab.coachingApp.business.abstracts.UserService;
import com.yazlab.coachingApp.business.requests.user.CreateUserRequest;
import com.yazlab.coachingApp.business.requests.user.UpdateUserRequest;
import com.yazlab.coachingApp.business.responses.user.GetAllUsersResponse;
import com.yazlab.coachingApp.business.responses.user.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin
public class UsersController {
    private UserService userService;

    @GetMapping("getAll")
    public List<GetAllUsersResponse> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping("add")
    public void Add(@RequestBody() CreateUserRequest createUserRequest)
    {
        this.userService.add(createUserRequest);
    }
    @PutMapping("update")
    public void Update(@RequestBody() UpdateUserRequest updateUserRequest)
    {
        this.userService.update(updateUserRequest);
    }
}
