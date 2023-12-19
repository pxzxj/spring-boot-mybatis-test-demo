package io.github.pxzxj.mapper;

import io.github.pxzxj.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123");
        user.setAge(1);
        Integer count = userMapper.saveUser(user);
        assertEquals(1, count);
    }

    @Test
    void testFindUserByUsername() {
        User user = userMapper.findUserByUsername("qqq");
        assertAll(() -> {
            assertEquals("qqq", user.getUsername());
            assertEquals("123456", user.getPassword());
            assertEquals(6, user.getAge());
        });
    }

}