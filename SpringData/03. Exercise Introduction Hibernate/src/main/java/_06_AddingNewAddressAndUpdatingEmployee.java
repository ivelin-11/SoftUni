import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        //we have town Sofia in the database with id 32
        Town sofiaTown = entityManager.createQuery("SELECT t FROM Town t WHERE t.id=:town_id", Town.class)
                .setParameter("town_id", 32).getSingleResult();

        Address address = new Address();
        address.setText("Vitoshka 15");
        address.setTown(sofiaTown);
        entityManager.persist(address);

        String searchedLastName = scanner.nextLine();

        entityManager.createQuery("UPDATE Employee e SET e.address=:address" +
                        " WHERE e.lastName=:last_name").
                setParameter("address", address).
                setParameter("last_name", searchedLastName).executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
