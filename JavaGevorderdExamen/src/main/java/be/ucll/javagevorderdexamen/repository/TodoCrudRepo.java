package be.ucll.javagevorderdexamen.repository;

import be.ucll.javagevorderdexamen.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoCrudRepo extends CrudRepository<ToDo,Integer> {

    List<ToDo> findAll();



}
