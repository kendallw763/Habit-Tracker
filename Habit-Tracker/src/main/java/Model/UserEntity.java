package Model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    private Long id;

    @Getter @Setter
    private String username, email;
    
    @OneToMany(mappedBy = "UserEntity", cascade = CascadeType.ALL)
    private List<UserEntity> userEntity;
}
