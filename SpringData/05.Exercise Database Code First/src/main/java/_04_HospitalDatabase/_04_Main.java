package _04_HospitalDatabase;

import _04_HospitalDatabase.entities.Diagnose;
import _04_HospitalDatabase.entities.Patient;
import _04_HospitalDatabase.entities.PrescribedMedicament;
import _04_HospitalDatabase.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _04_Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("DB_Code_First");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Patient patient = new Patient("Georgi", "Georgiev", "Sofia",
                LocalDate.of(2005, 12, 2), true);
        Patient patient2 = new Patient("Pesho", "Peshov", "Sofia",
                LocalDate.of(2007, 10, 2), true);
        Patient patient3 = new Patient("Ivan", "Ivanov", "Sofia",
                LocalDate.of(2009, 11, 3), true);

        Diagnose diagnose = new Diagnose("Headache");

        Diagnose diagnose2 = new Diagnose("Stomach pain");
        Diagnose diagnose3 = new Diagnose("High body temperature");


        entityManager.persist(patient);
        entityManager.persist(patient2);
        entityManager.persist(patient3);
        entityManager.persist(diagnose);
        entityManager.persist(diagnose2);
        entityManager.persist(diagnose3);

        PrescribedMedicament prescribedMedicament = new PrescribedMedicament("Analgin");
        PrescribedMedicament prescribedMedicament2 = new PrescribedMedicament("Nurofen");
        PrescribedMedicament prescribedMedicament3 = new PrescribedMedicament("Hapcheta za bolki v stomacha");


        entityManager.persist(prescribedMedicament);
        entityManager.persist(prescribedMedicament2);
        entityManager.persist(prescribedMedicament3);

        Visitation visitation = new Visitation(LocalDate.of(2020, 12, 12),
                patient, diagnose);
        visitation.addMedicamentToVisitation(prescribedMedicament);
        visitation.addMedicamentToVisitation(prescribedMedicament2);

        Visitation visitation2 = new Visitation(LocalDate.of(2021, 12, 12),
                patient2, diagnose2);
        visitation2.addMedicamentToVisitation(prescribedMedicament3);

        Visitation visitation3 = new Visitation(LocalDate.of(2021, 10, 10),
                patient3, diagnose3);
        visitation3.addMedicamentToVisitation(prescribedMedicament2);


        Visitation visitation4 = new Visitation(LocalDate.of(2021, 10, 10),
                patient, diagnose2);
        visitation4.addMedicamentToVisitation(prescribedMedicament3);

        entityManager.persist(visitation);
        entityManager.persist(visitation2);
        entityManager.persist(visitation3);
        entityManager.persist(visitation4);


//        Patient findPatient = entityManager.find(Patient.class, 1L);
//        System.out.println(findPatient.getFirstName() + " " + findPatient.getLastName());
//        findPatient.getVisitations().forEach(v->
//            System.out.println(
//                    "Date of visitation: "+v.getDate()+", Diagnose: "+v.getDiagnose().getName()+
//                    ", Medicaments:" +v.getPrescribedMedicaments().stream().map(PrescribedMedicament::getName).collect(Collectors.joining(", "))));

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
