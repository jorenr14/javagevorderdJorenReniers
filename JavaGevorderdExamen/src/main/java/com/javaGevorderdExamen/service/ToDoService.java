package com.javaGevorderdExamen.service;

import com.javaGevorderdExamen.entity.ToDo;
import com.javaGevorderdExamen.repository.TodoCrudRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final TodoCrudRepo repo;



    @Autowired
    public ToDoService(TodoCrudRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public ToDo addToDo(ToDo todo) {



       return repo.save(todo);


    }

    public List<ToDo> getAllToDos() {
        return (List<ToDo>) repo.findAll();
    }


    public ToDo getToDoById(int id) {
        return repo.findById(id).orElseThrow(ToDoNotFoundException::new);
    }

    public void deleteToDoById(int id) {
        repo.deleteById(id);
    }
}
