package com.javaGevorderdExamen.resource;


import com.javaGevorderdExamen.repository.TodoCrudRepo;
import com.javaGevorderdExamen.service.ToDoService;
import com.javaGevorderdExamen.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/users/todos")
public class TodoController {

    @Autowired
    private ToDoService toDoService;
    @Autowired
    private TodoCrudRepo todoCrudRepo;

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
    public ToDo addToDoToUser(@RequestBody AddToDoToUserDto addToDoToUserDto){

        ToDo todo = new ToDo();

        todo.setTitel(addToDoToUserDto.getTitel());
        todo.setCommentaar(addToDoToUserDto.getCommentaar());
        todo.setStatus(addToDoToUserDto.isStatus());
        todo.setExpiryDate(addToDoToUserDto.getExpiryDate());

        todoCrudRepo.save(todo);
        return todo;

    }




}
