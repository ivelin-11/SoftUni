package CompanRoaster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);

        Map<String,Department> departmentMap=new HashMap<>();

        int n=Integer.parseInt(scann.nextLine());

        //read employees and departments
        while(n-->0){
String[] input=scann.nextLine().split("\\s+");
String name=input[0];
double salary=Double.parseDouble(input[1]);
String position=input[2];
String department=input[3];
Employee employee=null;
if(input.length==4){
    employee=new Employee(name,salary,position,department);
}
else if(input.length==6){
    String mail=input[4];
    int age=Integer.parseInt(input[5]);
    employee=new Employee(name,salary,position,department,mail,age);
}
else if(input.length==5){
    try{
        int age=Integer.parseInt(input[4]);
       employee=new Employee(name,salary,position,department,age);
    }
    catch (NumberFormatException e){
        String email=input[4];
        employee=new Employee(name,salary,position,department,email);
    }
}

departmentMap.putIfAbsent(department,new Department(department));
departmentMap.get(department).getEmployees().add(employee);


        }

        //Map<String,Department> departmentMap=new HashMap<>();
        Department highestPaidDepartment = departmentMap.entrySet()
                .stream().max(Comparator.comparing(entry -> entry.getValue().calculateAverageSalary()))
                .get().getValue();
        System.out.println("Highest Average Salary: "+highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream().
                sorted((e1,e2)->Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
