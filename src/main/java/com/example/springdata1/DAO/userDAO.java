package com.example.springdata1.DAO;

import com.example.springdata1.entity.UserDo;
import com.example.springdata1.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository
public class userDAO {
    @Resource
    UserMapper userMapper;

    public UserDo getUsernameById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public UserDo insertUser(UserDo user){
        userMapper.insert(user);
        return this.getUsernameById(user.getId());
    }

    public UserDo updateUser(UserDo user){
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    public void deleteUser(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }

}
