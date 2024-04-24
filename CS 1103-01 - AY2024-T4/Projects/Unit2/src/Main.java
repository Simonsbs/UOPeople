import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;
import com.ecommerce.exceptions.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Products inspired by popular sci-fi movies and books
            Product lightsaber = new Product("SW001", "Lightsaber", 199.99);
            Product hoverboard = new Product("BTTF001", "Hoverboard", 299.99);
            Product fluxCapacitor = new Product("BTTF002", "Flux Capacitor", 499.99);
            Product replicator = new Product("ST001", "Food Replicator", 1500.00);

            // Sci-fi inspired customer: Marty from "Back to the Future"
            Customer marty = new Customer("BTTF100", "Marty McFly");
            marty.getShoppingCart().addProduct(hoverboard);
            marty.getShoppingCart().addProduct(fluxCapacitor);

            // Sci-fi inspired customer: Luke from "Star Wars"
            Customer luke = new Customer("SW100", "Luke Skywalker");
            luke.getShoppingCart().addProduct(lightsaber);

            Customer jeanLuc = new Customer("ST100", "Jean-Luc Picard");
            jeanLuc.getShoppingCart().addProduct(replicator);

            // Create orders
            Order orderMarty = new Order("BTTF500", marty);
            Order orderLuke = new Order("SW500", luke);
            Order orderJeanLuc = new Order("ST500", jeanLuc);

            // Display orders
            System.out.println("Order Details for Marty McFly:");
            System.out.println(orderMarty);
            System.out.println("\nOrder Details for Luke Skywalker:");
            System.out.println(orderLuke);
            System.out.println("\nOrder Details for Jean-Luc Picard:");
            System.out.println(orderJeanLuc);

        } catch (InvalidProductException | ProductNotFoundException e) {
            System.out.println("Product error: " + e.getMessage());
        } catch (OrderProcessingException e) {
            System.out.println("Order processing error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
