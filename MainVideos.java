package Activity2;

public class MainVideos {
    public static void main (String[] args){

        //instantiating Video objects;
        Videos video1 = new Videos("Shawshank Redemption", "Drama Film", "182 minutes","Movie", "1994",12.22);

        Videos video2 = new Videos("Forrest Gump", "Comedy Drama", "142 minutes","Movie", "1997",12.22);

        //testing getters and setters for Videos class:
        System.out.println("the initial Video name is: " + (video1.getVideoName()));

        video1.setVideoName("The Shawshank Redemption");
        System.out.println("the updated Video name is: " + (video1.getVideoName()));

        System.out.println("");
        System.out.println("the initial Video length is: " + (video1.getLength()));

        video1.setLength("142 minutes");
        System.out.println("the updated Video length is: " + (video1.getLength()));

        System.out.println("");
        System.out.println("The initial video genre of the movie " +(video1.getVideoName())+ " is: " + video1.getGenre());

        video1.setGenre("Drama, Thriller");
        System.out.println("The updated genre of the movie is: " + (video1.getGenre()));

        System.out.println("");
        System.out.println("The initial price of the movie " + (video2.getVideoName()) + " is: " +(video2.getPrice()));

        video2.setPrice(10.99);
        System.out.println("the updated price of the movie " + (video2.getVideoName()) + " is: " +(video2.getPrice()));

        System.out.println("");
        System.out.println("The initial video type of the movie is: " + (video2.getVideoType()));

        video2.setVideoType("Full Movie");
        System.out.println("The updated video type is: " +  (video2.getVideoType() ));

        System.out.println("");
        System.out.println("The initial video release date the movie is: " + (video2.getReleaseDate()));

        video2.setReleaseDate("1994");
        System.out.println("The updated release date is: " +  (video2.getReleaseDate() ));





    }


}
