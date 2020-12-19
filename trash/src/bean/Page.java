package bean;

import java.util.List;

/**
 * @author cyz
 * @create 2020-11-25 22:08
 */
public class Page<T> {
    public  static final Integer PAGE_SIZE = 5;
    private Integer PageNo;
    private Integer totalPage;
    private Integer pageSize = PAGE_SIZE;
    private Integer pageTotalCount;
    private List<T> items;

    public Integer getPageNo() {
        return PageNo;
    }

    public void setPageNo(Integer pageNo) {
        PageNo = pageNo;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageAdmin{" +
                "PageNo=" + PageNo +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }
}
