package _05_BillsPaymentSystem;

import _05_BillsPaymentSystem.entities.BankAccount;
import _05_BillsPaymentSystem.entities.CreditCard;
import _05_BillsPaymentSystem.entities.CreditCardType;
import _05_BillsPaymentSystem.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Month;

public class _05_Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("DB_Code_First");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        User user = new User("Ivan", "Ivanov", "mymail.com", "123456");
        User user2 = new User("Georgi", "Georgiev", "aa.com", "123456");
        User user3 = new User("Pesho", "Peshov", "bb.com", "123456");

        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.persist(user3);

        CreditCard creditCard=new CreditCard("111",user, CreditCardType.GOLD, Month.JANUARY,2022);
        BankAccount bankAccount=new BankAccount("112",user,"account1","6545");
        CreditCard creditCard2=new CreditCard("211",user2, CreditCardType.BRONZE, Month.FEBRUARY,2022);
        BankAccount bankAccount2=new BankAccount("212",user2,"account2","6545");
        CreditCard creditCard3=new CreditCard("311",user3, CreditCardType.GOLD, Month.MARCH,2022);
        BankAccount bankAccount3=new BankAccount("312",user3,"account3","6545");

        entityManager.persist(creditCard);
        entityManager.persist(bankAccount);
        entityManager.persist(creditCard2);
        entityManager.persist(bankAccount2);
        entityManager.persist(creditCard3);
        entityManager.persist(bankAccount3);

//        User user = entityManager.find(User.class, 1);
//
//
//        System.out.println();
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
