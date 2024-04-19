// File: com/ecommerce/orders/Order.java
package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.List;

public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;

    public Order(String orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = customer.getShoppingCart().getProducts();
        this.orderTotal = customer.getShoppingCart().getTotalCost();
    }

    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID='" + orderID + '\'' +
                ", Customer=" + customer +
                ", Products=" + products +
                ", OrderTotal=" + orderTotal +
                '}';
    }
}
