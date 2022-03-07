package _03_UniversitySystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "_03_teachers")
public class Teacher extends Person{

    @Column(nullable = false,unique = true)
    private  String email;

    @Column(name = "salary_per_hour",nullable = false)
    private float salaryPerHour;

    @OneToMany(mappedBy = "teacher",targetEntity = Course.class)
    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String number, String email, float salaryPerHour) {
        super(firstName, lastName, number);
        this.email = email;
        this.salaryPerHour = salaryPerHour;
        this.courses=new HashSet<>();
    }
    public void addCourseToTeacher(Course course) {
        this.courses.add(course);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(float salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
