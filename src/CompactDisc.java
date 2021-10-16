import java.time.LocalDate;

public class CompactDisc extends Item{
    String bandName;
    String recordLabel;

    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel){
        super(title, regularPrice, releaseDate, quantity);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
    }
    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName){
        this(title,regularPrice,releaseDate,quantity,bandName,"Indie");
    }
//    3rd constructor
    public String toString(){
        return super.toString() + "Band: " + bandName + "\nRecord Label: " + recordLabel;
    }

    // Make a copy function

}
