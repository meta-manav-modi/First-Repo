import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class Item{
    private String itemId;
    private String name;
    private String description;
    private int price;

    public Item(String itemId, String name, String description, int price){
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

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
class CartValue{
    private final Map<Item, Integer> cart;
    public CartValue(){
        this.cart = new HashMap<>();
    }

    public void addToCart(Item item, Integer quantity){
        if(cart.containsKey(item)){
        cart.put(item, cart.get(item) + quantity);
        }
        else{
            cart.put(item, quantity);
        }
    }
    public Integer DisplayQty(Item item){
        return cart.containsKey(item) ? cart.get(item) : 0;
    }

    public void updateQty(Item item, Integer quantity){
        if(cart.containsKey(item));
        cart.put(item, quantity);
    }

    public void deleteItem(Item item){
        if(cart.containsKey(item)){
        cart.remove(item);
        System.out.println("Item deleted successfully");
    }
    else{
        System.out.println("Item is not present in your cart");
    }
    }

    public int displayBill(){
        int total = 0;
        for(Item item : cart.keySet()){
            total += item.getPrice() * cart.get(item);
        }
        return total;
    }
}
public class ShoopingCart{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CartValue cart = new CartValue();
     Map<String, Item> items = new HashMap<>();
     items.put("201",new Item("201","Laptop","Office Laptop",30000));
     items.put("202",new Item("202","Mouse","Wireless Mouse",1000));
     items.put("203",new Item("203","Keyboard","Mechanical Keyboard",2000));
     items.put("204",new Item("204","Mic","Clear sound",2000));
     items.put("205",new Item("205","Headphone","Noice Cancelling",3000));
        boolean run=true;
        while(run){
            System.out.println("1. Add an item to cart:");
            System.out.println("2. Display Quantity:");
            System.out.println("3. Update Quantity:");
            System.out.println("4. Delete an item:");
            System.out.println("5. Display cart total bill:");
            System.out.println("6. Exit:");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            String Id;
            switch(choice){
                case 1:
                    System.out.println("Available items:");
                    for(String key : items.keySet()){
                        System.out.println(key + ", " + items.get(key).getName() + ", " + items.get(key).getDescription() + ", " + items.get(key).getPrice());
                    }
                    System.out.println("Enter item Id:");
                    Id = scanner.next();
                    if(items.containsKey(Id)){
                        System.out.println("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        if(quantity<0){
                            System.out.println("Invalid Quantity");
                            break;
                        }
                        cart.addToCart(items.get(Id), quantity);
                        System.out.println("Item added successfully");
                    }
                    else{
                        System.out.println("Invalid item no");
                    }
                    break;

                case 2:
                    System.out.println("Enter item Id to display quantity:");
                    Id = scanner.next();
                    if(items.containsKey(Id)){
                        System.out.println("Quantity:" + cart.DisplayQty(items.get(Id)));
                    }
                    else{
                        System.out.println("Item not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter Item Id to update");
                    Id = scanner.next();
                    if(items.containsKey(Id)){
                        System.out.println("Enter new Quantity: ");
                        int newQty = scanner.nextInt();
                        if(newQty<0){
                            System.out.println("Invalid Quantity");
                            break;
                        }
                        cart.updateQty(items.get(Id), newQty);
                        System.out.println("Quantity updated successfully");
                    }
                    else{
                        System.out.println("item not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter item ID to delete:"); 
                    Id= scanner.next();
                    if(items.containsKey(Id)){
                        cart.deleteItem(items.get(Id));
                    }
                    else{
                        System.out.println("Item not found");
                    }
                    break;
                case 5:
                    System.out.println("Total Bill is: Rs " + cart.displayBill());
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Plrase try again. ");
            }
        }
        scanner.close();
    }
}