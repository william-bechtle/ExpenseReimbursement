import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

public class EleventhServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servicing...");
        response.setContentType("text/html");
        String username = request.getParameter("user");
        PrintWriter out = response.getWriter();
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        TransactionsDaoImpl dao1 = new TransactionsDaoImpl();
        ArrayList<Transactions> transactions = new ArrayList<>();
        transactions = dao1.getUser(username);
        String a = dao.getA();
        a += "<script>\n";
        a += "document.getElementById(\"tables\").innerHTML += `\n";
        int i =transactions.size();
        i = i - 1;
        while (i > -1) {
            a += "<tr>\n";
            a += "<td>" + transactions.get(i).getUsername() +"</td>\n";
            a += "<td>" + transactions.get(i).getReason() +"</td>\n";
            a += "<td>" + transactions.get(i).getAmount() +"</td>\n";
            if (transactions.get(i).getApproved() == 1) {
                a += "<td>" + "Approved" + "</td>\n";
            }
            else if (transactions.get(i).getApproved() == 2) {
                a += "<td>" + "Denied" + "</td>\n";
            }
            else {
                a += "<td>" + "Pending" + "</td>\n";
            }
            a += "</tr>\n";
            i--;
        }
        a += "</tr>`;\n";
        a += "</script>\n";
        a += "</body>\n";
        a += "</html>\n";

        out.println(a);
    }

}