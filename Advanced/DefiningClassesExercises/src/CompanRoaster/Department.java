package CompanRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees=new ArrayList<>();
    private String name;
public Department(String name){
this.name=name;
employees=new ArrayList<>();
}

    public List<Employee> getEmployees() {
        return employees;
    }
    public double calculateAverageSalary(){
    return  employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.00);
    }

    public String getName() {
        return name;
    }
}
