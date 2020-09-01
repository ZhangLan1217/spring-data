package com.example.springdata1.controller;

import com.example.springdata1.entity.UserDo;
import com.example.springdata1.model.CommonResponse;
import com.example.springdata1.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    userService userservice;

    @GetMapping("/dept/{id}")
    public UserDo getUser(@PathVariable("id") Integer id){
        return userservice.getUserById(id);
    }

    @PostMapping("/dept/insert")
    public CommonResponse<UserDo> insertUser(UserDo user){
        userservice.insertUser(user);
       // return this.getUser(user.getId());
        return CommonResponse.ok(this.getUser(user.getId()));
    }

    @PostMapping("/dept/update")
    public UserDo updateUser(UserDo user){
        userservice.updateUser(user);
        return user;
    }
    @GetMapping("/dept/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userservice.deleteUser(id);
        return "已经成功删除 "+id+" 号用户";
    }

}
