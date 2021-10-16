import java.time.LocalDate;

public class Game extends Item{
    String studio;
    boolean discontinued;

    public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, String studio, boolean discontinued){
        super(title, regularPrice, releaseDate, quantity);
        this.studio = studio;
        this.discontinued = discontinued;
    }
//      Second Constructor
//    public Game(){
//
//    }

    // Methods

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
    public boolean isDiscontinued(){
        return discontinued;
    }

    public String toString(){
        return super.toString() + "Studio: " + studio + "\nDiscontinued: " + discontinued;
    }

    @Override
    public double getPrice(LocalDate sellDate) {
        super.regularPrice = (discontinued) ? this.regularPrice: this.regularPrice*20;
        return super.getPrice(sellDate);
    }

//    Make a copy function
}
