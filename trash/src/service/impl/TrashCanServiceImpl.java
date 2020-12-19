package service.impl;

import bean.Admin;
import bean.Page;
import bean.TrashCan;
import dao.TrashCanDao;
import dao.impl.TrashCanDaoImpl;
import service.TrashCanService;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-27 12:25
 */
public class TrashCanServiceImpl implements TrashCanService {
    private TrashCanDao trashCanDao = new TrashCanDaoImpl();
    @Override
    public void addTrashCan(TrashCan trashCan) {
        trashCanDao.addTrashCan(trashCan);
    }

    @Override
    public void deleteTrashCanById(Integer id) {
        trashCanDao.deleteTrashCan(id);
    }

    @Override
    public void updateTrashCan(TrashCan trashCan) {
        trashCanDao.updateTrashCan(trashCan);
    }

    @Override
    public TrashCan queryTrashCanById(Integer id) {
       return trashCanDao.queryTrashCanById(id);
    }

    @Override
    public List<TrashCan> queryTrashCan() {
        return trashCanDao.queryTrashCans();
    }

    @Override
    public Page<TrashCan> page(int pageNo, int pageSize) {
        Page<TrashCan> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pageTotalCount = trashCanDao.queryForPageTotalCount();
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
        List<TrashCan> items = trashCanDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public List<TrashCan> queryForGoodCan() {
        return trashCanDao.queryForGoodCan();
    }

    @Override
    public List<TrashCan> queryForFullCan() {
        return trashCanDao.queryForFullCan();
    }

    @Override
    public List<TrashCan> queryForBadCan() {
        return trashCanDao.queryForBadCan();
    }
}
