package com.example.Habit.Tracker.Controller;

import com.example.Habit.Tracker.Dto.HabitDto;
import com.example.Habit.Tracker.Model.Habit;
import com.example.Habit.Tracker.Service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

        private HabitDto toDto(Habit habit) {
        HabitDto dto = new HabitDto();
        dto.setId(habit.getId());
        dto.setHabit(habit.getHabit());
        return dto;
    }

  @PostMapping
    public ResponseEntity<HabitDto> createHabit(@RequestBody HabitDto habitDto) {
        Habit habit = new Habit();
        habit.setHabit(habitDto.getHabit());
        Habit saved = habitService.createHabit(habit);
        return ResponseEntity.ok(toDto(saved));
    }

    // Get habits by ID
    @GetMapping("/{id}")
    public ResponseEntity<HabitDto> getHabitById(@PathVariable Long id) {
        Habit habit = habitService.getHabitById(id);
        return ResponseEntity.ok(toDto(habit));
    }

    //Get all habits
    @GetMapping
    public ResponseEntity<List<HabitDto>> getAllHabits() {
        List<HabitDto> habits = habitService.getAllHabits()
                .stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(habits);
    }

    //Update habits
    @PutMapping("/{id}")
    public ResponseEntity<HabitDto> updateHabit(
            @PathVariable Long id,
            @RequestBody HabitDto updatedHabit
    ) {
        Habit habit = habitService.getHabitById(id);

        if (updatedHabit.getHabit() != null) habit.setHabit(updatedHabit.getHabit());

        Habit saved = habitService.createHabit(habit);
        return ResponseEntity.ok(toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        habitService.deleteHabitById(id);
        return ResponseEntity.noContent().build();
    }
}
