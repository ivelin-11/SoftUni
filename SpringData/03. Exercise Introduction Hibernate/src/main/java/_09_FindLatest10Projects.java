import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class _09_FindLatest10Projects {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class).
                setMaxResults(10).getResultList();

        Comparator<Project> compareProjectsByName = new Comparator<Project>() {
            @Override
            public int compare(Project p1, Project p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        projects.stream().sorted(compareProjectsByName).forEach(p -> {
            System.out.println("Project name: " + p.getName());
            System.out.println("Project Description: " + p.getDescription());

            //substract 3 hours because it has different in output because of the timezones
            System.out.println("Project Start Date: " + p.getStartDate().minusHours(3).format(dateTimeFormatter));

            //check if date is null because format throws NullPointerException
            String endDate = null;
            if (p.getEndDate() != null) {
                endDate = p.getEndDate().minusHours(3).format(dateTimeFormatter);
            }
            System.out.println("Project End Date: " + endDate);
        });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
