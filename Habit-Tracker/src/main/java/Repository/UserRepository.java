package com.example.Habit.Tracker.Repositories;

import com.example.Habit.Tracker.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepository extends JpaRepository<UserEntity, Long>{}

