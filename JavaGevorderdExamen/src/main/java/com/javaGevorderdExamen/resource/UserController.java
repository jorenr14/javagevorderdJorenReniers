package com.javaGevorderdExamen.resource;


import com.javaGevorderdExamen.entity.User;
import com.javaGevorderdExamen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }


    @PostMapping
    public User createUser(@RequestBody UserDto dto){
        return userService.addUser(dto.email, dto.naam, dto.voornaam, dto.password);
    }


    @PostMapping(value = "/{id}/todo")
    public User createTodo(@PathVariable("id") Integer id, @RequestBody ToDoDto dto){


        return userService.createToDoForUser(id, dto.titel, dto.commentaar, dto.status,dto.expiryDate);
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
}
