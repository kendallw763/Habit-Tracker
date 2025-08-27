package com.example.Habit.Tracker.Controller;

import com.example.Habit.Tracker.Model.HabitLogEntity;
import com.example.Habit.Tracker.Service.HabitLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habitLog")
public class HabitLogController {

   public final HabitLogService habitLogService;

   public HabitLogController (HabitLogService habitLogService){this.habitLogService = habitLogService;}

   @PostMapping
        public HabitLogEntity createHabitLog(@RequestBody HabitLogEntity habitLog){
            return habitLogService.createHabitLog(habitLog);}

    @GetMapping("{id}")
        public HabitLogEntity getHabitLogById (@PathVariable Long id){
            return habitLogService.getHabitLogById(id);}

    @DeleteMapping("/users/{id}")
        public ResponseEntity<Void> deleteHabitLogById (@PathVariable Long id){
            habitLogService.deleteHabitLogById(id);
                return ResponseEntity.noContent().build();
        }

    @GetMapping()
        public List<HabitLogEntity>getAllHabitLogs(){
            return habitLogService.getAllHabitLogs();
        }
}
