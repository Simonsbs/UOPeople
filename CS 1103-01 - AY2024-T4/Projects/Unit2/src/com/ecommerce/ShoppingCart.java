package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.exceptions.ProductNotFoundException;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) throws ProductNotFoundException {
        if (product == null) {
            throw new IllegalArgumentException("Cannot add a null to the cart");
        }
        // Example check for duplicates, if needed
        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                throw new IllegalArgumentException("Cannot add product with same id to the cart.");
            }
        }
        products.add(product);
    }

    public boolean removeProduct(Product product) throws ProductNotFoundException {
        if (product == null) {
            throw new IllegalArgumentException("Cannot remove a null from the cart.");
        }
        if (!products.contains(product)) {
            throw new ProductNotFoundException("Product not found in the cart.");
        }
        return products.remove(product);
    }

    public void clearCart() {
        products.clear();
    }

    public double getTotalCost() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (products.isEmpty()) {
            builder.append("cart is empty.\n");
        } else {
            builder.append("Cart:\n");
            for (Product product : products) {
                builder.append(product.toString()).append("\n");
            }
        }
        return builder.toString();
    }
}
