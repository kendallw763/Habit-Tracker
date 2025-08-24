package com.example.Habit.Tracker.Repositories;

import com.example.Habit.Tracker.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long>{
    List<HabitEntity> findByUserId(Long id);
}
