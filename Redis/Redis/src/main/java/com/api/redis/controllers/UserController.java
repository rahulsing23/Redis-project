package com.api.redis.controllers;

import com.api.redis.dao.UserDao;
import com.api.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return  userDao.save(user);

    }

    @GetMapping("/userId")
    public User getUser(@PathVariable String userId){
        return userDao.get(userId);
    }

    @GetMapping
    public Map<Object, Object> getUser(){
        return userDao.findAll();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userDao.delete(userId);
    }
}
