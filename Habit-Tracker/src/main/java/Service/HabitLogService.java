package com.example.Habit.Tracker.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.Habit.Tracker.Model.HabitLogEntity;
import com.example.Habit.Tracker.Repositories.HabitLogRepository;
import com.example.Habit.Tracker.Exception.ResourceNotFoundException;

@Service
public class HabitLogService {

    HabitLogRepository habitLogRepository;

    public HabitLogService (HabitLogRepository habitLogRepository)
    {this.habitLogRepository = habitLogRepository;}

    public HabitLogEntity createHabitLog(HabitLogEntity habitLogEntity)
    {return habitLogRepository.save(habitLogEntity);}

    public HabitLogEntity getHabitLogById(Long id){return habitLogRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Habit log id not found"));}

    //implement delete functionality
    public void deleteHabitLogById(Long id){
        if(!habitLogRepository.existsById(id)){
            throw new ResourceNotFoundException("Habit log id does not exist");
        }
        habitLogRepository.deleteById(id);
    }

    public List<HabitLogEntity> getAllHabitLogs(){return habitLogRepository.findAll();}

}
