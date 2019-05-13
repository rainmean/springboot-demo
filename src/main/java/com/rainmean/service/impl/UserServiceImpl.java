package com.rainmean.service.impl;/**
 * Created by Administrator on 2019/4/17.
 */

import com.rainmean.dao.UserRepository;
import com.rainmean.entity.User;
import com.rainmean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rainmean.Li
 * @create 2019-04-17 18:12
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public int delete(Long id) {
        userRepository.deleteById(id);
        return 0;
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user= userRepository.findById(id);
        if(user!=null)
            return user.get();
        return null;
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
