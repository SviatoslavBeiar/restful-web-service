package com.in.rest.webservices.resfulwebservices.post;

import com.in.rest.webservices.resfulwebservices.jpa.PostRepository;
import com.in.rest.webservices.resfulwebservices.jpa.UserRepository;
import com.in.rest.webservices.resfulwebservices.user.User;
import com.in.rest.webservices.resfulwebservices.user.UserNotFoundExpetion;
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
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundExpetion("id:" + id);
        return user.get().getPosts();


    }
    @GetMapping("/jpa/users/{userId}/posts/{postId}")
    public EntityModel<Post> retrievePostForUser(@PathVariable int userId, @PathVariable int postId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new UserNotFoundExpetion("User id:" + userId);

        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty())
            throw new UserNotFoundExpetion("Post id:" + postId);

        EntityModel<Post> entityModel = EntityModel.of(post.get());
        WebMvcLinkBuilder userLink = linkTo(methodOn(this.getClass()).retrievePostsForUser(userId) );
        entityModel.add(userLink.withRel("user"));

        return entityModel;
    }




    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundExpetion("id:" + id);
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();


    }

}
