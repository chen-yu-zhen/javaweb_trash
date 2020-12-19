package test;

import bean.Admin;
import dao.AdminDao;
import org.junit.Test;
import service.AdminService;
import service.impl.AdminServiceImpl;
import web.AdminServlet;

import static org.junit.Assert.*;

/**
 * @author cyz
 * @create 2020-11-25 11:43
 */
public class AdminServiceTest {
    private AdminService adminService = new AdminServiceImpl();
    @Test
    public void deleteAdminById() {
        adminService.deleteAdminById(2);
    }

    @Test
    public void updateAdmin() {
        adminService.updateAdmin(new Admin(10,"aa",1,"0002","男",1000,"在线"));
    }
}
