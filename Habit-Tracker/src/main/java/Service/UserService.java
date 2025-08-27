package com.example.Habit.Tracker.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.Habit.Tracker.Model.UserEntity;
import com.example.Habit.Tracker.Repositories.UserRepository;
import com.example.Habit.Tracker.Exception.ResourceNotFoundException;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService (UserRepository userRepository){this.userRepository = userRepository;}

    public UserEntity createUser(UserEntity userEntity){return userRepository.save(userEntity);}

    public  UserEntity getUserById(Long id){return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id not found"));}

    public void deleteUserById (Long id ){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("User id not found");
        }
        userRepository.deleteById(id);
    }

    public List<UserEntity> getAllUsers(){return userRepository.findAll();}
}
