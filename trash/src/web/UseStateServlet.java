package web;

import bean.Page;
import bean.TrashCan;
import service.TrashCanService;
import service.impl.TrashCanServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author cyz
 * @create 2020-11-27 12:39
 */
public class UseStateServlet extends BaseServlet{
    private TrashCanService trashCanService = new TrashCanServiceImpl();
    //good
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrashCan> trashCans = trashCanService.queryForGoodCan();
        req.setAttribute("trashCans",trashCans);
        req.getRequestDispatcher("/pages/state/goodTrashCan.jsp").forward(req,resp);
    }
    //bad
    protected void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrashCan> trashCans = trashCanService.queryForBadCan();
        req.setAttribute("trashCans",trashCans);
        req.getRequestDispatcher("/pages/state/badTrashCan.jsp").forward(req,resp);
    }
    //full
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrashCan> trashCans = trashCanService.queryForFullCan();
        req.setAttribute("trashCans",trashCans);
        req.getRequestDispatcher("/pages/state/fullTrashCan.jsp").forward(req,resp);
    }

}
