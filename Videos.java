package Activity2;

/*
* Creating video class
* */
public class Videos {
    String videoName; //Stores the name of the video
    String genre;   //stores the genre of the video
    String length;  //stores the length of the video
    String videoType;   //stores the type of the video
    String releaseDate;  //Stores the initial release date of the video
    double price;   //Stores the price of teh video

/*
* Creating Construtctor method for our Videos class
* */

    public Videos(String videoName, String genre,String length,String videoType,String releaseDate, double price){
        this.videoName = videoName;
        this.genre = genre;
        this.length = length;
        this.releaseDate = releaseDate;
        this.videoType = videoType;
        this.price = price;
    }

    /*
    *               Creating a constructor to take data from csv file as tokens and assigning it to
    *                           it's corresponding instance variable
    * */

    public Videos (String line ){
        String [] tokens = line.split(";");
        this.videoName = tokens[1];
        this.videoType = tokens[5];
    }

/*
* Creating Getters and Setters for the instance variables
* */
    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
