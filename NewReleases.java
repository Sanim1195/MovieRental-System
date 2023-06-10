package Activity2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class NewReleases extends RentalVideos {
    static HashMap<Integer, RentalVideos> videos = new HashMap<>();
    static HashMap <Integer, Customers> customers = new HashMap<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //defining a constructor for NewReleases class:
        public NewReleases (String title, boolean isRented, LocalDate rentDate, String myMedia, Customers renter){
            // Calling the super method to provide values in super class constructor
            super(title, isRented, rentDate, myMedia, renter);


        }

        //@over-riding the superclass calculate fine method to increment fine as $2 per day

        public  int calculateFine(LocalDate today){

            LocalDate dueDate = rentDate.plusDays(5);
    //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    ////        System.out.println(formatter.format(dueDate));
            Period days = Period.between(dueDate,today);
            //System.out.println("The days is  " +(days.getDays() * 2 ));
            if (days.getDays() > 0){
                int fine =days.getDays()* 2 ;
                return fine;

            }else
                return 0;


        }
    public static void main (String[] args){
            NewReleases drStrange = new NewReleases("The man with the Watch ", false, null, null ,null);

        Customers Leo = new Customers("Leo", "Asparagus",22,"9841391710","Dunidin","leo@getmemail.com");

//        Parsing the string value of date to LocalDate format and formatting it using formatter
        LocalDate returnDate = LocalDate.parse("14/05/2022",formatter);

        //Method that rents a customer the movie with current date and time
        drStrange.rent(Leo, LocalDate.now());

        //Method that returns the video and sets the video back to available for rental
         //drStrange.returnRental();

        //System.out.println(rent1.isOverdue(returnDate));

//      putting the instantiated objects into hashMap
        videos.put(01,drStrange);
        customers.put(01, Leo);


        System.out.print(videos.get(01).getTitle() + "Is borrowed by ");
        System.out.print(customers.get(01).getFirstName() + " on " + videos.get(01).getRentDate());

        if (videos.get(01).isRented) {
            System.out.print("and Returned on " + formatter.format(returnDate));
        }
        else
            System.out.println("Not returned yet");

        // checking weather the video is overdue and genereting output accordingly
        if(videos.get(01).isRented && videos.get(01).isOverdue(returnDate)){
            System.out.println(" You have to pay $" +
                    videos.get(01).calculateFine(returnDate) + "for fine");
        } else
            System.out.println("no fine");





    }
}



