package dao.impl;

import bean.Admin;
import dao.AdminDao;

import java.awt.print.Book;
import java.util.List;

/**
 * @author cyz
 * @create 2020-11-24 21:24
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public int addAdmin(Admin admin) {
        String sql ="INSERT INTO admininfo(`name`,`age`,`jobId`,`sex`,`salary`,`state`) \n" +
                "VALUES(?,?,?,?,?,?);";
        return update(sql,admin.getName(),admin.getAge(),admin.getJobId(),admin.getSex(),admin.getSalary(),admin.getState());
    }

    @Override
    public int deleteAdmin(Integer id) {
        String sql ="delete from admininfo where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        String sql = "update admininfo set `name` = ?,`age` = ?,`jobId` = ?,`sex` = ?,`salary` = ?,`state` = ? where id = ?";
        return update(sql,admin.getName(),admin.getAge(),admin.getJobId(),admin.getSex(),admin.getSalary(),admin.getState(),admin.getId());
    }

    @Override
    public Admin queryAdminById(Integer id) {
        String sql = "select `id`,`name`,`age`,`jobId`,`sex`,`salary`,`state` from admininfo where id = ?";
        return queryForOne(Admin.class,sql,id);
    }

    @Override
    public List<Admin> queryAdmins() {
        String sql = "select `id`,`name`,`age`,`jobId`,`sex`,`salary`,`state` from admininfo";
        return queryForList(Admin.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from admininfo";
        Number count =(Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Admin> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`age`,`jobId`,`sex`,`salary`,`state` from admininfo limit ?,?";
        return queryForList(Admin.class,sql,begin,pageSize);
    }
}
