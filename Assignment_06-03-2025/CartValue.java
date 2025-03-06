import java.util.Map;
import java.util.HashMap;

// class CartValue have all methods to perform all the operation on cart
public class CartValue{
    private final Map<Item, Integer> cart;
    public CartValue(){
        this.cart = new HashMap<>();
    }
    
    // add item to cart, parameters as item object and quantity, it add item to cart
    public void addToCart(Item item, Integer quantity){
        if(cart.containsKey(item)){
        cart.put(item, cart.get(item) + quantity);
        }
        else{
            cart.put(item, quantity);
        }
    }

    // display quantity, return the quantity of that item in cart 
    public Integer displayQty(Item item){
        return cart.containsKey(item) ? cart.get(item) : 0;
    }
    
    // Update quantity, update the quantity of that item in cart
    public void updateQty(Item item, Integer quantity){
        if(cart.containsKey(item));
        cart.put(item, quantity);
    }
    
    // delete item, delete the item form cart if it is present in cart
    public void deleteItem(Item item){
        if(cart.containsKey(item)){
        cart.remove(item);
        System.out.println("Item deleted successfully");
    }
    else{
        System.out.println("Item is not present in your cart");
    }
    }
    
    // display bill, return the total bill amount of cart
    public int displayBill(){
        int total = 0;
        for(Item item : cart.keySet()){
            total += item.getPrice() * cart.get(item);
        }
        return total;
    }
}