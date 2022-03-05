import entities.Address;
import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _13_RemoveTowns {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String townToDelete = scanner.nextLine();

        entityManager.getTransaction().begin();

        int townIdToDelete=entityManager.createQuery("SELECT t.id FROM Town t WHERE t.name = :townToDelete",Integer.class)
                .setParameter("townToDelete", townToDelete).getSingleResult();


//        //with name gives syntax error
//        int deleteAddresses = entityManager.createQuery("DELETE FROM Address a WHERE a.town.name = :townToDelete")
//                .setParameter("townToDelete", townToDelete).executeUpdate();



        //set employee addresses to null because they are in child table and are reffered to address -> id
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.address.town.id = :townIdToDelete",Employee.class)
                .setParameter("townIdToDelete",townIdToDelete).getResultList().
                forEach(e->{
                    e.setAddress(null);
                   entityManager.flush();
                });
        entityManager.getTransaction().commit();       //flush it to update values of address_id in database



        entityManager.getTransaction().begin();
        int deleteAddresses=entityManager.createQuery("DELETE FROM Address a WHERE a.town.id =:townIdToDelete")
                .setParameter("townIdToDelete", townIdToDelete).executeUpdate();


       entityManager.createQuery("DELETE FROM Town t WHERE t.name = :townToDelete")
           .setParameter("townToDelete", townToDelete).executeUpdate();



        if (deleteAddresses == 1) {
            System.out.printf("%d address in %s deleted%n", deleteAddresses, townToDelete);
        }
        else if (deleteAddresses > 1) {
            System.out.printf("%d addresses in %s deleted%n", deleteAddresses, townToDelete);
        }
        else{
            System.out.println("No such town exist in the database");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
