import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EmployeeDaoImpl {

    List getUser(String name, String pass) {
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        Query query = null;
        System.out.println(Access.a);
        if (Access.a == 0) {
            String a = "from Employee where username = " + "'" + name + "'" + " and password =" + "'" + pass + "'";
            query = session.createQuery(a);
        }
        if (Access.a == 1) {
            String a = "from Employee where username = " + "'" + name + "'";
            query = session.createQuery(a);
        }

        List l = query.getResultList();
        Iterator it = l.iterator();

        while(it.hasNext())
        {
            Object o = it.next();
            Employee p = (Employee) o;
            System.out.println("Product id : "+p.getId());
            System.out.println("Product Name : "+p.getUsername());
            System.out.println("Product Price : "+p.getAge());
            System.out.println("----------------------");
        }
        // close the connection
        session.close();
        return l;
    }

    ArrayList<Employee> getAllUser() {
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        String a = "from Employee";
        Query query = session.createQuery(a);

        List l = query.getResultList();
        Iterator it = l.iterator();
        ArrayList<Employee> employees = new ArrayList<>();

        while(it.hasNext())
        {
            Object o = it.next();
            Employee p = (Employee) o;
            System.out.println("Product id : "+p.getId());
            System.out.println("Product Name : "+p.getUsername());
            System.out.println("Product Price : "+p.getAge());
            System.out.println("----------------------");
            employees.add(p);
        }
        // close the connection
        session.close();
        return employees;
    }

    String getA() {
        String a = """
                <!doctype html>
                <html lang="en">
                <head>
                    <!-- Required meta tags -->
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                                
                    <!-- Bootstrap CSS -->
                    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
                                
                    <title>Reimburse</title>
                    <style>
                        .wrapper{
                            width: 320px;
                            margin: auto;
                            border-radius: 10px;
                            box-shadow: 5px 10px rgba(51,111,43,255);
                        }
                        .text{
                            color: rgb(35, 149, 202);
                        }
                    </style>
                </head>
                <body class="background_force">
                
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <form action="fifth" method = "get">
                                    <input type="hidden" class="hidden" name="user" id="user">
                                <button class="nav-link">Home </button>
                                </form>
                            </li>
                            <li class="nav-item active">
                                <form action="fifth" method = "get">
                                    <input type="hidden" class="hidden" name="url" id="url" value="1">
                                    <button class="nav-link">Log Out</button>
                                </form>
                            </li>
                        </ul>
                    </div>
                </nav>      
                                
                <center>
                <div className="jumbotron text-center">
                    <h1 className="display-4" id = "nameclass">Reimbursements</h1>
                </div>
                </center>
                <div class="container">
                    <table class="table table-danger table-striped table-bordered table-hover border-rounded">
                                
                        <thead>
                        <tr class="bg-danger">
                            <th>eMail</th>
                            <th>Reason</th>
                            <th>Amount</th>
                            <th>Approval Status</th>
                        </tr>
                        </thead>
                        <tbody id="tables">
                                
                        </tbody>
                                
                    </table>
                                
                </div>
                                
                                
                <script>
                    let searchParams = new URLSearchParams(window.location.search);
                    let x = searchParams.get("user");
                    const b = "1";
                    document.getElementById("user").value = x;
                    document.getElementById("url").value = b;
                </script>
                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
                <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
                                
                                
                                
                
                """;
        return a;
    }
}
