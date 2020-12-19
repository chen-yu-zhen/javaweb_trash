package dao.impl;

import bean.TrashCan;
import dao.TrashCanDao;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-26 19:32
 */
public class TrashCanDaoImpl extends BaseDao implements TrashCanDao {
    @Override
    public int addTrashCan(TrashCan trashCan) {
        String sql = "insert into trashinfo(`name`,`location`,`state`)values(?,?,?);";
        return update(sql,trashCan.getName(),trashCan.getLocation(),trashCan.getState());
    }

    @Override
    public int deleteTrashCan(Integer id) {
        String sql ="delete from trashinfo where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateTrashCan(TrashCan trashCan) {
        String sql = "update trashinfo set `name` = ?,`location` = ?,`state` = ? where `id` = ?";
        return update(sql,trashCan.getName(),trashCan.getLocation(),trashCan.getState(),trashCan.getId());
    }

    @Override
    public TrashCan queryTrashCanById(Integer id) {
        String sql = "select `id`,`name`,`location`,`state` from trashinfo where id = ?";
        return queryForOne(TrashCan.class,sql,id);
    }

    @Override
    public List<TrashCan> queryTrashCans() {
        String sql = "select `id`,`name`,`location`,`state` from trashinfo";
        return queryForList(TrashCan.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from trashinfo";
        Number count =(Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<TrashCan> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`location`,`state` from trashinfo limit ?,?";
        return queryForList(TrashCan.class,sql,begin,pageSize);
    }

    //垃圾桶ID，位置，状态
    @Override
    public List<TrashCan> queryForBadCan() {
        String sql = "select `id` ,`name`,`location`,`state` from trashinfo where state = '离线'";
        return queryForList(TrashCan.class,sql);
    }

    //垃圾桶ID，位置，满溢程度
    @Override
    public List<TrashCan> queryForFullCan() {
        String sql = "select `id` ,`name`,`location`,`t1`,`t2`,`t3`,`t4` from trashinfo where t1 > 80 or t2 > 80 or t3 > 80 or t4 > 80";
        return queryForList(TrashCan.class,sql);
    }
    //垃圾桶ID，位置，满溢程度
    @Override
    public List<TrashCan> queryForGoodCan() {
        String sql = "SELECT `id` ,`name`,`location`,`t1`,`t2`,`t3`,`t4` FROM trashinfo WHERE state = '在线'";
        return queryForList(TrashCan.class,sql);
    }
}
