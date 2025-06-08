package com.webservices.basic.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User(1,"pk",LocalDate.now()));
        users.add(new User(2,"rk",LocalDate.now()));
        users.add(new User(3,"dk",LocalDate.now()));
    }
    public List<User> findAll(){
        return users;
    }

    public List<User> findById(Integer id){
        List<User> collect = users.stream().filter(s -> s.getId() == id)
                .collect(Collectors.toList());
        return collect;
    }

    public List<User> save(User user) {
        users.add(user);
        return users;
    }

    public List<User> update(User user) {
       for (User userData:users) {
           if (userData.getId() == user.getId())
               userData.setName(user.getName());
       }
        return users;
    }
    public List<User> delete(Integer id) {
        users.removeIf(user->user.getId()==id);
        return users;
    }
}
