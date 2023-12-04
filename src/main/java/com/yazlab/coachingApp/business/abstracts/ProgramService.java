package com.yazlab.coachingApp.business.abstracts;

import com.yazlab.coachingApp.business.requests.program.CreateProgramRequest;
import com.yazlab.coachingApp.business.requests.program.UpdateProgramRequest;
import com.yazlab.coachingApp.business.responses.program.GetAllProgramsResponse;
import com.yazlab.coachingApp.business.responses.program.GetByUserIdProgramResponse;

import java.util.List;

public interface ProgramService {
    List<GetAllProgramsResponse> getAll(int userId);
  //  GetByUserIdProgramResponse getByUserId(int userId);
    void add(CreateProgramRequest createProgramRequest);
    void update(UpdateProgramRequest updateProgramRequest);
}
