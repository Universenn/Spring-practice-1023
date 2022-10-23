package com.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao() throws SQLException {
        UserDao userDao = new UserDao(new AwsConnectionMaker());
        return userDao;
    }

    @Bean
    public UserDao loaclUserDao() throws SQLException {
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }
}
