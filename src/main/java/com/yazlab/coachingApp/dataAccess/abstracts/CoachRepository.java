package com.yazlab.coachingApp.dataAccess.abstracts;

import com.yazlab.coachingApp.entities.concretes.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach,Integer> {

}
