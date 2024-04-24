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
        if (customer == null || customer.getShoppingCart() == null) {
            throw new OrderProcessingException("Invalid customer data or shopping cart for order.");
        }
        this.orderID = orderID;
        this.customer = customer;
        try {
            this.products = customer.getShoppingCart().getProducts();
            this.orderTotal = customer.getShoppingCart().getTotalCost();
        } catch (Exception e) {
            throw new OrderProcessingException("Failed to process order details: " + e.getMessage());
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
        builder.append("Order Summary\n");
        builder.append("Order ID: ").append(orderID).append("\n");
        builder.append("Customer Name: ").append(customer.getName()).append("\n");
        builder.append("Customer ID: ").append(customer.getCustomerID()).append("\n");
        builder.append("Products Ordered:\n");
        for (Product product : products) {
            builder.append(" - ").append(product.getName())
                    .append(" (ID: ").append(product.getProductID())
                    .append(", Price: $").append(String.format("%.2f", product.getPrice()))
                    .append(")\n");
        }
        builder.append("Total Order Cost: $").append(String.format("%.2f", orderTotal)).append("\n");
        return builder.toString();
    }
}
