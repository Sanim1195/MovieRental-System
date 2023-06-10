package Activity2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class MainRentalVideos {

     static HashMap <Integer, RentalVideos> videos = new HashMap<>();
     static HashMap <Integer, Customers> customers = new HashMap<>();
     static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // Main method for Rental videos
    public static void main(String[] args) {

        //Instantiating an object of the  RentalVideos class

        RentalVideos starWars = new RentalVideos("Star Wars ", "Vhs"  );
        RentalVideos lalaLand = new RentalVideos("La La Land ", "DVD"  );
        RentalVideos kiteRunner = new RentalVideos("Kite Runner ", "DVD"  );
        RentalVideos tripToSpain = new RentalVideos("The Trip to Spain ", "DVD"  );


        //Instantiating an object for cutomer class
        Customers alisonStrange = new Customers("Alison", "Strange",32,"022452178","3 Tristram Street, Hamilton","alison.strange@adjunct.openpolytechnic.ac.nz");

        Customers markBrown = new Customers("Mark", "Brown",27,"021401201","450 Queen Street, Auckland","mark.brown1998@gmail.com");



//        Parsing the string value of date to LocalDate format and formatting it using formatter
        LocalDate returnDate = LocalDate.parse("29/05/2022",formatter);

        //Method that rents a customer the movie with current date and time
        starWars.rent(alisonStrange, LocalDate.now());
        lalaLand.rent(markBrown, LocalDate.now());
        kiteRunner.rent(alisonStrange, LocalDate.now());
        tripToSpain.rent(markBrown, LocalDate.now());


        //Method that returns the video and sets the video back to available for rental
        starWars.returnRental();
        tripToSpain.returnRental();

        //System.out.println(rent1.isOverdue(returnDate));

//      putting the instantiated objects into hashMap
        videos.put(01,starWars);
        videos.put(02,lalaLand);
        videos.put(03,kiteRunner);
        videos.put(04,tripToSpain);

        customers.put(01, alisonStrange);
        customers.put(02, markBrown);



        System.out.print(videos.get(01).getTitle() + "Is borrowed by ");
        System.out.print(customers.get(01).getFirstName() + " on " + videos.get(01).getRentDate());

        if (videos.get(01).isRented) {
            System.out.print(" and Returned on " + formatter.format(returnDate));
        }
        else
            System.out.println(" Not returned yet");

        // checking weather the video is overdue and genereting output accordingly
        if(videos.get(01).isRented && videos.get(01).isOverdue(returnDate)){
            System.out.println(" You have to pay $" +
            videos.get(01).calculateFine(returnDate) + "for fine");
        } else
            System.out.println("");



        System.out.print(videos.get(02).getTitle() + "Is borrowed by ");
        System.out.print(customers.get(02).getFirstName() + " on " + videos.get(02).getRentDate());

        if (videos.get(02).isRented) {
            System.out.print(" and Returned on " + formatter.format(returnDate));
        }
        else
            System.out.println(" Not returned yet");

        // checking weather the video is overdue and genereting output accordingly
        if(videos.get(02).isRented && videos.get(02).isOverdue(returnDate)){
            System.out.println(" You have to pay $" +
                    videos.get(02).calculateFine(returnDate) + " for fine");
        } else
            System.out.println(" ");



        System.out.print(videos.get(03).getTitle() + " Is borrowed by ");
        System.out.print(customers.get(01).getFirstName() + " on " + videos.get(03).getRentDate());

        if (videos.get(03).isRented) {
            System.out.print(" and Returned on " + formatter.format(returnDate));
        }
        else
            System.out.println(" Not returned yet");

        // checking weather the video is overdue and genereting output accordingly
        if(videos.get(03).isRented && videos.get(03).isOverdue(returnDate)){
            System.out.println(" You have to pay $" +
                    videos.get(03).calculateFine(returnDate) + " for fine");
        } else
            System.out.println(" ");



        System.out.print(videos.get(04).getTitle() + " Is borrowed by ");
        System.out.print(customers.get(02).getFirstName() + " on " + videos.get(04).getRentDate());

        if (videos.get(04).isRented) {
            System.out.print(" and Returned on " + formatter.format(returnDate));
        }
        else
            System.out.println(" Not returned yet");

        // checking weather the video is overdue and genereting output accordingly
        if(videos.get(04).isRented && videos.get(04).isOverdue(returnDate)){
            System.out.println(" You have to pay $" +
                    videos.get(04).calculateFine(returnDate) + " for fine");
        } else
            System.out.println(" ");





    }


}
