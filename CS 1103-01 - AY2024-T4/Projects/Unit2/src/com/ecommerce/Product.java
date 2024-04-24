// File: com/ecommerce/Product.java
package com.ecommerce;

import com.ecommerce.exceptions.InvalidProductException;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String productID, String name, double price) throws InvalidProductException {
        if (productID == null || productID.isEmpty()) {
            throw new InvalidProductException("missing pruduct ID");
        }
        if (name == null || name.isEmpty()) {
            throw new InvalidProductException("missing product name");
        }
        if (price < 0) {
            throw new InvalidProductException("invalid price, must be greater than or equal to 0");
        }
        this.id = productID;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product:\n");
        builder.append("- ID: ").append(id).append("\n");
        builder.append("- Name: ").append(name).append("\n");
        builder.append("- Price: $").append(String.format("%.2f", price)).append("\n");
        return builder.toString();
    }
}
