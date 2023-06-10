package Activity2;

import jdk.jfr.StackTrace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*   Author: Sanim Pokhrel
*   Date: 13/05/2022
* */
public class MainApplication {
    /*
    /*   Creating a static hash map to store key value pairs for RentalVideos and Customers class objects
     */
        static Map<Integer,RentalVideos> rentalVideoMap  = new HashMap<>();
        static Map <Integer,Customers> customerMap  = new HashMap<>();
    static int number = 1 ;

        static Scanner sc = new Scanner(System.in);

    //method to add a new video to rental store:
        public static void addRentalVideo(){

            System.out.println("Enter the video title: ");
            String title = sc.nextLine();

            System.out.println("Enter the media type: ");
            String media = sc.nextLine();

            //Instantiating an object of video based on the user input1
            RentalVideos video = new RentalVideos(title,media);

            rentalVideoMap.put(number++ , video);
            System.out.println("Video entered successfully: ");
            System.out.println("");
        }

        // a method to delete a video from the list
        public static void deleteRentalVideo(){

            // displaying all the items in the rentalVideoMap to the customer to select which video to delete
            for (int keys:  rentalVideoMap.keySet()){
                System.out.println("ID: " + keys + " video name = "+rentalVideoMap.get(keys));
                System.out.println("");
            }
        //  Taking video key as an input
            System.out.println("Enter the key: ");
            int videoKey = Integer.parseInt(sc.nextLine());

            System.out.println("Are you sure you want to delete the "+ rentalVideoMap.get(videoKey).getTitle() + " video? " );
            System.out.println("Enter y for Yes and n for No...");
            String finalDecision = sc.nextLine();

            // Loop to check if the user really wants to delete the video
             if (finalDecision.equals("y")|| finalDecision.equals("Y")) {
                rentalVideoMap.remove(videoKey);
                System.out.println("Video removed successfully");
            } else if (finalDecision.equals("n")) {
                System.out.println("No changes has been made in the system");
            } else
                System.out.println("enter y for delete or n for no ");

        }

    // Method to create a new customer :
        public static void addCustomer(){
            int customerNumber = 1;

            System.out.println("Enter Customer first name: ");
            String firstName = sc.nextLine();

            System.out.println("Enter Customer last name: ");
            String lastName = sc.nextLine();

            System.out.println("Enter Customer age: ");
            int age = Integer.parseInt( sc.nextLine());

            System.out.println("Enter Customer phone number ");
            String phoneNumber = sc.nextLine();

            System.out.println("Enter Customer city: ");
            String city = sc.nextLine();

            System.out.println("Enter Customer email id: ");
            String emailId = sc.nextLine();

            //instantiating an object of customer class based on the user input
            Customers customer = new Customers(firstName,lastName,age,phoneNumber,city,emailId);

            //putting the Customers object in the map:
            customerMap.put(customerNumber++, customer);
            System.out.println("");

        }

        // Method to delete a customer:
        public static void deleteCustomer(){

            //displaying the customer list i the system before deletion:
            for (int keys:  customerMap.keySet()){
                System.out.println("ID: " + keys + " Customers Name = "+customerMap.get(keys));
                System.out.println("");
            }
            System.out.println("Enter customer ID");
            int customerId = Integer.parseInt(sc.nextLine());
            System.out.println("Are you sure you want to delete the customer?? ");
            System.out.println("Enter y for yes and n for no...");
            String finalDecision = sc.nextLine();

            if (finalDecision.equals("y")){
                customerMap.remove(customerId);
            }else
                System.out.println("no changes has been made in the system");


        }

        // A method that rents a video if available
        public static void rentAVideo() {
            //display the list of videos to rent
            for (int keys : rentalVideoMap.keySet()) {
                System.out.println("ID: " + keys + " Video Name = " + rentalVideoMap.get(keys));
                System.out.println("");
            }
            System.out.println("Enter the video id you want to rent");
            int videoKey = Integer.parseInt(sc.nextLine());

            //Displaying the customers in the map to identify the customer willing to rent a video
            for (int keys : customerMap.keySet()) {
                System.out.println("ID: " + keys + " Customers Name = " + customerMap.get(keys));
                System.out.println("");
            }
            System.out.println("Enter the customer id who wants to rent the video" + rentalVideoMap.get(videoKey).getTitle());
            int customerId = Integer.parseInt(sc.nextLine());

            //checking if the video is not rented
            if (!rentalVideoMap.get(videoKey).isRented) {
                // Since the video is not rented, renting a video
                rentalVideoMap.get(videoKey).rent(customerMap.get(customerId), LocalDate.now());
                //displaying the videos in the map with customer info to make sure the video has been rented
                for (int keys : rentalVideoMap.keySet()) {
                    System.out.println("ID: " + keys + " Video name = " + rentalVideoMap.get(keys));
                    System.out.println("");
                }

            }else
                System.out.println("The video is already rented");
        }

        public static void returnAVideo(){
            System.out.println("Enter the video key you want to return ");
            int videoKey = Integer.parseInt(sc.nextLine());
            if (!rentalVideoMap.containsKey(videoKey)){
                System.out.println("the video does not exist hahahah");
            }
            rentalVideoMap.get(videoKey).returnRental();
            if (rentalVideoMap.get(videoKey).isOverdue(LocalDate.now())){
                System.out.println("You have to pay $");
                rentalVideoMap.get(videoKey).calculateFine(LocalDate.now());
                System.out.println(" fine");
            }else
                System.out.println("No fine !!");
        }


        // Reading the video csv file from the computer:
        public static void readVideoFile(){
            //initializing an array to hold the customers info before putting it in the map
            RentalVideos[] videoArray  = new RentalVideos[100000000];

            try {
                BufferedReader videoFile = new BufferedReader(new FileReader("C:\\csv\\videosCSV.csv"));
                //Reading the line from the above specified csv file
                String line = videoFile.readLine();
                int videoIdNumber= 0;

                do{
                     line = videoFile.readLine();

                    if (line == null)
                        break;

                    videoArray[videoIdNumber] = new RentalVideos(line);

                //Putting the items from the csv to the maps
                    rentalVideoMap.put(videoIdNumber, videoArray[videoIdNumber]  );
                    videoIdNumber++;

                    System.out.println(line);



                } while (true);



            } catch (Exception e){
                System.out.println("The file cannot be opened");
                e.printStackTrace();
            }

        }
    public static void readCustomerFile(){
        Customers[] customerArray  = new Customers[100000000];
        try {
            BufferedReader customerFile = new BufferedReader(new FileReader("C:\\csv\\customers.csv"));
            //Reading the line from the above specified csv file
            String line = customerFile.readLine();  // This is a header line in the file so it's not being used
            int customerNumber= 0;
            do{
                line = customerFile.readLine();

                if (line == null)
                    break;
                customerArray[customerNumber] = new Customers(line);
                //Putting the items from the csv to the maps
                customerMap.put(customerNumber, customerArray[customerNumber]  );
                customerNumber++;


                System.out.println(line);

            } while (true);



        } catch (Exception e){
            System.out.println("The file cannot be opened");
            e.printStackTrace();
        }

    }

    //Saving all the videos from the hashmap to the csv files
    public static void saveVideoFile() {

        String map1 = rentalVideoMap.entrySet().toString();
        System.out.println(rentalVideoMap.size());
        RentalVideos[] rv = new RentalVideos[rentalVideoMap.size()];

        try {
            FileWriter file = new FileWriter("C:\\csv\\practice.csv", true);
            for (int key : rentalVideoMap.keySet()) {
                file.write(key + ";" + rentalVideoMap.get(key).toLine());

            }
            file.close();

            System.out.println(rv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Saving all the customer info in the map to the csv file
    public static void saveCustomerFile(){

            String  map  =  customerMap.entrySet().toString();
            System.out.println(customerMap.size());
            Customers []  cv = new Customers[customerMap.size()];

            try{
                FileWriter file = new FileWriter("C:\\csv\\customer.csv",true);
                for (int key: customerMap.keySet()){
                    file.write(key + ";" + customerMap.get(key).toLine());

                }
                file.close();


            }
            catch(Exception e){
                e.printStackTrace();
            }

    }




    public static void main(String[] args){

        /*//RentalVideos objects:
        RentalVideos starWars = new RentalVideos("Star Wars ", "Vhs"  );
        RentalVideos lalaLand = new RentalVideos("La La Land ", "DVD"  );
        RentalVideos kiteRunner = new RentalVideos("Kite Runner ", "DVD"  );
        RentalVideos tripToSpain = new RentalVideos("The Trip to Spain ", "DVD"  );*/



        System.out.println("Choose an option: ");
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(input <13) {

            System.out.println("1- Add a new rental video ");
            System.out.println("2- Delete an existing rental video  ");
            System.out.println("3- Print the list of rental videos ");
            System.out.println("4- Add a new customer ");
            System.out.println("5- Delete an existing customer ");
            System.out.println("6- Print the list of customers ");
            System.out.println("7- Rent a video ");
            System.out.println("8- Return a video ");
            System.out.println("9- Save all rental videos on file ");
            System.out.println("10- Read all rental videos from file ");
            System.out.println("11- Save all customers on the file ");
            System.out.println("12- Read customers on the file ");
            System.out.println("13- Quit ");
            try {
                input = Integer.parseInt(sc.nextLine());
            }
           catch (Exception e){
               System.out.println("Enter a number from 1 to 13");
               //input = Integer.parseInt(sc.nextLine());
           }

            switch (input){
                case 1:
                    addRentalVideo();
                    break;
                case 2:

                    try {
                        deleteRentalVideo();
                    }
                    catch (Exception e){
                        System.out.println("Enter the video id ");
                        input = Integer.parseInt(sc.nextLine());
                    }

                    break;
                case 3:
                    for (int keys:  rentalVideoMap.keySet()){
                        System.out.println("ID: " + keys + " Video name = "+rentalVideoMap.get(keys));
                        System.out.println("");
                    }
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                case 6:

                    for (int keys:  customerMap.keySet()){
                    System.out.println("ID: " + keys +customerMap.get(keys));
                    System.out.println("");
                }
                    break;
                case 7:
                    rentAVideo();
                    break;
                case 8:
                    returnAVideo();
                    break;
                case 9:
                    saveVideoFile();
                    break;
                case 10:
                    readVideoFile();
                    break;
                case 11:
                    saveCustomerFile();
                    break;
                case 12:
                    readCustomerFile();

                    break;
                case 13:
                    System.out.println("Thank- you");
                    break;
                default:
                    System.out.println("Please Enter a number between 1 to 13 !!");
            }

        }




    }
}
