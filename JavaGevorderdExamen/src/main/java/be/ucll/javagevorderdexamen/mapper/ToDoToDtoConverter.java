package be.ucll.javagevorderdexamen.mapper;

import be.ucll.javagevorderdexamen.entity.ToDo;
import be.ucll.javagevorderdexamen.resource.ToDoDTO;

public class ToDoToDtoConverter {

    public static ToDoDTO convertToToDoDTO(ToDo todo) {
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(todo.getId());
        toDoDTO.setTitel(todo.getTitel());
        toDoDTO.setCommentaar(todo.getCommentaar());
        toDoDTO.setExpiryDate(todo.getExpiryDate());
        toDoDTO.setStatus(todo.isStatus());
        toDoDTO.setUserId(todo.getUser().getId());

        return toDoDTO;
    }
}
