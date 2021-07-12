package top.wobs.servlet;

import top.wobs.pojo.User;
import top.wobs.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login(user_name,"123456");//pwd并没有用于查询,随便写
        System.out.println("数据库查到的密码:"+admin.getUserPassword());

        if(pwd.equals(admin.getUserPassword())){
            req.getSession().setAttribute("user_name",req.getSession().getId());
            System.out.println("Session:"+req.getSession().getId());
            resp.sendRedirect("/index.jsp");
        }else{
            resp.sendRedirect("/error.jsp");
        }

     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
    }
}
