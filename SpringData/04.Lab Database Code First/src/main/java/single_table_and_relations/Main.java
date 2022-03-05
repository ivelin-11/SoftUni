package single_table_and_relations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        PlateNumber plateNumber = new PlateNumber("svasdasda");
        Company company = new Company("Airlines");
        Driver driver = new Driver("Az Azov");
        Truck truck = new Truck("truck1", BigDecimal.valueOf(25000), "Diesel", 12d);
        Truck truck2 = new Truck("truck2", BigDecimal.valueOf(25000), "Diesel", 12d);
        Plane plane = new Plane("airsoft", BigDecimal.valueOf(15555), "airNafta", 1000, company);
        Bike bike = new Bike("bmx", BigDecimal.valueOf(1000), "ByFoot");
        Car car = new Car("hatchback", BigDecimal.valueOf(15000), "Gasoline", 4, plateNumber);


        entityManager.persist(plateNumber);
        entityManager.persist(car);

        entityManager.persist(company);
        entityManager.persist(plane);

        driver.addTruck(truck);
        driver.addTruck(truck2);

        entityManager.persist(truck);
        entityManager.persist(truck2);
        entityManager.persist(driver);


        entityManager.persist(bike);


        //first add then execute the select
//        entityManager.find(Driver.class, 5L).getTrucks().forEach(t -> System.out.println(t.getModel()));
       entityManager.getTransaction().commit();


        entityManager.close();
    }
}
