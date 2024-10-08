package com.in.rest.webservices.resfulwebservices.user;

import com.in.rest.webservices.resfulwebservices.post.Post;
import com.in.rest.webservices.resfulwebservices.jpa.PostRepository;
import com.in.rest.webservices.resfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    private UserRepository repository;
    private PostRepository postRepository;



    public UserJpaResource(UserRepository repository, PostRepository postRepository) {

        this.repository = repository;
        this.postRepository =postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return  repository.findAll();
    }

     @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id ){
        Optional<User> user = repository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundExpetion("id:" + id);

        EntityModel<User> entityModel = EntityModel.of(user.get());


        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));

        return entityModel;

    }








    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id ){
        repository.deleteById(id);


    }



}
