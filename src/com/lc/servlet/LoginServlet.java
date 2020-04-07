package com.lc.servlet;

import com.lc.Dao.Impl.UserDaoImpl;
import com.lc.Dao.UserDao;
import com.lc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/jsp;charset=utf-8");
        String path = "index.jsp";
        String userid = req.getParameter("username");
        String userpass = req.getParameter("password");
        User user = new User();
        user.setName(userid);
        user.setPassword(userpass);
        UserDao userDao = new UserDaoImpl();
        try{
            if(userDao.Loginyz(user)){

                //将用户信息放入到session中
                req.getSession().setAttribute("info",user.getName());
                req.getRequestDispatcher(path).forward(req,resp) ;
            }
            req.setAttribute("info","用户名或密码错误！");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}
