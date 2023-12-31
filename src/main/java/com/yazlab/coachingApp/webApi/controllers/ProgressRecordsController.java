package com.yazlab.coachingApp.webApi.controllers;

import com.yazlab.coachingApp.business.abstracts.ProgressRecordService;
import com.yazlab.coachingApp.business.requests.progressRecord.CreateProgressRecordRequest;
import com.yazlab.coachingApp.business.requests.progressRecord.UpdateProgressRecordRequest;
import com.yazlab.coachingApp.business.responses.progressRecord.GetAllProgressRecordsResponse;
import com.yazlab.coachingApp.business.responses.progressRecord.GetByIdProgressRecordResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progressRecord")
@AllArgsConstructor
@CrossOrigin
public class ProgressRecordsController {
    private ProgressRecordService progressRecordService;

    @GetMapping("/{id}")
    public List<GetAllProgressRecordsResponse> getAll(int userId){
        return progressRecordService.getAll(userId);
    }

    @PostMapping("add")
    public void coachAdd(@RequestBody() CreateProgressRecordRequest createProgressRecordRequest)
    {
        this.progressRecordService.add(createProgressRecordRequest);
    }
    @PutMapping("update")
    public void coachUpdate(@RequestBody() UpdateProgressRecordRequest updateProgressRecordRequest)
    {
        this.progressRecordService.update(updateProgressRecordRequest);
    }
}
