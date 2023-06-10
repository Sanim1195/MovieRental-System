package Activity2;

import java.time.LocalDate;

public class MainCustomers {
    public static void main(String[] args){
        /*
        * Instantiatng Customers objects using constructor method
        * */
    Customers customer = new Customers("Lorem", "Ipsum",32,"9856027262","Otago", "helpme@gmail.com");

    Customers customer1 = new Customers("Munni", "Badnam",52,"0276554373","Auckland","helpme@gmail.com");

    //Defining local variables
        String firstName;
        String lastName;
        String city;
        String phoneNumber;
        int age;

        //Testing the getters and setters for each instance variable created in Customers class
        firstName =  customer.getFirstName();
        System.out.println("The initial name is: "+firstName);

        customer.setFirstName("George");
        System.out.println("The updated Name is: "+(customer.getFirstName()));

        lastName = customer.getLastName();
        System.out.println("The initial last name is: "+ lastName);

        customer.setLastName("Washington");
        System.out.println("The updated last name is: " + (lastName = customer.getLastName()));


        city = customer1.getCity();
        System.out.println("the initial city is: "+city);

        customer1.setCity("Tauranga");
        System.out.println("the updated city is: "+ (customer1.getCity()));

        phoneNumber = customer1.getPhoneNumber();
        System.out.println("teh initial phone number is: " + phoneNumber);

        customer1.setPhoneNumber("027156442");
        System.out.println("The update phone number is: " + (customer1.getPhoneNumber()));

        System.out.println("The initial Age is: "+(customer1.getAge()));

        customer1.setAge(45);
        System.out.println("The updated Age is: "+ (customer1.getAge()));
    }

}
