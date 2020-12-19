package web;

import bean.Admin;
import bean.Page;
import bean.TrashCan;
import service.TrashCanService;
import service.impl.TrashCanServiceImpl;
import utils.WebUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author cyz
 * @create 2020-11-27 12:29
 */
public class TrashCanServlet extends BaseServlet {
    private TrashCanService trashCanService = new TrashCanServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrashCan trashCan = WebUtils.copyParamToBean(req.getParameterMap(),new TrashCan());
        trashCanService.addTrashCan(trashCan);
        resp.sendRedirect(req.getContextPath()+"/admin/trashCanServlet?action=show");
    }

    protected void replace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrashCan trashCan = WebUtils.copyParamToBean(req.getParameterMap(),new TrashCan());
        trashCanService.updateTrashCan(trashCan);
        resp.sendRedirect(req.getContextPath()+"/admin/trashCanServlet?action=display");
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = WebUtils.parseInt(id,0);
        trashCanService.deleteTrashCanById(i);
        resp.sendRedirect(req.getContextPath()+"/admin/trashCanServlet?action=select");
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<TrashCan> page = trashCanService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/trashCan/trashCanList.jsp").forward(req,resp);
    }
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<TrashCan> page = trashCanService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/trashCan/removeTrashCan.jsp").forward(req,resp);
    }
    protected void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<TrashCan> page = trashCanService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/trashCan/trashCanUpdate.jsp").forward(req,resp);
    }
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<TrashCan> page = trashCanService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/trashCan/addTrashCan.jsp").forward(req,resp);
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        TrashCan trashCan = trashCanService.queryTrashCanById(id);
        req.setAttribute("trashCan",trashCan);
        req.getRequestDispatcher("/pages/trashCan/trashCanEdit.jsp").forward(req,resp);
    }
    protected void map(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrashCan> trashCans = trashCanService.queryTrashCan();
        req.setAttribute("trashCans",trashCans);
        req.getRequestDispatcher("/pages/trashCan/map.jsp").forward(req,resp);
    }
}
