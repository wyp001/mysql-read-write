package com.wyp;

import com.wyp.entity.User;
import com.wyp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MysqlReadWriteApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testRead() {
        for (int i = 0; i < 5; i++) {
            userService.queryAll();
        }
    }

    @Test
    public void testInsert() {
        User user = new User("张三",21);
        userService.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setName("李四");
        userService.update(user);
    }

    @Test
    public void testReadFromMaster() {
        userService.getToken("1234");
    }


}
