package com.javaGevorderdExamen.service;

import com.javaGevorderdExamen.entity.User;
import com.javaGevorderdExamen.repository.UserCrudRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserCrudRepo repo;

    @Autowired
    public UserService(UserCrudRepo repo){
        this.repo = repo;

    }


    public User addUser(User user){
        return repo.save(user);
    }


    public void deleteUser(int id){
      repo.deleteById(id);
    }

    public User editUser(int id, User user ){
        User searchedUser = repo.findById(id).orElseThrow(UserNotFoundException::new);
        searchedUser.setVoornaam(user.getVoornaam());
        searchedUser.setNaam(user.getNaam());
        searchedUser.setEmail(user.getEmail());
        searchedUser.setPassword(user.getPassword());
        return searchedUser;
    }

    public List<User> getAllUsers(){
        return (List<User>) repo.findAll();
    }

    public User getUserById(int id){
        return repo.findById(id).orElseThrow(UserNotFoundException::new);
    }



    public User createToDoForUser(Integer userId, String todoTitel, String todoCommentaar, Boolean todoStatus, LocalDate todoExpiryDate){
        User user = getUserById(userId);
        user.addToDo(todoTitel,todoCommentaar,todoStatus,todoExpiryDate);
        return repo.save(user);

   }




}
