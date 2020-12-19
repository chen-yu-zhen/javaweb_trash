package web;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author cyz
 * @create 2020-10-21 12:04
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理登录需求
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用userService的login()处理业务
        if(userService.login(new User(username, password, null)) != null){
            //3.根据login方法的返回值判断是否登录成功
            //成功
            //跳到登录成功界面
            req.getRequestDispatcher("admin/trashCanServlet?action=list").forward(req,resp);
        }else{
            //失败
            //返回登录界面
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理注册需求
        String kCode = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //1获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2检查验证码是否正确(要求验证码为abcd)
        if (kCode != null && kCode.equalsIgnoreCase(code)){
            //2.1检查用户名是否可用
            if(!userService.existsUsername(username)){
                //2.1.1调用service保存到数据库
                userService.registerUser((new User(username,password,email)));
                req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
                //跳到注册成功页面
            }else{
                //2.1.2返回注册页面
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("repwd",repwd);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
            }
        }else{
            //2.2返回注册界面
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("repwd",repwd);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
        }
    }

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
            try {
                Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
                method.invoke(this,req,resp);
            } catch (NoSuchMethodException e) {

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
}
