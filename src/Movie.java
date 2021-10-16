import java.time.LocalDate;

public class Movie extends Item{
    String director;
    String producer;

    public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, String director, String producer){
        super(title, regularPrice, releaseDate, quantity);
        this.director = director;
        this.producer = producer;
    }
//  Only for copying
//    public Movie(){
//
//    }

    // Methods

    public String toString(){
        return super.toString() + "\tDirector: " + director + "\n\tProducer: " +producer;
    }

//    Copy Function
//    public
}
