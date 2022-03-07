package _05_BillsPaymentSystem.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bank_account")
public class BankAccount extends BillingDetail{


    private String name;

    @Column(name= "swift_code")
    private String swtifCode;

    public BankAccount(String number, User user, String name, String swtifCode) {
        super(number, user);
        this.name = name;
        this.swtifCode = swtifCode;
    }

    public BankAccount(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwtifCode() {
        return swtifCode;
    }

    public void setSwtifCode(String swtifCode) {
        this.swtifCode = swtifCode;
    }
}
