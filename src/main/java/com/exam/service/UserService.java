package com.exam.service;

import com.exam.dao.UserMapper;
import com.exam.entity.Score;
import com.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fang
 * @date 2019/2/4 0004 - 上午 12:36
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(String username) {
        User user = userMapper.getUser(username);
        return user;
    }


    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }


    public int addUser(User user) {
        int i = userMapper.addUser(user);
        return i;
    }

    /**
     * 删除用户
     *
     * @param username
     * @return
     */
    public int delUser(String username) {
        int i = userMapper.delUser(username);
        return i;
    }

    public int delAllUser(String usernames) {
        String[] strings = usernames.split(",");
        List list = new ArrayList();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        int i = userMapper.delAllUser(list);
        return i;
    }


    public int updUser(User user) {
        int i = userMapper.updUser(user);
        return i;
    }
}
