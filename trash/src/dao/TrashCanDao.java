package dao;

import bean.Admin;
import bean.TrashCan;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-26 18:14
 */
public interface TrashCanDao {
    public int addTrashCan(TrashCan trashCan);

    public int deleteTrashCan(Integer id);

    public int updateTrashCan(TrashCan trashCan);

    public TrashCan queryTrashCanById(Integer id);

    public List<TrashCan> queryTrashCans();

    Integer queryForPageTotalCount();

    List<TrashCan> queryForPageItems(int begin, int pageSize);

    List<TrashCan> queryForBadCan();

    List<TrashCan> queryForFullCan();

    List<TrashCan> queryForGoodCan();
}
