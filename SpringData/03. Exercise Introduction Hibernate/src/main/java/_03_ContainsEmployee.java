import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String[] namesSearchedFor = scanner.nextLine().split("\\s+");


        long result = entityManager.createQuery("SELECT COUNT (t) FROM Employee t " +
                        "WHERE t.firstName=:first_name " +
                        "AND t.lastName=:last_name", Long.class)
                .setParameter("first_name", namesSearchedFor[0])
                .setParameter("last_name", namesSearchedFor[1])
                .getSingleResult();

        if (result == 0) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");


        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
