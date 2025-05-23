public class Passenger {

    private String name;
  private String  age;
    private String phoneNumber;
    private String cnic;
    private String Gender;
    

    public Passenger(String name, String age,String phoneNumber,String cnic,String Gender) {

      this.name = name;
        this .age=age;
      this.cnic=cnic;
      this.Gender=Gender;
      this.phoneNumber=phoneNumber;
    }


    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
    public String toString() {
        return "Name: " + name + "\n" +
        "Age: " + age + "\n" +
               "Phone Number: " + phoneNumber + "\n" +
               "CNIC: " + cnic + "\n" +
               "Gender: " + Gender;
    }

    
   
}

