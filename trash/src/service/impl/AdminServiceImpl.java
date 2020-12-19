package service.impl;

import bean.Admin;
import bean.Page;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-24 21:40
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public void addAdmin(Admin admin) {
        adminDao.addAdmin(admin);
    }

    @Override
    public void deleteAdminById(Integer id) {
        adminDao.deleteAdmin(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public Admin queryAdminById(Integer id) {
        return adminDao.queryAdminById(id);
    }

    @Override
    public List<Admin> queryAdmin() {
        return adminDao.queryAdmins();
    }

    @Override
    public Page<Admin> page(int pageNo, int pageSize) {
        Page<Admin> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pageTotalCount = adminDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal++;
        }
        //设置总页码
        page.setTotalPage(pageTotal);
        if(pageNo<1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        //求当前页的开始索引
        int begin = (page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Admin> items = adminDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
