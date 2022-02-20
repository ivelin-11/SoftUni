package CompanRoaster;

public class Employee {
    private String name;
    private double salary;
    private String postion;
    private String department;

    //optional
    private String email;
    private int age;

    public Employee(String name,double salary,String position,String department){
        this.name=name;
        this.salary=salary;
        this.postion=position;
        this.department=department;
        this.email="n/a";
        this.age=-1;
    }

    public Employee(String name,double salary,String position,String department,String email,int age){
        this(name,salary,position,department);
        this.email=email;
        this.age=age;
    }
    public Employee(String name,double salary,String position,String department,String email){
        this(name,salary,position,department);
        this.email=email;
    }
    public Employee(String name,double salary,String position,String department,int age){
        this(name,salary,position,department);

        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPostion() {
        return postion;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",this.name,
                this.salary,this.email,this.age);
    }
}
