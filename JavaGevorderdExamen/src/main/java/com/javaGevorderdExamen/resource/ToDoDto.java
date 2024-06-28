package com.javaGevorderdExamen.resource;

import com.javaGevorderdExamen.entity.ToDo;

import java.time.LocalDate;
import java.util.Date;

public class ToDoDto {


    public String titel;
    public String commentaar;
    public boolean status;
    public LocalDate expiryDate;

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
}
