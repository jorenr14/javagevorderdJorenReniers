package be.ucll.javagevorderdexamen;

import be.ucll.javagevorderdexamen.entity.User;
import be.ucll.javagevorderdexamen.repository.UserCrudRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaGevorderdExamenApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JavaGevorderdExamenApplication.class, args);

		UserCrudRepo repo = context.getBean(UserCrudRepo.class);

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
