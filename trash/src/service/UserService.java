package service;

import bean.User;

/**
 * @author cyz
 * @create 2020-10-17 11:51
 */
public interface UserService {
    /**
     * 注册业务
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录业务
     * @param user
     * @return 登录失败返回null,登录成功返回对象
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return true表示用户名已存在,false表示用户名可用
     */
    public boolean existsUsername(String username);


}
