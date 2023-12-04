package com.yazlab.coachingApp.dataAccess.abstracts;

import com.yazlab.coachingApp.entities.concretes.Program;
import com.yazlab.coachingApp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program,Integer> {
    List<Program> findByUser_UserId(int userId);
}
