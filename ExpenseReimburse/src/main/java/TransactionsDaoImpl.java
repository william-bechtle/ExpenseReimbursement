import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransactionsDaoImpl {

    ArrayList<Transactions> getAllUser() {
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        String a = "from Transactions";
        Query query = session.createQuery(a);

        List l = query.getResultList();
        Iterator it = l.iterator();
        ArrayList<Transactions> transactions = new ArrayList<>();

        while(it.hasNext())
        {
            Object o = it.next();
            Transactions p = (Transactions) o;
            transactions.add(p);
        }
        // close the connection
        session.close();
        return transactions;
    }

    public void deleteTransaction(int transac_id){

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

        String a = "delete from Transactions where id=" + transac_id;
        Transactions transactions = new Transactions();
        transactions.setId(transac_id);
        session.delete(transactions);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }

    public void updateTransaction(int transac_id, String amount, String reason, String user){

        double amoun = Double.parseDouble(amount);
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

        String a = "delete from Transactions where id=" + transac_id;
        Transactions transactions = new Transactions();
        transactions.setId(transac_id);
        transactions.setReason(reason);
        transactions.setUsername(user);
        transactions.setAmount(amoun);
        transactions.setApproved(1);
        session.update(transactions);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }

    public int addTransaction(String amount, String reason, String user){
        double amoun = 0.00;
        try {
             amoun = Double.parseDouble(amount);
        }
        catch (Exception e) {
            System.out.println(e);
            return 1;
        }
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


        Transactions transactions = new Transactions();
        transactions.setReason(reason);
        transactions.setUsername(user);
        transactions.setAmount(amoun);
        transactions.setApproved(0);
        session.save(transactions);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
        return 0;
    }

    ArrayList<Transactions> getUser(String name) {
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        String a = "from Transactions where username ='" + name + "'";
        Query query = session.createQuery(a);

        List l = query.getResultList();
        Iterator it = l.iterator();
        ArrayList<Transactions> transactions = new ArrayList<>();

        while(it.hasNext())
        {
            Object o = it.next();
            Transactions p = (Transactions) o;
            transactions.add(p);
        }
        // close the connection
        session.close();
        return transactions;
    }

    public void updateDeniedTransaction(int transac_id, String amount, String reason, String user){

        double amoun = Double.parseDouble(amount);
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

        String a = "delete from Transactions where id=" + transac_id;
        Transactions transactions = new Transactions();
        transactions.setId(transac_id);
        transactions.setReason(reason);
        transactions.setUsername(user);
        transactions.setAmount(amoun);
        transactions.setApproved(2);
        session.update(transactions);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }

}
