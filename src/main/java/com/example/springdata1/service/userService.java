package com.example.springdata1.service;


import com.example.springdata1.entity.UserDo;


public interface userService {


    public UserDo getUserById(Integer id);

    public UserDo insertUser(UserDo user);

    public UserDo updateUser(UserDo user);

    public void deleteUser(Integer id);
}
