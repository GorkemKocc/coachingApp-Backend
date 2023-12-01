package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.UserService;
import com.yazlab.coachingApp.business.requests.user.CreateUserRequest;
import com.yazlab.coachingApp.business.requests.user.UpdateUserRequest;
import com.yazlab.coachingApp.business.responses.user.GetAllUsersResponse;
import com.yazlab.coachingApp.business.responses.user.GetByIdUserResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.CoachRepository;
import com.yazlab.coachingApp.dataAccess.abstracts.UserRepository;
import com.yazlab.coachingApp.entities.concretes.Coach;
import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final CoachRepository coachRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAll();

        List<GetAllUsersResponse> usersResponse = users.stream()
                .map(user -> modelMapperService.forResponse()
                        .map(user, GetAllUsersResponse.class)).collect(Collectors.toList());

        return usersResponse;
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        GetByIdUserResponse response = modelMapperService.forResponse()
                .map(user, GetByIdUserResponse.class);
        return response;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = modelMapperService.forRequest().map(createUserRequest, User.class);

        Coach coach = coachRepository.findById(createUserRequest.getCoachId()).orElseThrow();
        user.setCoachId(coach);

        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = modelMapperService.forRequest().map(updateUserRequest, User.class);
        userRepository.save(user);
    }
}
