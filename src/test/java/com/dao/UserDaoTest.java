package com.dao;

import com.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {
    User user;

    UserDao userDao;
    User user1;
    User user2;
    User user3;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    @DisplayName("시작 세팅")
    void setup(){
        userDao = context.getBean("awsUserDao", UserDao.class);
        user1 = new User("1","이름 1","비밀번호1");

        user2 = new User("2","이름 2","비밀번호2");

        user3 = new User("3","이름 3","비밀번호3");
    }

    @Test
    @DisplayName("add selete 테스트")
    void addAndSelete() throws SQLException {

        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        userDao.add(user1);
        User selete = userDao.findById(user1.getId());

        assertEquals(user1.getName(),selete.getName());
    }

    @Test
    @DisplayName("deleteAll 테스트")
    void deleteAll() throws SQLException {
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        userDao.add(user1);
        userDao.add(user2);
        userDao.add(user3);
        User selete = userDao.findById(user1.getId());

        assertEquals(user1.getName(),selete.getName());
    }

    @Test
    @DisplayName("count")
    void count() throws SQLException {
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        userDao.add(user1);
        assertEquals(1, userDao.getCount());
        userDao.add(user2);
        assertEquals(2, userDao.getCount());
        userDao.add(user3);
        assertEquals(3, userDao.getCount());
    }
}