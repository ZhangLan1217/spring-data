package com.example.springdata1.impl;
import com.example.springdata1.DAO.userDAO;
import com.example.springdata1.entity.UserDo;
import com.example.springdata1.service.userService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class userServiceImpl implements userService {

    @Resource
    userDAO userDao ;
    @Override
    @Cacheable(value = "UserId",key = "#id")
    public UserDo getUserById(Integer id) {

         UserDo userDo = userDao.getUsernameById(id);
         if(userDo==null){
             return null;
         }
         return userDo;
    }

    @Override
    public UserDo insertUser(UserDo user) {
        userDao.insertUser(user);
        return this.getUserById(user.getId());
    }

    @Override
    @CachePut(value = "UserId",key = "#user.id")
    public UserDo updateUser(UserDo user) {
        userDao.updateUser(user);
        return user;
    }

    @Override
    @CacheEvict(value = "UserId",key = "#id")
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
