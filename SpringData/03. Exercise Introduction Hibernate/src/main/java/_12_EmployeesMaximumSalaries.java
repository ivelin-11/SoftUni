

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class _12_EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d "
                        , Department.class)
                .getResultList();


        departments.forEach(d -> {
            Optional<BigDecimal> maxSalary = d.getEmployees().stream().map(Employee::getSalary).
                    filter(s -> s.compareTo(BigDecimal.valueOf(30000)) < 0 ||
                            s.compareTo(BigDecimal.valueOf(70000)) > 0).max(Comparator.naturalOrder());

            if (!maxSalary.isEmpty()) {
                System.out.println(d.getName() + "  " + maxSalary.toString().substring(maxSalary.toString().indexOf("[") + 1,
                        maxSalary.toString().length() - 1));
            }

        });


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
