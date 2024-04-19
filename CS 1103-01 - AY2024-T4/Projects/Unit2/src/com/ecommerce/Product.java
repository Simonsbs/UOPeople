// File: com/ecommerce/Product.java
package com.ecommerce;

public class Product {
    private String productID;
    private String name;
    private double price;

    public Product(String productID, String name, double price) {
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
        return "Product{" +
                "ID='" + productID + '\'' +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                '}';
    }
}