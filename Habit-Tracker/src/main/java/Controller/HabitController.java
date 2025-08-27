package com.example.Habit.Tracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Habit.Tracker.Model.HabitEntity;
import com.example.Habit.Tracker.Service.HabitService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    public final HabitService habitService;

    public HabitController (HabitService habitService){this.habitService = habitService;}

    @PostMapping
    public HabitEntity createHabit(@RequestBody HabitEntity habit){return habitService.createHabit(habit);}

    @GetMapping("{id}")
    public HabitEntity getHabitById (@PathVariable Long id){return habitService.getHabitById(id);}

    @DeleteMapping("/users/{id}")
        public ResponseEntity<Void> deleteHabitById (@PathVariable Long id){habitService.deleteHabitById(id);
            return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public List<HabitEntity>getAllHabit(){
        return habitService.getAllHabits();
    }

}
