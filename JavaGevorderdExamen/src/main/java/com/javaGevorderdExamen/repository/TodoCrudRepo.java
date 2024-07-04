package com.javaGevorderdExamen.repository;

import com.javaGevorderdExamen.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TodoCrudRepo extends CrudRepository<ToDo,Integer> {

    List<ToDo> findAll();



}
