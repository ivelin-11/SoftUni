package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException(getErrorMessage());
        }
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0){
            throw new IllegalArgumentException(getErrorMessage());
        }
        this.age=age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
       if(gender.trim().isEmpty()){
           throw new IllegalArgumentException(getErrorMessage());
       }
       this.gender=gender;
    }


    private String getErrorMessage(){
        return "Invalid input!";
    }

    public String produceSound(){
return null;
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder();
        output.append(this.getClass().getSimpleName()).append("\n");

        output.append(this.name).append(" ")
                .append(this.age).append(" ")
                .append(this.gender).append("\n");

        output.append(this.produceSound());

        return output.toString();
    }
}
