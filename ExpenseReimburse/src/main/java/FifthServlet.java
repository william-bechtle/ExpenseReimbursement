import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FifthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "0";
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        url = request.getParameter("url");
        System.out.println("name: " + name);
        System.out.println("GET");
        System.out.println("url: " + url);

        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        List l = dao.getUser(name,pass);


        Cookie[] cookies = request.getCookies();
        if (Objects.equals(url, "1")) {
            Access.a = 0;
            System.out.println("hey");
            eraseit eraseit = new eraseit();
            eraseit.eraseCookie(request,response);
            request.getRequestDispatcher("/block.html").include(request, response);
        }

        else if (l.isEmpty()) {
            request.getRequestDispatcher("/login2.html").include(request, response);
        }
        else if (cookies != null) {
            Access.a = 1;
            System.out.println(Access.a);
            request.getRequestDispatcher("/home2.html").include(request, response);
        }
        else {
            Access.a = 1;
            System.out.println(Access.a);
            Cookie cookie = new Cookie("email", name);
            response.addCookie(cookie);
            request.getRequestDispatcher("/home2.html").include(request, response);
        }
    }



};
class eraseit {
    public void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
    }
}