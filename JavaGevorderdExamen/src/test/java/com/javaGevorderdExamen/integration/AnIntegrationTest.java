package com.javaGevorderdExamen.integration;


import com.javaGevorderdExamen.entity.User;
import com.javaGevorderdExamen.repository.UserCrudRepo;
import com.javaGevorderdExamen.service.UserService;
import jakarta.jws.soap.SOAPBinding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AnIntegrationTest {

    @Autowired
    private WebTestClient client;
    @Autowired
    private UserService userService;

    @Test
    public void AUserCanBeCreated(){
        UserBodyValue user = new UserBodyValue();
        user.naam ="Reniers";
        user.voornaam = "Joren";

        client.post()
                .uri("/users/")
                .bodyValue(user)
                .exchange()
                .expectBody()
                .json("{\"id\":2,\"naam\":\"Reniers\",\"voornaam\":\"Joren\"}");


    }
    @Test
    public void ValidateThatAUserCanBeCreated2(){
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
//        public <S extends User> S save(S entity) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
//            return null;
//        }
//
//        @Override
//        public Optional<User> findById(Integer integer) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Integer integer) {
//            return false;
//        }
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
//        public Iterable<User> findAllById(Iterable<Integer> integers) {
//            return null;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Integer integer) {
//
//        }
//
//        @Override
//        public void delete(User entity) {
//
//        }
//
//        @Override
//        public void deleteAllById(Iterable<? extends Integer> integers) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends User> entities) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//
//        @Override
//        public  List<User> findByNaamLike(String naam){
//
//        };


    }




