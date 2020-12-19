package service;

import bean.Admin;
import bean.Page;
import bean.TrashCan;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-27 12:20
 */
public interface TrashCanService {
    public void addTrashCan(TrashCan trashCan);

    public void deleteTrashCanById(Integer id);

    public void updateTrashCan(TrashCan trashCan);

    public TrashCan queryTrashCanById(Integer id);

    public List<TrashCan> queryTrashCan();

    Page<TrashCan> page(int pageNo, int pageSize);

    public List<TrashCan> queryForGoodCan();

    public List<TrashCan> queryForFullCan();

    public List<TrashCan> queryForBadCan();
}
