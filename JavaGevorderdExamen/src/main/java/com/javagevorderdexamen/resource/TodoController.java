package com.javagevorderdexamen.resource;


import com.javagevorderdexamen.entity.User;
import com.javagevorderdexamen.repository.TodoCrudRepo;
import com.javagevorderdexamen.repository.UserCrudRepo;
import com.javagevorderdexamen.service.ToDoService;
import com.javagevorderdexamen.entity.ToDo;
import com.javagevorderdexamen.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users/todos")
public class TodoController {

    @Autowired
    private ToDoService toDoService;
    @Autowired
    private TodoCrudRepo todoCrudRepo;
    @Autowired
    private UserCrudRepo userCrudRepo;


    @PostMapping
    public ToDo  createTodo(@RequestBody ToDo todo){
        ToDo returnedTodo = toDoService.addToDo(todo);

        return returnedTodo;

    }


    @GetMapping(value= "/{id}")
    public ToDo getToDo(@PathVariable("id") Integer id){
        return toDoService.getToDoById(id);
    }

    @PostMapping("/addtodo")
    public ToDoDTO addToDoToUser(@RequestBody AddToDoToUserDto addToDoToUserDto) throws Throwable {

        //mapping gaan gebruiken
        Optional<User> userOptional = userCrudRepo.findById(addToDoToUserDto.getUserId());
        if (userOptional.isPresent())  {
            User user = userOptional.get();

            ToDo todo = new ToDo();
            todo.setTitel(addToDoToUserDto.getTitel());
            todo.setCommentaar(addToDoToUserDto.getCommentaar());
            todo.setStatus(addToDoToUserDto.isStatus());
            todo.setExpiryDate(addToDoToUserDto.getExpiryDate());
            user.addToDo(todo);

            userCrudRepo.save(user);

//            todo.setUser(userOptional.get()); origineel werkend
            ToDo savedTodo = todoCrudRepo.save(todo);

            ToDoDTO todoDTO = addToDoToUserDto.toDto(savedTodo);
            return todoDTO;
        }else{
            throw new UserNotFoundException();
        }
    }

    @DeleteMapping("deletetodo/{id}")
    public void deleteToDoById(@PathVariable("id") Integer id){
        toDoService.deleteToDoById(id);
    }



}
