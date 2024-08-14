package be.ucll.javagevorderdexamen.mapper;

import be.ucll.javagevorderdexamen.entity.ToDo;
import be.ucll.javagevorderdexamen.resource.ToDoDTO;

public class ToDoToDtoConverter {

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
