package _05_BillsPaymentSystem.entities;

import javax.persistence.*;

@Entity(name ="_05_billings_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String number;

    @ManyToOne()
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


    public BillingDetail() {
    }

    public BillingDetail(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
