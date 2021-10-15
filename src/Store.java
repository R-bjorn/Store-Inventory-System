import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
    ArrayList<Item> inventory;
    double totalSalesValue = 0.0;
    int totalNumberOfSales = 0;

    // Constructor
    Store(){
        inventory = new ArrayList<Item>();
    }

    // Methods
    public void addItem(Item newItem){
        inventory.add(newItem);
    }

    private boolean makeSale(int itemId, int quantity, LocalDate sellDate){
        Item item = getItemByID(itemId);
        if(inventory.isEmpty() || getItemByID(itemId) == null){
            return false;
        }
        double value = item.sell(quantity, sellDate);
        if(value > 0){
            totalNumberOfSales++;
            totalSalesValue += value;
        }
        return false;
    }

    private String getInventoryString(){
        String inventoryString = "";
        for(Item item : inventory){
            inventoryString += "\n" + item.toString() + "\n";
        }
        return inventoryString;
    }

    public void listInventory(){
        System.out.println("Here are all the inventory items:");
        System.out.println(getInventoryString());
    }

    public Item checkForItem(int itemId){
        for(Item e : inventory){
            if (e.getItemID() == itemId){
                return (Item) e.makeCopy();
            }
        }
        return null;
    }

    public Item getItemByID(int itemId){
        for(Item e : inventory){
            // Item's properties can be modified by store class
            // because we are returning the real copy of the item (original memory address)
            return e;
        }
        return null;
    }

    public Double getTotalSalesValue(){
        return totalSalesValue;
    }

    public int getTotalNumberOfSales(){
        return totalNumberOfSales;
    }

    public String toString(){
        return "Total sales value: " + totalSalesValue + "Total number of sales: " + totalNumberOfSales + "Current inventory" + getInventoryString();
    }
}
