package be.ucll.javagevorderdexamen.resource;

import java.util.List;

public class UserDTO {

    private int id;
    private String email;
    private String naam;
    private String voornaam;
    private String password;
    private List<ToDoDTO > toDos;
    //private List<ToDoDTO> toDos = new ArrayList<>(); origineel werkend

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

    public List<ToDoDTO> getTodos() {
        return toDos;
    }

    public void setTodos(List<ToDoDTO> toDos) {
        this.toDos = toDos;
    }
}
