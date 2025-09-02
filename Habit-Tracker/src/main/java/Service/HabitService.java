package com.example.Habit.Tracker.Service;

import com.example.Habit.Tracker.Model.Habit;
import com.example.Habit.Tracker.Repositories.HabitRepository;
import com.example.Habit.Tracker.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit getHabitById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public void deleteHabitById(Long id) {
        if (!habitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Habit not found");
        }
        habitRepository.deleteById(id);
    }
}
