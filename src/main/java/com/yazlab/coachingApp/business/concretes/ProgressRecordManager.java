package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.ProgressRecordService;
import com.yazlab.coachingApp.business.requests.progressRecord.CreateProgressRecordRequest;
import com.yazlab.coachingApp.business.requests.progressRecord.UpdateProgressRecordRequest;
import com.yazlab.coachingApp.business.responses.progressRecord.GetAllProgressRecordsResponse;
import com.yazlab.coachingApp.business.responses.progressRecord.GetByIdProgressRecordResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.ProgressRecordRepository;
import com.yazlab.coachingApp.entities.concretes.ProgressRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgressRecordManager implements ProgressRecordService {

    private ProgressRecordRepository progressRecordRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllProgressRecordsResponse> getAll() {
        List<ProgressRecord> progressRecords = progressRecordRepository.findAll();

        List<GetAllProgressRecordsResponse> progressRecordsResponses = progressRecords.stream()
                .map(coach -> this.modelMapperService.forResponse()
                        .map(coach, GetAllProgressRecordsResponse.class)).collect(Collectors.toList());

        return progressRecordsResponses;
    }

    @Override
    public GetByIdProgressRecordResponse getById(int id) {
        ProgressRecord progressRecord = this.progressRecordRepository.findById(id).orElseThrow();

        GetByIdProgressRecordResponse progressRecordResponse = this.modelMapperService.forResponse()
                .map(progressRecord, GetByIdProgressRecordResponse.class);
        return progressRecordResponse;
    }

    @Override
    public void add(CreateProgressRecordRequest createProgressRecordRequest) {
        ProgressRecord progressRecord = this.modelMapperService.forRequest().map(createProgressRecordRequest,ProgressRecord.class);
        this.progressRecordRepository.save(progressRecord);
    }

    @Override
    public void update(UpdateProgressRecordRequest updateProgressRecordRequest) {
        ProgressRecord progressRecord = this.modelMapperService.forRequest().map(updateProgressRecordRequest,ProgressRecord.class);
        this.progressRecordRepository.save(progressRecord);
    }
}
