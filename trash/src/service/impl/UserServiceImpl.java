package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * @author cyz
 * @create 2020-10-17 15:49
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }else{
            return true;
        }
    }
}
