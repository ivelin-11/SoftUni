import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _05_EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name=:department_name " +
                        "ORDER BY e.salary ASC,e.id ASC", Employee.class).
                setParameter("department_name", "Research and Development").getResultList();


        employees.forEach(e -> {
            System.out.printf(e.getFirstName() + " " + e.getLastName() + " from " +
                    e.getDepartment().getName() + " -$%.2f%n", e.getSalary());
        });

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
