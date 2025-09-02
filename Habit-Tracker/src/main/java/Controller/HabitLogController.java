package com.example.Habit.Tracker.Controller;

import com.example.Habit.Tracker.Dto.HabitLogDto;
import com.example.Habit.Tracker.Model.HabitLog;
import com.example.Habit.Tracker.Service.HabitLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/habitLog")
public class HabitLogController {

    private final HabitLogService habitLogService;

    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;
    }

    private HabitLogDto toDto (HabitLog habitLog){
        HabitLogDto dto = new HabitLogDto();
        dto.setId(habitLog.getId());
        dto.setNote(habitLog.getNote());
        return dto;
    }

    @PostMapping
    public ResponseEntity<HabitLogDto>createHabitLog(@RequestBody HabitLogDto habitLogDto){
        HabitLog habitLog = new HabitLog();
        habitLog.setNote(habitLogDto.getNote());
        HabitLog save = habitLogService.createHabitLog(habitLog);
        return ResponseEntity.ok(toDto(save));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitLogDto> getHabitLogById(@PathVariable Long id) {
        HabitLog habitLog = habitLogService.getHabitLogById(id);
        return ResponseEntity.ok(toDto(habitLog));
    }

    @GetMapping
    public ResponseEntity<List<HabitLogDto>> getAllHabitLogs() {
        List<HabitLogDto> notes = habitLogService.getAllHabitLogs()
                .stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(notes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitLogDto> updateHabitLog(
            @PathVariable Long id,
            @RequestBody HabitLogDto updatedHabitLog)
    {
        HabitLog habitLog = habitLogService.getHabitLogById(id);

        if (updatedHabitLog.getNote() != null) habitLog.setNote(updatedHabitLog.getNote());

        HabitLog saved = habitLogService.createHabitLog(habitLog);
        return ResponseEntity.ok(toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitLogById(@PathVariable Long id) {
        habitLogService.deleteHabitLogById(id);
        return ResponseEntity.noContent().build();
    }
}
