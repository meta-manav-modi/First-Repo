import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/** Class ShoopingCart is used to maintain a cart for all available items,
 * ans have different kind of methods and operations
 */

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

        // Loop to the menu 
        while(run){
            //........... Menu.........
            System.out.println("1. Add an item to cart:");
            System.out.println("2. Display Quantity:");
            System.out.println("3. Update Quantity:");
            System.out.println("4. Delete an item:");
            System.out.println("5. Display cart total bill:");
            System.out.println("6. Exit:");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            String Id;

            // Switch case to show the menu:
            switch(choice){
                case 1:                 // Add item to cart
                    System.out.println("Available items:");
                    for(String key : items.keySet()){
                        System.out.println(key + ", " + items.get(key).getName() + ", " 
                        + items.get(key).getDescription() 
                        + ", " + items.get(key).getPrice());
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

                case 2:                  // Display quantity of an item in cart
                    System.out.println("Enter item Id to display quantity:");
                    Id = scanner.next();
                    if(items.containsKey(Id)){
                        System.out.println("Quantity:" + cart.displayQty(items.get(Id)));
                    }
                    else{
                        System.out.println("Item not found");
                    }
                    break;

                case 3:                      //update quantity of an item in cart
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
                    
                case 4:               // Delete an item from cart
                    System.out.println("Enter item ID to delete:"); 
                    Id= scanner.next();
                    if(items.containsKey(Id)){
                        cart.deleteItem(items.get(Id));
                    }
                    else{
                        System.out.println("Item not found");
                    }
                    break;

                case 5:                // Display total bill of cart
                    System.out.println("Total Bill is: Rs " + cart.displayBill());
                    break;
                    
                case 6:             // Exit
                    run = false;
                    break;

                default:
                    System.out.println("Invalid choice. Plrase try again. ");
            }
        }
        scanner.close();
    }
}