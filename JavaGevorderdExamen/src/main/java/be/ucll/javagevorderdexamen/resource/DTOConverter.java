package be.ucll.javagevorderdexamen.resource;

import be.ucll.javagevorderdexamen.entity.ToDo;
import be.ucll.javagevorderdexamen.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class DTOConverter {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setNaam(user.getNaam());
        userDTO.setVoornaam(user.getVoornaam());

        List<ToDoDTO> toDoDTOs = user.getToDos().stream()
                .map(DTOConverter::convertToToDoDTO)
                .collect(Collectors.toList());

        userDTO.setTodos(toDoDTOs);
        return userDTO;
    }

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
