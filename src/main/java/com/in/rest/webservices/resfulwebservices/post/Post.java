package com.in.rest.webservices.resfulwebservices.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in.rest.webservices.resfulwebservices.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
    protected Post() {
    }

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 10)
    private String description;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "  id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Post(Integer id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    /* public Post(Integer id, String description) {

        this.id = id;
        this.description = description;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
