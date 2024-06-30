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
    public UserDto addUser(@RequestBody User user){

        User returnedUser = userService.addUser(user);
        return returnedUser;
    }

    @PutMapping("{id}")
    public UserDto


   // @PostMapping(value = "/{id}/todo")
//    public User createTodo(@PathVariable("id") Integer id, @RequestBody ToDoDto dto){
//
//
//        return userService.createToDoForUser(id, dto.titel, dto.commentaar, dto.status,dto.expiryDate);
//    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
}
