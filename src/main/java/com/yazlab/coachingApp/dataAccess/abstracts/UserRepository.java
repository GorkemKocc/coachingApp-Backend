package com.yazlab.coachingApp.dataAccess.abstracts;

import com.yazlab.coachingApp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByCoach_CoachId(int coachId);

}
