package com.yazlab.coachingApp.business.concretes;

import com.yazlab.coachingApp.business.abstracts.ProgressRecordService;
import com.yazlab.coachingApp.business.requests.progressRecord.CreateProgressRecordRequest;
import com.yazlab.coachingApp.business.requests.progressRecord.UpdateProgressRecordRequest;
import com.yazlab.coachingApp.business.responses.progressRecord.GetAllProgressRecordsResponse;
import com.yazlab.coachingApp.business.responses.progressRecord.GetByIdProgressRecordResponse;
import com.yazlab.coachingApp.core.utilities.mappers.ModelMapperService;
import com.yazlab.coachingApp.dataAccess.abstracts.ProgressRecordRepository;
import com.yazlab.coachingApp.dataAccess.abstracts.UserRepository;
import com.yazlab.coachingApp.entities.concretes.ProgressRecord;
import com.yazlab.coachingApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgressRecordManager implements ProgressRecordService {

    private ProgressRecordRepository progressRecordRepository;
    private ModelMapperService modelMapperService;
    private final UserRepository userRepository;

    @Override
    public List<GetAllProgressRecordsResponse> getAll(int userId) {
        List<ProgressRecord> progressRecords = progressRecordRepository.findByUser_UserId(userId);

        if (progressRecords != null) {
            List<GetAllProgressRecordsResponse> progressRecordsResponses = progressRecords.stream()
                    .map(coach -> this.modelMapperService.forResponse()
                            .map(coach, GetAllProgressRecordsResponse.class)).collect(Collectors.toList());

            return progressRecordsResponses;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void add(CreateProgressRecordRequest createProgressRecordRequest) {
        ProgressRecord progressRecord = new ProgressRecord();

        progressRecord.setBodyFatPercentage(createProgressRecordRequest.getBodyFatPercentage());
        progressRecord.setBodyMassIndex(createProgressRecordRequest.getBodyMassIndex());
        progressRecord.setHeight(createProgressRecordRequest.getHeight());
        progressRecord.setWeight(createProgressRecordRequest.getWeight());
        progressRecord.setMuscleMass(createProgressRecordRequest.getMuscleMass());
        progressRecord.setRecordDate(createProgressRecordRequest.getRecordDate());
        progressRecord.setActive(createProgressRecordRequest.isActive());

        User user = userRepository.findById(createProgressRecordRequest.getUserId()).orElseThrow();
        progressRecord.setUser(user);

        this.progressRecordRepository.save(progressRecord);
    }

    @Override
    public void update(UpdateProgressRecordRequest updateProgressRecordRequest) {
        ProgressRecord progressRecord = this.modelMapperService.forRequest().map(updateProgressRecordRequest,ProgressRecord.class);
        this.progressRecordRepository.save(progressRecord);
    }
}
