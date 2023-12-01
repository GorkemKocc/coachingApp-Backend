package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.ProgramService;
import com.yazlab.coachingApp.business.requests.program.CreateProgramRequest;
import com.yazlab.coachingApp.business.requests.program.UpdateProgramRequest;
import com.yazlab.coachingApp.business.responses.program.GetAllProgramsResponse;
import com.yazlab.coachingApp.business.responses.program.GetByIdProgramResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.ProgramRepository;
import com.yazlab.coachingApp.entities.concretes.Program;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramManager implements ProgramService {

    private ProgramRepository programRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllProgramsResponse> getAll() {
        List<Program> programs = programRepository.findAll();

        List<GetAllProgramsResponse> programsResponses = programs.stream()
                .map(program -> this.modelMapperService.forResponse()
                        .map(program, GetAllProgramsResponse.class)).collect(Collectors.toList());

        return programsResponses;
    }

    @Override
    public GetByIdProgramResponse getById(int id) {
        Program program = this.programRepository.findById(id).orElseThrow();

        GetByIdProgramResponse response = this.modelMapperService.forResponse()
                .map(program, GetByIdProgramResponse.class);
        return response;
    }

    @Override
    public void add(CreateProgramRequest createProgramRequest) {

        Program program = this.modelMapperService.forRequest().map(createProgramRequest,Program.class);
        this.programRepository.save(program);
    }

    @Override
    public void update(UpdateProgramRequest updateProgramRequest) {

        Program program = this.modelMapperService.forRequest().map(updateProgramRequest,Program.class);
        this.programRepository.save(program);
    }
}
