package com.example.Habit.Tracker.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.Habit.Tracker.Model.HabitEntity;
import com.example.Habit.Tracker.Repositories.HabitRepository;
import com.example.Habit.Tracker.Exception.ResourceNotFoundException;

@Service
public class HabitService {

    HabitRepository habitRepository;

    public HabitService (HabitRepository habitRepository) {this.habitRepository = habitRepository;}

    public HabitEntity createHabit(HabitEntity habitEntity){return habitRepository.save(habitEntity);}

    public HabitEntity getHabitById(Long id){return habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit id not found"));}

    public List<HabitEntity> getAllHabits(){return habitRepository.findAll();}
}
