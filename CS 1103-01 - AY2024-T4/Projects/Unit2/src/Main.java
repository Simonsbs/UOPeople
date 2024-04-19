import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

public class Main {
    public static void main(String[] args) {
        // Create instances of products
        Product product1 = new Product(/* parameters */);
        Product product2 = new Product(/* parameters */);

        // Create an instance of a customer
        Customer customer = new Customer(/* parameters */);

        // Customer browses and adds products to their shopping cart
        // customer.getShoppingCart().addProduct(product1);
        // customer.getShoppingCart().addProduct(product2);

        // Customer places an order
        Order order = new Order(/* parameters using customer and their shopping cart */);

        // Display information
        System.out.println("Order Summary:");
        System.out.println(order); // Assuming toString() method is overridden in Order class
    }
}
