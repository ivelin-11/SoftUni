import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> searchedDepartments = Arrays.stream("Engineering,Tool Design,Marketing,Information Services".split(",")).collect(Collectors.toList());

        entityManager.getTransaction().begin();


//        syntax error
//       entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary*1.12 " +
//                        " WHERE e.department.name IN (:searchedDepartments)").
//               setParameter("searchedDepartments", searchedDepartments).executeUpdate();


        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name IN (:searchedDepartments)", Employee.class).
                setParameter("searchedDepartments", searchedDepartments).getResultList();

        //update and print - it is not the best way but it works :) like an alternative to the above one
        employees.forEach(e -> {
            e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
            entityManager.persist(e);
            System.out.printf(e.getFirstName() + " " + e.getLastName() + " ($%.2f)%n", e.getSalary());
        });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
