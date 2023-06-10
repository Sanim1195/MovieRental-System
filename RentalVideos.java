package Activity2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
* Creating a class and allowing it to implement (use) methods from Rental class.
* */
 class RentalVideos implements Rentals  {

    String title;      //To store the title of the renting/rented item
    boolean isRented;   //Stores a true value if the video is rented else fasle
    LocalDate rentDate; // To store the date when the video was rented
    String myMedia;     //To store the media type of rented video;
    Customers renter;   //To store the information of the customer who rented the video.

    //creating default construcor so that other classes can inherit this Class
    public RentalVideos(){}


    //Overriding the default constructor to take in parameters.
    public RentalVideos (String title,String myMedia){
        this.title = title;
        this.myMedia = myMedia;
    }

    //Overriding the default constructor to take in parameters.
    public RentalVideos(String title, boolean isRented, LocalDate rentDate, String myMedia, Customers renter){

        this.title = title;
        this.isRented = isRented;
        this.rentDate = rentDate;
        this.myMedia = myMedia;
        this.renter = renter;

    }

    /*
     *               Creating a constructor to take data from csv file as tokens and assigning it to
     *                           it's corresponding instance variable
     * */
    public RentalVideos (String line ){
        String [] tokens = line.split(";");
        this.title = tokens[1];
        this.myMedia = tokens[2];
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getMyMedia() {
        return myMedia;
    }

    public void setMyMedia(String myMedia) {
        this.myMedia = myMedia;
    }

    public boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public Customers getRenter() {
        return renter;
    }

    public void setRenter(Customers renter) {
        this.renter = renter;
    }

    //Renting an item to the customer and assigning rent values:
    public  void rent(Customers p, LocalDate today){

        setRenter(p);
        setRentDate(today);
        setIsRented(true);

    }

    //Method that returns a book
    public void returnRental(){
        setIsRented(false);

    }
    //Method that checks weather the book is overdue or not
    public boolean isOverdue(LocalDate today){


        return (Period.between(rentDate,today).getDays()>5);
    }

    //implementing a method to calculate fine if the book is overdue.
    public  int calculateFine(LocalDate today){

        LocalDate dueDate = rentDate.plusDays(5);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
////        System.out.println(formatter.format(dueDate));
        Period days = Period.between(dueDate,today);
        //System.out.println("The days is  " +(days.getDays() * 2 ));
        if (days.getDays() > 0){
            int fine =days.getDays()* 1 ;
            return fine;

        }else
            return 0;

    }


    public String  toString(){
        return " Title: " + getTitle() +" is rented: " + getIsRented() +" rent Date" + getRentDate()+ " Type of media: " + getMyMedia() + " the renter is " + getRenter() ;

    }

    public String  toLine(){
       return getTitle() +";" +  getMyMedia() + "\n " ;

    }


}



