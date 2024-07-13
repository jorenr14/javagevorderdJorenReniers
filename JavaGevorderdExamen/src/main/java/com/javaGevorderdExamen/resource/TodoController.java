package com.javaGevorderdExamen.resource;


import com.javaGevorderdExamen.entity.User;
import com.javaGevorderdExamen.repository.TodoCrudRepo;
import com.javaGevorderdExamen.repository.UserCrudRepo;
import com.javaGevorderdExamen.service.ToDoService;
import com.javaGevorderdExamen.entity.ToDo;
import com.javaGevorderdExamen.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Supplier;

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
            ToDo todo = new ToDo();
            todo.setTitel(addToDoToUserDto.getTitel());
            todo.setCommentaar(addToDoToUserDto.getCommentaar());
            todo.setStatus(addToDoToUserDto.isStatus());
            todo.setExpiryDate(addToDoToUserDto.getExpiryDate());

            todo.setUser(userOptional.get());
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
