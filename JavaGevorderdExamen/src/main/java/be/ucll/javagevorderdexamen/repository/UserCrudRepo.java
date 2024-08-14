package be.ucll.javagevorderdexamen.repository;

import java.util.List;

import be.ucll.javagevorderdexamen.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepo extends CrudRepository<User, Integer> {
   List<User> findAll();
   List<User> findByNaamLike(String naam);
}
