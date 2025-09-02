package com.example.Habit.Tracker.Repositories;

import com.example.Habit.Tracker.Model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {}
