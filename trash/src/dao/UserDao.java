package dao;

import bean.User;

/**
 * @author cyz
 * @create 2020-10-17 11:22
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null,则没有用户信息
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user 用户名
     * @return 返回-1表示操作失败
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);


}
