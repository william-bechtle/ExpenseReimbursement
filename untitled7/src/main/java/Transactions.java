import javax.persistence.*;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    public int getUserId() {
        return id;
    }

    public void setId(int idd) {
        this.id = idd;
    }


    private String username;
    private String reason;
    private double amount;
    private int approved;

    @Column(name = "username", updatable = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String usename) {this.username = usename;}

    @Column(name = "reason", updatable = true, nullable = true)
    public String getReason() {
        return reason;
    }

    public void setReason(String usename) {this.reason = usename;}

    @Column(name = "amount", updatable = true, nullable = false)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amoun) {this.amount = amoun;}

    @Column(name = "approved", updatable = true, nullable = true)
    public int getApproved() {
        return approved;
    }

    public void setApproved(int approv) {this.approved = approv;}
}
