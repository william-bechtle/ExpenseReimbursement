import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.internal.TransactionImpl;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("project started...");

        // create a configuration object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        //Employee employee = new Employee();
        //employee.setId(2);;
        //employee.setUsername("Mark");
        //employee.setPassword("password");
        //employee.setGender("Male");
        //employee.setAge(19);

        Transactions transactions = new Transactions();

        transactions.setAmount(100.40);
        transactions.setUsername("wjbechtle@gmail.com");
        transactions.setReason("bahamas");
        transactions.setApproved(0);



        // save the employee
        session.save(transactions);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }
}
