package com.ecommerce.orders;

import com.ecommerce.Customer;
import java.util.List;
import com.ecommerce.Product;

public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;
}
