package com.yazlab.coachingApp.business.abstracts;



import com.yazlab.coachingApp.business.requests.user.CreateUserRequest;
import com.yazlab.coachingApp.business.requests.user.UpdateUserRequest;
import com.yazlab.coachingApp.business.responses.user.GetAllUsersResponse;
import com.yazlab.coachingApp.business.responses.user.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUsersResponse> getAll();
    GetByIdUserResponse getById(int id);
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateCoachRequest);
}
