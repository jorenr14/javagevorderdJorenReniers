package be.ucll.javagevorderdexamen.mapper;

import be.ucll.javagevorderdexamen.entity.User;
import be.ucll.javagevorderdexamen.resource.UserDTO;

import java.util.stream.Collectors;

public class UserToDtoConverter {



    public static UserDTO convertToToDoDTO(User user) {

            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setVoornaam(user.getVoornaam());
            userDTO.setNaam(user.getNaam());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword((userDTO.getPassword()));

            userDTO.setTodos(user.getToDos().stream()
                    .map(ToDoToDtoConverter::convertToToDoDTO)
                    .collect(Collectors.toList()));

            return userDTO;

    }
}
