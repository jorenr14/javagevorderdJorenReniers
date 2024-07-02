package com.javaGevorderdExamen.resource;


import com.javaGevorderdExamen.entity.User;
import com.javaGevorderdExamen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserDTO addUser(@RequestBody User user){

        User returnedUser = userService.addUser(user);
        return DTOConverter.convertToToDoDTO(returnedUser);
    }

    @PutMapping("{id}")
    public UserDTO editUser(@PathVariable Integer id, @RequestBody User user){
        User returnedUser = userService.editUser(id,user);
        return DTOConverter.convertToToDoDTO(returnedUser);
    };

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id, @RequestBody User user){
        userService.deleteUser(id);
    }


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
