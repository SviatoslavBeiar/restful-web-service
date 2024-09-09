package com.in.rest.webservices.resfulwebservices.jpa;

import com.in.rest.webservices.resfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
