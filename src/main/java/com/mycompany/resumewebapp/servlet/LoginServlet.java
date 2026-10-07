package com.mycompany.resumewebapp.servlet;

import com.mycompany.resumewebapp.student.entity.Student;
import com.mycompany.resumewebapp.student.repo.StudentRepo;
import com.mycompany.resumewebapp.util.ParamUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", value = {"/login"})
public class LoginServlet extends HttpServlet {
    
    private final StudentRepo repo = new StudentRepo();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Object loggedInUser = request.getSession().getAttribute("loggedInUser");
        if (loggedInUser!=null) {
            response.sendRedirect("index");
            return;
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = ParamUtil.get(request.getParameter("email"));
        String password = ParamUtil.get(request.getParameter("password"));
        
        final List<Student> list = repo.getList(null, null, email, null, null, password);
        if(!list.isEmpty()){
            final Student student = list.get(0);
            request.getSession().setAttribute("loggedInUser", student);
        }
        response.sendRedirect("index");
    }
}
/*
Burada:

HttpServlet → Servlet-in əsas sinifidir.
doGet() → GET sorğularını qəbul edir.
HttpServletRequest → istifadəçidən gələn məlumatları saxlayır.
HttpServletResponse → istifadəçiyə göndəriləcək cavabı idarə edir.
*/