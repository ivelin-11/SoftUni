

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;


public class _11_FindEmployeesByFirstName {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);


        entityManager.getTransaction().begin();

        String prefixForSearch = scanner.nextLine();
        String pattern = prefixForSearch + "%";

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern).getResultList();

        employees.forEach(e -> {
            System.out.printf(e.getFirstName() + " " + e.getLastName() + " - " + e.getDepartment().getName() + " - " + " ($%.2f)%n", e.getSalary());
        });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
