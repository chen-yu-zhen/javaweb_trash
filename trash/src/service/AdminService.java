package service;

import bean.Admin;
import bean.Page;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-24 21:38
 */
public interface AdminService {
    public void addAdmin(Admin admin);

    public void deleteAdminById(Integer id);

    public void updateAdmin(Admin admin);

    public Admin queryAdminById(Integer id);

    public List<Admin> queryAdmin();

    Page<Admin> page(int pageNo, int pageSize);
}
