package com.javaGevorderdExamen;

import com.javaGevorderdExamen.entity.User;
import com.javaGevorderdExamen.repository.UserCrudRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaGevorderdExamenApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JavaGevorderdExamenApplication.class, args);

		UserCrudRepo repo = context.getBean(UserCrudRepo.class);

		//repo.deleteAll();


		repo.save(new User("reniers.joren@gmail.com","Reniers","Joren","joren"));
		repo.save(new User("dries.natasja@gmail.com","Dries","Natasja","natasja"));
		repo.save(new User("janssens.jan@gmail.com","Janssens","Jan","janj"));

		System.out.println("All users");;
		for(User user : repo.findAll()){
			System.out.println(user);
		}
		for(User user : repo.findByNaamLike("Reniers")){
			var naam = user.getNaam();
			System.out.println(naam);
		};


		System.out.println(repo);



	}

}
