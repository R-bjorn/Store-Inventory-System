import java.time.LocalDate;
import java.time.Period;

public class Item extends Store {
    private String title;
    public double regularPrice;
    private int itemID;
    private double discount = 0.0;
    private LocalDate releaseDate;
    private int quantity;
    private static int currentItemID = 9000;

    // Constructors
    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity){
        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        this.quantity = (Math.min(quantity, 100));
        this.quantity = Math.min(100, quantity);
        this.itemID = currentItemID;
        currentItemID += 100;
    }

    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID){
        super();
        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        this.quantity = (Math.min(quantity, 100));
        this.quantity = Math.min(100, quantity);
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
//        System.out.println("Period : " + period.getYears());
        double discountedPrice = regularPrice - (regularPrice * discount);
//        System.out.println("Price : " + discountedPrice);
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
//            System.out.println("Sell date is before releasing date");
            return 0;
        }
        if(amount > 0 && 0 <= quantity){
//            System.out.println("Okay Getting Things Ready");
            this.quantity -= amount;

            return this.getPrice(sellDate)*amount; // Including Tax
        }
        return 0;
    }

    public boolean addStock(int amount){
        if(quantity == 100 || (quantity + amount > 100)){
//            quantity = 100;
            return false;
        }
        quantity += amount;
        return true;
    }

    public String toString(){
        return "ITEM " + (itemID) + ":\n" +
                "\tTitle: " + this.title + "\n" +
            "\tRegular Price: " + this.regularPrice + "\n" +
            "\tRelease Date: " + this.releaseDate + "\n" +
            "\tDiscount: " + this.discount + "\n" +
            "\tQuantity: " + this.quantity + "\n";
    }

    public Object makeCopy(){
        return this;
    }

}
