package tn.booklab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.booklab.entities.User;
import tn.booklab.repository.UserRepo;

@RestController
@RequestMapping("/UC")
public class UserController {

    @Autowired
    private UserRepo service;

    @PostMapping("/addUser")
    public User insertUser(@RequestBody User user){
        return service.save(user);
    }
}
