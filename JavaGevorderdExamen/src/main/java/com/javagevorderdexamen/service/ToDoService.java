package com.javagevorderdexamen.service;

import com.javagevorderdexamen.entity.ToDo;
import com.javagevorderdexamen.entity.User;
import com.javagevorderdexamen.repository.TodoCrudRepo;
import com.javagevorderdexamen.repository.UserCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final TodoCrudRepo todoCrudRepo;
    private final UserCrudRepo userCrudRepo;



    @Autowired
    public ToDoService(TodoCrudRepo todoCrudRepo, UserCrudRepo userCrudRepo) {
        this.todoCrudRepo =todoCrudRepo;
        this.userCrudRepo = userCrudRepo;
    }



    public ToDo addToDo(ToDo todo) {

       return todoCrudRepo.save(todo);

    }

    public ToDo addTodoToUser(int userId, ToDo todo) {
        Optional<User> userOptional = userCrudRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            todo.setUser(user);
            return todoCrudRepo.save(todo);
        }
        return null;
    }


    public List<ToDo> getAllToDos() {
        return (List<ToDo>) todoCrudRepo.findAll();
    }


    public ToDo getToDoById(int id) {
        return todoCrudRepo.findById(id).orElseThrow(ToDoNotFoundException::new);
    }

    public void deleteToDoById(int id) {
        todoCrudRepo.deleteById(id);
    }
}
