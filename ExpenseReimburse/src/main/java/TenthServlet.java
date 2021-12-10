import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TenthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int res;
        PrintWriter out = response.getWriter();
        System.out.println("servicing...");
        response.setContentType("text/html");
        String user = request.getParameter("user");
        String amount = request.getParameter("email");
        String reason = request.getParameter("password");
        TransactionsDaoImpl dao = new TransactionsDaoImpl();
        res = dao.addTransaction(amount,reason,user);
        if (res == 1) {
            request.getRequestDispatcher("/transacform2.html").include(request, response);
        }
        else {
            request.getRequestDispatcher("/fifth").include(request, response);
        }
    }

}
