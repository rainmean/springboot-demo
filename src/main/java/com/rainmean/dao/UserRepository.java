package com.rainmean.dao;

import com.rainmean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/4/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
