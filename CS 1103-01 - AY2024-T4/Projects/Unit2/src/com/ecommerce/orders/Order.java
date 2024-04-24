package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.exceptions.OrderProcessingException;

import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;

    public Order(String orderID, Customer customer) throws OrderProcessingException {
        if (customer == null) {
            throw new OrderProcessingException("missing customer");
        }
        if (customer.getShoppingCart() == null) {
            throw new OrderProcessingException("missing shopping cart for order.");
        }
        this.id = orderID;
        this.customer = customer;
        try {
            this.products = customer.getShoppingCart().getProducts();
            this.orderTotal = customer.getShoppingCart().getTotalCost();
        } catch (Exception e) {
            throw new OrderProcessingException("error processing order: " + e.getMessage());
        }
    }

    public String getId() {
        return id;
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
        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------\n");
        builder.append("Order:\n");
        builder.append("- ID: ").append(id).append("\n");
        builder.append(customer.toString()).append("\n");
        builder.append("- Lines:\n");
        for (Product product : products) {
            builder.append(product.toString()).append("\n");
        }
        builder.append("-- Total Order: $").append(String.format("%.2f", orderTotal)).append("\n");
        return builder.toString();
    }
}
