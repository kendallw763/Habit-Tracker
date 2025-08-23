package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

public class HabitLogEntity {

    //use annotations for id, generated value, getter, setter, etc.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    private Long id;

    @Getter @Setter
    private boolean completed;

    @Getter
    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "habit_id")

    @Getter @Setter
    private HabitEntity habitEntity;
}
