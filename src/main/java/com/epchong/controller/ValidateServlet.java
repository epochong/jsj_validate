package com.epchong.controller;

import com.epchong.Service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author epochong
 * @date 2019/9/4 20:17
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
//@WebServlet(name = "ValidateServlet")
public class ValidateServlet extends HttpServlet {
    AccountService accountService = new AccountService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (accountService.userLogin(userName,password) && code.equals(randStr)) {
            writer.println("登录成功");
        } else if (!accountService.userLogin(userName,password)){
            writer.println("密码错误重新登录");
        } else if (!code.equals(randStr)) {
            writer.println("验证码错误，请重新输入！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
