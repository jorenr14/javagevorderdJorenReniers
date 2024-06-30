package com.javaGevorderdExamen.resource;


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

    @PostMapping
    public ToDo  createTodo(@RequestBody ToDo todo){
        ToDo returnedTodo = toDoService.addToDo(todo);

        return returnedTodo;

    }


    @GetMapping(value= "/{id}")
    public ToDo getToDo(@PathVariable("id") Integer id){
        return toDoService.getToDoById(id);
    }



}
