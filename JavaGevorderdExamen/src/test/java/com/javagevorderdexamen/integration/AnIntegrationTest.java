package com.javagevorderdexamen.integration;


import com.javagevorderdexamen.entity.User;
import com.javagevorderdexamen.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class AnIntegrationTest {

    @Autowired
    private WebTestClient client;
    @Autowired
    private UserService userService;

    @Test
    public void validateThatAUserCanBeCreated(){

        //begrijp wat hier gebeurt
        UserBodyValue user = new UserBodyValue();
        user.naam ="Reniers";
        user.voornaam = "Joren";

        client.post()
                .uri("/users")
                .bodyValue(user)
                .exchange()
                .expectBody()
                .json("{\"id\":1,\"naam\":\"Reniers\",\"voornaam\":\"Joren\"}");


    }


    @Test
    public void validateThatAUserCanBeCreated2(){
        userService.addUser(new User("reniers.joren@gmail.com","Reniers","Joren","TestPassword"));
        Assertions.assertEquals("Reniers", userService.getAllUsers().iterator().next().getNaam());

    }

    private static class UserBodyValue{
        public String naam;
        public String voornaam;

    }

    private static class ToDoBody{
        private String titel;
        private String commentaar;

    }



//    private static class FakeUserRepository implements UserCrudRepo{
//
//        @Override
//        public List<User> findAll(){
//            List<User> users = new ArrayList<>();
//
//            users.add(new User("reniers.joren@gmail.com","Reniers","Joren","TestPassword"));
//            users.add(new User("jan.janssens@gmail.com","Janssens","Jan","TestJan"));
//            users.add(new User("kobe.bryant@gmail.com","Bryant","Kobe","KobeBryant"));
//
//            return users;
//        }
//
//        @Override
//        public  List<User> findByNaamLike(String naam){
//
//        };


    }




