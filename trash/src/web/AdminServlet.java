package web;

import bean.Admin;
import bean.Page;
import dao.impl.BaseDao;
import service.AdminService;
import service.impl.AdminServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author cyz
 * @create 2020-11-24 21:42
 */
public class AdminServlet extends BaseServlet {
    private AdminService adminService = new AdminServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = WebUtils.copyParamToBean(req.getParameterMap(),new Admin());
        adminService.addAdmin(admin);
        resp.sendRedirect(req.getContextPath()+"/admin/adminServlet?action=show");
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = WebUtils.parseInt(id,0);
        adminService.deleteAdminById(i);
        resp.sendRedirect(req.getContextPath()+"/admin/adminServlet?action=select");
    }

    protected void replace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = WebUtils.copyParamToBean(req.getParameterMap(),new Admin());
        adminService.updateAdmin(admin);
        resp.sendRedirect(req.getContextPath()+"/admin/adminServlet?action=display");
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Admin admin = adminService.queryAdminById(id);
        req.setAttribute("admin",admin);
        req.getRequestDispatcher("/pages/admin/adminEdit.jsp").forward(req,resp);
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Admin> page = adminService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/admin/adminList.jsp").forward(req,resp);
    }
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Admin> page = adminService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/admin/addAdmin.jsp").forward(req,resp);
    }
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Admin> page = adminService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/admin/removeAdmin.jsp").forward(req,resp);
    }
    protected void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Admin> page = adminService.page(pageNo,pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/admin/adminUpdate.jsp").forward(req,resp);
    }
}
