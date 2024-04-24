// File: com/ecommerce/Product.java
package com.ecommerce;

import com.ecommerce.exceptions.InvalidProductException;

public class Product {
    private String productID;
    private String name;
    private double price;

    public Product(String productID, String name, double price) {
        if (productID == null || productID.isEmpty()) {
            throw new InvalidProductException("Product ID cannot be null or empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidProductException("Product name cannot be null or empty.");
        }
        if (price < 0) {
            throw new InvalidProductException("Price cannot be negative.");
        }
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product Details:\n" +
                "ID: " + productID + "\n" +
                "Name: " + name + "\n" +
                "Price: $" + String.format("%.2f", price);
    }
}
