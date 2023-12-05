package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.CoachService;
import com.yazlab.coachingApp.business.requests.coach.CreateCoachRequest;
import com.yazlab.coachingApp.business.requests.coach.UpdateCoachRequest;
import com.yazlab.coachingApp.business.responses.coach.GetAllClientsResponse;
import com.yazlab.coachingApp.business.responses.coach.GetAllCoachesResponse;
import com.yazlab.coachingApp.business.responses.coach.GetByIdCoachResponse;
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
public class CoachManager implements CoachService {

    private CoachRepository coachRepository;
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCoachesResponse> getAll() {
        List<Coach> coaches = coachRepository.findAll();

        List<GetAllCoachesResponse> coachesResponse = coaches.stream()
                .map(coach -> this.modelMapperService.forResponse()
                        .map(coach, GetAllCoachesResponse.class)).collect(Collectors.toList());

        return coachesResponse;
    }
    @Override
    public GetByIdCoachResponse getById(int id) {
        Coach coach = this.coachRepository.findById(id).orElseThrow();

        GetByIdCoachResponse response = this.modelMapperService.forResponse()
                .map(coach, GetByIdCoachResponse.class);
        return response;
    }
    @Override
    public void add(CreateCoachRequest createCoachRequest) {
        Coach coach = this.modelMapperService.forRequest().map(createCoachRequest,Coach.class);
        this.coachRepository.save(coach);
    }
    @Override
    public void update(UpdateCoachRequest updateCoachRequest) {

        Coach coach = this.modelMapperService.forRequest().map(updateCoachRequest,Coach.class);
        this.coachRepository.save(coach);
    }

    @Override
    public List<GetAllClientsResponse> getAllClients(int coachId) {

        List<User> users = userRepository.findByCoach_CoachId(coachId);
        List<GetAllClientsResponse> usersResponse = users.stream()
                .map(user -> modelMapperService.forResponse()
                        .map(user, GetAllClientsResponse.class)).collect(Collectors.toList());

        return usersResponse;
    }

}
