package test;

import bean.User;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @author cyz
 * @create 2020-11-24 14:59
 */
public class UserServiceTest {
UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User("admin","123456","2222@qq.com"));
    }

    @Test
    public void login() {
    }

    @Test
    public void existsUsername() {
    }
}
