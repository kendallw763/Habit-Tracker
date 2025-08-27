package com.example.Habit.Tracker.Controller;

import org.springframework.http.ResponseEntity;
import com.example.Habit.Tracker.Model.UserEntity;
import com.example.Habit.Tracker.Service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController (UserService userService){
        this.userService = userService;
    }

  @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
            return userService.createUser(user);
    }

  @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){return userService.getUserById(id);}

  @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){userService.deleteUserById(id);
            return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public List<UserEntity>getAllUsers(){
            return userService.getAllUsers();
    }
}
