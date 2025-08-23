package com.example.Habit.Tracker.Repositories;

import com.example.Habit.Tracker.Model.HabitLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HabitLogRepository extends JpaRepository<HabitLogEntity, Long> {
    List<HabitLogEntity> findByHabitId(Long id);
}
