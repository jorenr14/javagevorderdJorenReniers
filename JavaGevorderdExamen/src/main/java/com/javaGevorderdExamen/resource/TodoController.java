package com.javaGevorderdExamen.resource;


import com.javaGevorderdExamen.service.ToDoService;
import com.javaGevorderdExamen.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ToDo  createTodo(@RequestBody ToDoDto dto){

        return toDoService.addToDo(dto.titel,dto.commentaar,dto.status,dto.expiryDate);

    }


    @GetMapping(value= "/{id}")
    public ToDo getToDo(@PathVariable("id") Integer id){
        return toDoService.getToDoById(id);
    }



}
