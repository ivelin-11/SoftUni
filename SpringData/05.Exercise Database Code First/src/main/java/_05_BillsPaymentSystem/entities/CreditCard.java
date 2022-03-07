package _05_BillsPaymentSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Month;
import java.time.Year;

@Entity
public class CreditCard extends BillingDetail {

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_card_type")
    private CreditCardType creditCardType;

    @Column(name = "expiration_month")
    private Month expirationMonth;

    @Column(name = "expiration_year")
    private Integer expirationYear;

    public CreditCard(String number, User user, CreditCardType creditCardType, Month expirationMonth, int expirationYear) {
        super(number, user);
        this.creditCardType = creditCardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }



    public CreditCard() {
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public Month getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Month expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
