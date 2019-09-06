package com.epchong.controller;

import com.epchong.Service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author epochong
 * @date 2019/9/5 21:28
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    AccountService accountService = new AccountService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (accountService.register(userName,password)) {
            writer.println("<script>\n" +
                    "    alert(\"注册成功\");\n" +
                    "    window.location.href = \"/jsp/loginForm.jsp\";\n" +
                    "</script>");
        } else {
            writer.println("<script>\n" +
                    "    alert(\"用户名已存在\");\n" +
                    "    window.location.href = \"/jsp/register.jsp\";\n" +
                    "</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
