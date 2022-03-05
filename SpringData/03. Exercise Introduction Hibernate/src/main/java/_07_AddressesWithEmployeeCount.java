import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _07_AddressesWithEmployeeCount {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC",
                        Address.class).
                setMaxResults(10).getResultList();

        addresses.forEach(a -> {
            System.out.println(a.getText() + ", " + a.getTown().getName() + " - " + a.getEmployees().size() + " employees");
        });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
