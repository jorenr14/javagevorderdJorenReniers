package be.ucll.javagevorderdexamen.resource;


import be.ucll.javagevorderdexamen.service.UserService;
import be.ucll.javagevorderdexamen.entity.User;
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
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @PutMapping("/edit/{id}")
    public UserDTO editUser(@PathVariable Integer id, @RequestBody User user){
        User returnedUser = userService.editUser(id,user);
        return DTOConverter.convertToToDoDTO(returnedUser);
    };

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }



}
