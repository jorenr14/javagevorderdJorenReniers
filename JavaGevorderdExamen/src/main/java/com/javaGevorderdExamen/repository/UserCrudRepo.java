package com.javaGevorderdExamen.repository;

import java.util.List;

import com.javaGevorderdExamen.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepo extends CrudRepository<User, Integer> {
   List<User> findAll();
   List<User> findByNaamLike(String naam);

   List<User> findByEmail(String Email);
   List<User> findByNaamStartingWith(String prefix);


}
