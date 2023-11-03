import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

class Accessory {
    String name;
    double price;
    int quantity;

    public Accessory(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class ShoppingCart {
    LinkedList<Accessory> cart = new LinkedList<>();
    List<Accessory> predefinedAccessories = new LinkedList<>();

    public ShoppingCart() {
        // Define some predefined accessories
        predefinedAccessories.add(new Accessory("Necklace", 30.0, 100));
        predefinedAccessories.add(new Accessory("Bracelet", 20.0, 100));
        predefinedAccessories.add(new Accessory("Ring", 15.0, 100));
        predefinedAccessories.add(new Accessory("Earrings", 10.0, 100));
    }

    public void addToCart(Accessory accessory) {
        cart.add(accessory);
    }

    public void updateCart(String accessoryName, int newQuantity) {
        for (Accessory accessory : cart) {
            if (accessory.name.equals(accessoryName)) {
                accessory.quantity = newQuantity;
                return;
            }
        }
        System.out.println("Accessory not found in the cart.");
    }

    public void deleteFromCart(String accessoryName) {
        for (Accessory accessory : cart) {
            if (accessory.name.equals(accessoryName)) {
                cart.remove(accessory);
                return;
            }
        }
        System.out.println("Accessory not found in the cart.");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            for (Accessory accessory : cart) {
                System.out.println("Accessory: " + accessory.name + " - Price: $" + accessory.price + " - Quantity: " + accessory.quantity);
            }
        }
    }


    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Accessory Shop Menu:");
            System.out.println("1. Add Accessory to Cart");
            System.out.println("2. Update Cart");
            System.out.println("3. Delete from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Accessories:");
                    int index = 1;
                    for (Accessory accessory : shoppingCart.predefinedAccessories) {
                        System.out.println(index + ". " + accessory.name + " - Price: $" + accessory.price + " - Quantity: " + accessory.quantity);
                        index++;
                    }
                    System.out.print("Enter the number of the accessory to add to the cart: ");
                    int accessoryNumber = scanner.nextInt();
                    if (accessoryNumber >= 1 && accessoryNumber <= shoppingCart.predefinedAccessories.size()) {
                        Accessory selectedAccessory = shoppingCart.predefinedAccessories.get(accessoryNumber - 1);
                        shoppingCart.addToCart(new Accessory(selectedAccessory.name, selectedAccessory.price, 1));
                        System.out.println("Added " + selectedAccessory.name + " to the cart.");
                    } else {
                        System.out.println("Invalid accessory number.");
                    }
                    break;
                case 2:
                System.out.print("Enter product name to update: ");
                String updateName = scanner.nextLine();
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                shoppingCart.updateCart(updateName, newQuantity);
                System.out.println("Cart Updated.");
                break;
                  
                case 3:
                System.out.print("Enter product name to delete: ");
                String deleteName = scanner.nextLine();
                shoppingCart.deleteFromCart(deleteName);
                break;
                
                case 4:
                    shoppingCart.viewCart();
                    break;
             
                case 5:
                    System.out.println("You have succesfully place your order. Thank you for using our shop. Please come again. ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}