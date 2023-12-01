package com.yazlab.coachingApp.dataAccess.abstracts;

import com.yazlab.coachingApp.entities.concretes.ProgressRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRecordRepository extends JpaRepository<ProgressRecord,Integer> {
}
