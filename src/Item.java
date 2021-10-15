import java.time.LocalDate;
import java.time.Period;

public class Item extends Store {
    String title;
    double regularPrice;
    int itemID;
    double discount = 0.0;
    LocalDate releaseDate;
    int quantity;
    static int currentItemID = 9000;

    // Constructors
    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity){
        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        this.quantity = (Math.min(quantity, 100));
        this.quantity = quantity;
        currentItemID += 100;
    }

    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID){
        super();
        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        this.quantity = (Math.min(quantity, 100));
        this.quantity = quantity;
        this.itemID = itemID;
    }

    // Methods
    public int getItemID(){ return this.itemID; }
    public String getTitle(){ return this.title; }
    public LocalDate getReleaseDate(){ return this.releaseDate; }
    public double getRegularPrice(){ return this.regularPrice; }
    public double getDiscount(){ return this.discount; }
    public int getQuantity(){ return this.quantity; }
    public double getPrice(LocalDate sellDate){
        Period period = Period.between(releaseDate, sellDate);
        double discountedPrice = regularPrice - (regularPrice * discount);
        return ((period.getYears() > 0) ? (discountedPrice - discountedPrice*0.5) : discountedPrice);
    }

    public boolean setDiscount(double discount){
        double discountedPrice = regularPrice - (regularPrice * discount);
        if(discountedPrice == 0 || discount > 0.5){
            return false;
        }
        this.discount = discount;
        return true;
    }

    public double sell(int amount, LocalDate sellDate){
        Period period = Period.between(releaseDate, sellDate);
        if(period.isNegative()){
            return 0;
        }
        if(amount > 0 && 0 <= quantity){
            quantity--;
            return getPrice(sellDate)*1.13; // Including Tax
        }
        return 0;
    }

    public boolean addStock(int amount){
        if(quantity == 100 || (quantity + amount > 100)){
            return false;
        }
        quantity += amount;
        return true;
    }

    public String toString(){
        return "ITEM: " + (currentItemID-100) + "\n" +
                "Title: " + this.title + "\n" +
            "Regular Price: " + this.regularPrice + "\n" +
            "Release Date: " + this.releaseDate + "\n" +
            "Discount: " + this.discount + "\n" +
            "Quantity: " + this.quantity + "\n";
    }

    public Object makeCopy(){
        return this;
    }

}
