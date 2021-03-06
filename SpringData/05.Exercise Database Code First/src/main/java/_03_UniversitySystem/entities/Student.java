package _03_UniversitySystem.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "_03_students")
public class Student extends Person {

    @Column(name = "average_grade", nullable = false)
    private float averageGrade;

    private int attendance;

    @ManyToMany()
    @JoinTable(
            name = "_03_student_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private Set<Course> courses;

    public Student() {

    }

    public Student(String firstName, String lastName, String number, float averageGrade, int attendance) {
        super(firstName, lastName, number);
        this.averageGrade = averageGrade;
        this.attendance = attendance;
        this.courses = new HashSet<>();
    }

    public void addCourseToStudent(Course course) {
        this.courses.add(course);
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
