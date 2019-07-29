package com.mvc.servlet;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

import javax.jws.WebService;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        String uname=req.getParameter("uname");
        String upsd=req.getParameter("upsd");
        int result=LoginDao.login(new LoginBean(uname,upsd));
        if (result==1){
            resp.sendRedirect("succeed.jsp");
        }else{
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
