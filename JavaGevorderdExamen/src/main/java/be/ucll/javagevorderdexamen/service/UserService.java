package be.ucll.javagevorderdexamen.service;

import be.ucll.javagevorderdexamen.repository.UserCrudRepo;
import be.ucll.javagevorderdexamen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public User deleteUser(int id){
        User user = repo.findById(id).orElseThrow(RuntimeException::new);
      repo.deleteById(id);
      return user;
    }

    public User editUser(int id, User user ){
        Optional<User> optionalUser = repo.findById(id);
        if(optionalUser.isPresent()) {
            User searchedUser = optionalUser.get();
            searchedUser.setVoornaam(user.getVoornaam());
            searchedUser.setNaam(user.getNaam());
            searchedUser.setEmail(user.getEmail());
            searchedUser.setPassword(user.getPassword());
            repo.save(searchedUser);
            return searchedUser;
        }else {
            return null;
        }
    }

    public List<User> getAllUsers(){
        return (List<User>) repo.findAll();
    }

    public User getUserById(int id){
        return repo.findById(id).orElseThrow(UserNotFoundException::new);
    }







}
