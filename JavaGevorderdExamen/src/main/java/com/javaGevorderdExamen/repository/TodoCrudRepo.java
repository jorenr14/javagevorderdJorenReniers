package com.javaGevorderdExamen.repository;

import com.javaGevorderdExamen.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TodoCrudRepo extends CrudRepository<ToDo,Integer> {

    List<ToDo> findAll();
    List<ToDo> findByTitel(String titel);
    List<ToDo> findByCommentaar(String commentaar);

    List<ToDo> findByStatus(boolean status);

    List<ToDo> findByExpiryDate(LocalDate expiryDate);


}
