// class Item is used to initialize the values
public class Item{
    private String itemId;
    private String name;
    private String description;
    private int price;
    
    // Constructor to initialize all values
    public Item(String itemId, String name, String description, int price){
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
    }


// Getter functions for price, description, name
public String getName(){
    return name;
}
public String getDescription(){
    return description;
}
public int getPrice(){
    return price;
}
}