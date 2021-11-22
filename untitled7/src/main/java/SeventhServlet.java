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

public class SeventhServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("servicing...");
        response.setContentType("text/html");
        String user = request.getParameter("user");
        PrintWriter out = response.getWriter();
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        TransactionsDaoImpl dao1 = new TransactionsDaoImpl();
        ArrayList<Transactions> transactions = new ArrayList<>();
        transactions = dao1.getAllUser();
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
            else if (transactions.get(i).getApproved() == 0){
                a += "<td>\n";
                a += "<form action = \"ninth\" method = \"get\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"user\" id=\"usernam\"" +"value=\"" + user + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_id\" id=\"transac\" + value=\"" + transactions.get(i).getUserId() + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_amount\" id=\"transac_amount\" + value=\"" + transactions.get(i).getAmount() + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_reas\" id=\"transac_reas\" + value=\"" + transactions.get(i).getReason() + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_user\" id=\"transac_user\" + value=\"" + transactions.get(i).getUsername() + "\">\n";
                a += "<input id = \"butto\" class=\"btn bg-info\" type=\"submit\" value=\"Approve\">" + "</form>\n" + "&nbsp;&nbsp;";
                a += "<form action = \"eighth\" method = \"get\">\n" + "<input type=\"hidden\" class=\"hidden\" name=\"user\" id=\"userna\"" +"value=\"" + user + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_id\" id=\"transac\" + value=\"" + transactions.get(i).getUserId() + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_amount\" id=\"transac_amount\" + value=\"" + transactions.get(i).getAmount() + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_reas\" id=\"transac_reas\" + value=\"" + transactions.get(i).getReason() + "\">\n";
                a += "<input type=\"hidden\" class=\"hidden\" name=\"transac_user\" id=\"transac_user\" + value=\"" + transactions.get(i).getUsername() + "\">\n";
                a += "<input id = \"butto2\" class=\"btn bg-info\" type=\"submit\" value=\"Deny\">";
                a += "</form>" ;
                a += "</td>\n";
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
