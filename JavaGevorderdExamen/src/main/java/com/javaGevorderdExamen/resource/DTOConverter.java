package com.javaGevorderdExamen.resource;

import com.javaGevorderdExamen.entity.ToDo;
import com.javaGevorderdExamen.entity.User;

import java.util.stream.Collectors;

public class DTOConverter {

    public static UserDTO convertToToDoDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setVoornaam(user.getVoornaam());
        userDTO.setNaam(user.getNaam());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword((userDTO.getPassword()));

        userDTO.setTodos(user.getToDos().stream().map(toDo -> convertToToDoDTO(toDo)).collect(Collectors.toList()));

        return userDTO;


    }

    public static ToDoDTO convertToToDoDTO(ToDo todo) {
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(toDoDTO.getId());
        toDoDTO.setTitel(toDoDTO.getTitel());
        toDoDTO.setCommentaar(toDoDTO.getCommentaar());
        toDoDTO.setExpiryDate(toDoDTO.getExpiryDate());
        toDoDTO.setStatus(toDoDTO.isStatus());

        return toDoDTO;


    }



}
