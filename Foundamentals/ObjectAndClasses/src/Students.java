


public class Students {
  private String firstName;
  private String lastName;
  private int age;
  private String hometown;

  public Students(String firstname,String lastName,int age,String hometown){
      this.firstName=firstname;
      this.lastName=lastName;
      this.age=age;
      this.hometown=hometown;
  }



    public String getFirstName(){
      return  this.firstName;
}



    public String getLastName() {
        return lastName;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return this.hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String toString(){
    return this.firstName+" "+this.lastName+" is "+this.age+" years old";
  }


}
