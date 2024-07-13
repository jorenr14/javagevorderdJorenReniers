package com.javagevorderdexamen.resource;

import com.javagevorderdexamen.entity.ToDo;

import java.time.LocalDate;

public class AddToDoToUserDto {

    private String titel;
    private String commentaar;
    private boolean status;
    private LocalDate expiryDate;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getCommentaar() {
        return commentaar;
    }

    public void setCommentaar(String commentaar) {
        this.commentaar = commentaar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ToDoDTO toDto(ToDo todo) {
        ToDoDTO dto = new ToDoDTO();
        dto.setId(todo.getId());
        dto.setTitel(todo.getTitel());
        dto.setCommentaar(todo.getCommentaar());
        dto.setStatus(todo.isStatus());
        dto.setExpiryDate(todo.getExpiryDate());
        dto.setUserId(todo.getUser().getId());
        return dto;


    }
}
