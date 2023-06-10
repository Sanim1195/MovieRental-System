package Activity2;


import java.time.LocalDate;
/*
* Creating customer class
* */
public class Customers {

    // creating instance variables:
    String firstName ;     // firstName: holds the first name of the customer
    String lastName ;      //lastName: holds the last name of the customer
    int age ;               // age: to store the age of the customer
    String phoneNumber ;    // phoneNumber: to store the customers phone number
    String city ;           // city: to store the customers city
    String emailId;         // emailId to store customers emailId


/*
* A default constructor for the customer class:
* */
    public Customers(){}

    /*
     * creating constructor method for Customers class
     * */
    public Customers(String firstName,String lastName,int age, String phoneNumber,String city, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.emailId = emailId;
    }
    /*
     *               Creating a constructor to take data from csv file as tokens and assigning it to
     *                           it's corresponding instance variable
     * */
    public Customers (String line ){
        String [] tokens = line.split(";");
        this.firstName = tokens[1];
        this.lastName = tokens[2];
        this.age = Integer.parseInt( tokens[3]);
        this.phoneNumber = tokens[4];
        this.city = tokens[5];
        this.emailId = tokens[6];
    }


/*
* Creating Getters and Setters for each instance variable
* */

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



        public String toString () {
            return "first name: " + getFirstName() + " last NAme " + getLastName() + " age " + getAge()+" phone nummber " + getPhoneNumber()+" city: " + getCity()+" emailId " + getEmailId();
        }

    public String toLine () {
        return  getFirstName() + " ; " + getLastName() + " ; " + getLastName()+" ;" + getPhoneNumber()+" ; " + getCity()+" ; "
                + getEmailId() +"\n";
    }


}
