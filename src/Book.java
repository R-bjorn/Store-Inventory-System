import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Book extends Item {
        ArrayList<String> authors;

        // Constructors
        public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors){
            super(title,regularPrice,releaseDate,quantity);
            this.authors = authors;
        }
        public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors, int itemID){
            super(title, regularPrice, releaseDate, quantity, itemID);
            this.authors = authors;
        }

        // Methods
        public ArrayList<String> getAuthors(){
            return (ArrayList<String>) authors.clone();
        }

        public String toString(){
            StringBuilder author = new StringBuilder();
            for(String s : authors) author.append("\n\t\t").append(s);
            return super.toString()  + "\tAuthors:" + author;
        }

        public double getPrice(LocalDate sellDate){
            return regularPrice - (regularPrice * discount);
        }

        public Object makeCopy(){
            try {
                return this.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }



}
