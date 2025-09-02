package com.example.Habit.Tracker.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class HabitLogDto {

    private Long id;
    private String note;
}
