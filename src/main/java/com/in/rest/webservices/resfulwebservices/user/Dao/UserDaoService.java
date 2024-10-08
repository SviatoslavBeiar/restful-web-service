package com.in.rest.webservices.resfulwebservices.user.Dao;

import com.in.rest.webservices.resfulwebservices.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private  static  int usersCount = 0;
    static {
        users.add(new User(++usersCount, "Valera", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Bob", LocalDate.now().minusYears(24)));
        users.add(new User(++usersCount, "Lol", LocalDate.now().minusYears(28)));
    }
    public List<User> findAll(){
        return  users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
       return users.stream().filter(predicate).findFirst().orElse(null);

    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);


    }





}
