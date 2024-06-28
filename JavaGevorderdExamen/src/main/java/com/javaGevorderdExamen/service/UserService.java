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

    @Transactional
    public User addUser(String email, String naam, String voornaam, String password){
        return repo.save(new User(email,naam,voornaam,password));
    }


    public void deleteUser(int id){
      repo.deleteById(id);
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
