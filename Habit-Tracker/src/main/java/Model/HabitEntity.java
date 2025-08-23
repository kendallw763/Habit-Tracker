package Model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
public class HabitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    private Long id;

    @Getter @Setter
    private String user, name, description;

    @Getter
    private LocalDate createdAt;

    @OneToMany(mappedBy = "HabitEntity", cascade = CascadeType.ALL)
    List<HabitEntity> habitEntity;

    @JoinColumn(name = "user_id")
    @ManyToOne

    @Getter @Setter
    private UserEntity userEntity;
}
