package dao.impl;

import bean.User;
import dao.UserDao;

/**
 * @author cyz
 * @create 2020-10-17 11:29
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from userinfo where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into userinfo(`username`,`password`,`email`) VALUES(?,?,?);";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from userinfo where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

}
