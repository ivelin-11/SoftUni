import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;

public class _08_GetEmployeeWithProject {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        int employeeId = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id=:employeeId",
                        Employee.class).
                setParameter("employeeId", employeeId).getSingleResult();


        System.out.println(employee.getFirstName() + " " + employee.getLastName() +
                " - " + employee.getJobTitle());

        Comparator<Project> compareProjectsByName = new Comparator<Project>() {
            @Override
            public int compare(Project p1, Project p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };

        employee.getProjects().stream().sorted(compareProjectsByName).forEach(p -> System.out.println(p.getName()));


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
