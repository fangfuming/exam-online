package com.exam.dao;

import com.exam.entity.Score;
import com.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fang
 * @date 2019/2/4 0004 - 上午 12:26
 */

@Mapper
public interface UserMapper {


    User getUser(String username);

    List<User> getUserList();

    int addUser(User user);

    int delUser(String username);

    int delAllUser(List list);

    int updUser(User user);

}
