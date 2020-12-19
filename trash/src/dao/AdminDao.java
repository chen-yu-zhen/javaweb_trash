package dao;

import bean.Admin;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-24 21:22
 */
public interface AdminDao {
    public int addAdmin(Admin admin);

    public int deleteAdmin(Integer id);

    public int updateAdmin(Admin admin);

    public Admin queryAdminById(Integer id);

    public List<Admin> queryAdmins();

    Integer queryForPageTotalCount();

    List<Admin> queryForPageItems(int begin, int pageSize);
}
