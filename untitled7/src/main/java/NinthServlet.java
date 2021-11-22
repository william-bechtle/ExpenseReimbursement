import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NinthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servicing...");
        response.setContentType("text/html");
        String transac_id = request.getParameter("transac_id");
        String transac_amount = request.getParameter("transac_amount");
        String transac_reas = request.getParameter("transac_reas");
        String transac_user = request.getParameter("transac_user");

        int transc = Integer.parseInt(transac_id);
        TransactionsDaoImpl dao = new TransactionsDaoImpl();
        dao.updateTransaction(transc, transac_amount,transac_reas,transac_user);
        request.getRequestDispatcher("/seventh").include(request, response);
    }

}
