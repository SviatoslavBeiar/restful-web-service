package com.in.rest.webservices.resfulwebservices.jpa;

import com.in.rest.webservices.resfulwebservices.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
