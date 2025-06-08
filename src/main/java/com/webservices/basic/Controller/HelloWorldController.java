package com.webservices.basic.Controller;

import com.webservices.basic.user.User;
import com.webservices.basic.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    UserDaoService userDaoService;
    @GetMapping("/test")
    public String test(){
        return "hello word";
    }

    @GetMapping("/users")
    public List<User> fetchAll(){
        List<User> userDetails=new ArrayList<>();
        userDetails=userDaoService.findAll();
        return userDetails;
    }
    @GetMapping("/users/{id}")
    public List<User> fetchById(@PathVariable Integer id){
        List<User> userDetails=new ArrayList<>();
        userDetails=userDaoService.findById(id  );
        return userDetails;
    }

    @PostMapping("/save")
    public List<User> Save(@RequestBody User user){
        List<User> userDetails=new ArrayList<>();
        userDetails=userDaoService.save(user);
        return userDetails;
    }

    @PutMapping("/update")
    public List<User> update(@RequestBody User user){
        List<User> userDetails=new ArrayList<>();
        userDetails=userDaoService.update(user);
        return userDetails;
    }

    @DeleteMapping("/delete/{Id}")
    public List<User> delete(@PathVariable Integer Id){
        List<User> userDetails=new ArrayList<>();
        userDetails=userDaoService.delete(Id);
        return userDetails;
    }

}
