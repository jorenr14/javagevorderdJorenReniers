package com.javaGevorderdExamen.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Table(name= "Users")
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String email;
    private String naam;
    private String voornaam;
    private String password;
    @OneToMany
    @JoinColumn(name = "id")
    private List<ToDo> toDos = new ArrayList<>();




    public User(){

    };

    public User( String email, String naam, String voornaam, String password) {
        this.email = email;
        this.naam = naam;
        this.voornaam = voornaam;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    @OneToMany(mappedBy = "user")

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public void addToDo(String titel, String commentaar, Boolean status, LocalDate expirydate){
        if( toDos == null){
            toDos = new ArrayList<>();
        }

        ToDo todo = new ToDo(titel,commentaar,status,expirydate);
        toDos.add(todo);
    }
}
