package com.yazlab.coachingApp.business.abstracts;

import com.yazlab.coachingApp.business.requests.progressRecord.CreateProgressRecordRequest;
import com.yazlab.coachingApp.business.requests.progressRecord.UpdateProgressRecordRequest;
import com.yazlab.coachingApp.business.responses.progressRecord.GetAllProgressRecordsResponse;
import com.yazlab.coachingApp.business.responses.progressRecord.GetByIdProgressRecordResponse;

import java.util.List;

public interface ProgressRecordService {
    List<GetAllProgressRecordsResponse> getAll(int userId);
    void add(CreateProgressRecordRequest createProgressRecordRequest);
    void update(UpdateProgressRecordRequest updateProgressRecordRequest);
}
