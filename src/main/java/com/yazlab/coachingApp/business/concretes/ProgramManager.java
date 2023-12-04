package com.yazlab.coachingApp.business.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yazlab.coachingApp.business.abstracts.ProgramService;
import com.yazlab.coachingApp.business.requests.program.CreateProgramRequest;
import com.yazlab.coachingApp.business.requests.program.UpdateProgramRequest;
import com.yazlab.coachingApp.business.responses.program.GetAllProgramsResponse;
import com.yazlab.coachingApp.business.responses.program.GetByUserIdProgramResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.ProgramRepository;
import com.yazlab.coachingApp.dataAccess.abstracts.UserRepository;
import com.yazlab.coachingApp.entities.concretes.Coach;
import com.yazlab.coachingApp.entities.concretes.Program;
import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramManager implements ProgramService {

    private ProgramRepository programRepository;
    private ModelMapperService modelMapperService;
    private final UserRepository userRepository;

    @Override
    public List<GetAllProgramsResponse> getAll(int userId) {
        List<Program> programs = programRepository.findByUser_UserId(userId);
        if (programs != null) {
            List<GetAllProgramsResponse> programsResponses = programs.stream()
                    .map(program -> this.modelMapperService.forResponse()
                            .map(program, GetAllProgramsResponse.class))
                    .collect(Collectors.toList());

            return programsResponses;
        } else {
            return Collections.emptyList(); // veya başka bir uygun değer
        }
    }

    @Override
    public void add(CreateProgramRequest createProgramRequest) {

        Program program = new Program();

        program.setGoal(createProgramRequest.getGoal());
        program.setExercise(createProgramRequest.getExercise());
        program.setStartDate(createProgramRequest.getStartDate());
        program.setSets(createProgramRequest.getSets());
        program.setReps(createProgramRequest.getReps());
        program.setVideoGuideUrl(createProgramRequest.getVideoGuideUrl());
        program.setGoal(createProgramRequest.getGoal());
        program.setDuration(createProgramRequest.getDuration());
        program.setActive(createProgramRequest.isActive());

        User user = userRepository.findById(createProgramRequest.getUserId()).orElseThrow();
        program.setUser(user);

        this.programRepository.save(program);
    }

    @Override
    public void update(UpdateProgramRequest updateProgramRequest) {

        Program program = this.modelMapperService.forRequest().map(updateProgramRequest,Program.class);
        this.programRepository.save(program);
    }
}
