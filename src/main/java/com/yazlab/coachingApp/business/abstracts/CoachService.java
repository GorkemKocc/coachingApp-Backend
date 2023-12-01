package com.yazlab.coachingApp.business.abstracts;

import com.yazlab.coachingApp.business.requests.coach.CreateCoachRequest;
import com.yazlab.coachingApp.business.requests.coach.UpdateCoachRequest;
import com.yazlab.coachingApp.business.responses.coach.GetAllClientsResponse;
import com.yazlab.coachingApp.business.responses.coach.GetAllCoachesResponse;
import com.yazlab.coachingApp.business.responses.coach.GetByIdCoachResponse;

import java.util.List;

public interface CoachService {
    List<GetAllCoachesResponse> getAll();
    GetByIdCoachResponse getById(int id);
    void add(CreateCoachRequest createCoachRequest);
    void update(UpdateCoachRequest updateCoachRequest);

    List<GetAllClientsResponse> getAllClients(int coachId);

}
