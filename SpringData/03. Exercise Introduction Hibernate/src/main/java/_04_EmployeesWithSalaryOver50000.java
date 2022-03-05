import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class _04_EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<String> employeesFirstNames = entityManager.createQuery("SELECT e.firstName FROM Employee e WHERE e.salary>:salary", String.class).
                setParameter("salary", BigDecimal.valueOf(50000)).getResultList();

        employeesFirstNames.forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
