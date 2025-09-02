package com.example.Habit.Tracker.Service;

import com.example.Habit.Tracker.Model.HabitLog;
import com.example.Habit.Tracker.Repositories.HabitLogRepository;
import com.example.Habit.Tracker.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitLogService {

    private final HabitLogRepository habitLogRepository;

    public HabitLogService(HabitLogRepository habitLogRepository) {
        this.habitLogRepository = habitLogRepository;
    }

    public HabitLog createHabitLog(HabitLog habitLog) {
        return habitLogRepository.save(habitLog);
    }

    public HabitLog getHabitLogById(Long id) {
        return habitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HabitLog not found"));
    }

    public List<HabitLog> getAllHabitLogs() {
        return habitLogRepository.findAll();
    }

    public void deleteHabitLogById(Long id) {
        if (!habitLogRepository.existsById(id)) {
            throw new ResourceNotFoundException("HabitLog not found");
        }
        habitLogRepository.deleteById(id);
    }
}
