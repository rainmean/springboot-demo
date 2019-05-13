package com.rainmean.service;

import com.rainmean.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/4/17.
 */
public interface UserService {
    User addUser(User user);
    User update(User user);
    int delete(Long id);
    User findUserById(Long id);
    List<User> findUsers();
}
