package com.yazlab.coachingApp.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="nutrition_plans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NutritionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private int planId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(name = "goal")
    private String goal;

    @Column(name = "meal")
    private String meal;

    @Column(name = "meal_day")
    private String mealDay;

    @Column(name = "calorie")
    private int calorie;

    @Column(name = "is_active")
    private boolean isActive;
}