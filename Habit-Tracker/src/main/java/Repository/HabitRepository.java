package com.example.Habit.Tracker.Repositories;

import com.example.Habit.Tracker.Model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {}
