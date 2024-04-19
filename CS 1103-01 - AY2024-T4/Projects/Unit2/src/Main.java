import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;

public class Main {
    public static void main(String[] args) {
        Product book = new Product("B001", "Java Programming", 59.99);
        Product laptop = new Product("L001", "High-end Laptop", 1200.00);

        Customer customer = new Customer("C100", "Alice");
        customer.getShoppingCart().addProduct(book);
        customer.getShoppingCart().addProduct(laptop);

        Order order = new Order("O500", customer);
        System.out.println(order);
    }
}
