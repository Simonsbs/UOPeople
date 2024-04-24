package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.exceptions.OrderProcessingException;

import java.util.List;

public class Order {
    private String orderID;
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
        this.orderID = orderID;
        this.customer = customer;
        try {
            this.products = customer.getShoppingCart().getProducts();
            this.orderTotal = customer.getShoppingCart().getTotalCost();
        } catch (Exception e) {
            throw new OrderProcessingException("error processing order: " + e.getMessage());
        }
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
        StringBuilder builder = new StringBuilder();
        builder.append("-------------------------\n");
        builder.append("Order:\n");
        builder.append("Order ID: ").append(orderID).append("\n");
        builder.append(customer.toString()).append("\n");
        builder.append("Order lines:\n");
        for (Product product : products) {
            builder.append(product.toString()).append("\n");
        }
        builder.append("Total Order Cost: $").append(String.format("%.2f", orderTotal)).append("\n");
        return builder.toString();
    }
}
