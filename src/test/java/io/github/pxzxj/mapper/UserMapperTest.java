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

    /**
     * 思考：为什么上面的测试testSaveUser已经添加了一个用户，这里的用户数还是1而不是2
     * 答案：首先测试顺序不能保证其次测试会回滚事务
     */
    @Test
    void testCountUser() {
        Integer count = userMapper.countUser();
        assertEquals(1, count);
    }

}