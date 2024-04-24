package com.ecommerce;

public class Customer {
    private String id;
    private String name;
    private ShoppingCart shoppingCart;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer:\n");
        builder.append("- ID: ").append(id).append("\n");
        builder.append("- Name: ").append(name).append("\n");

        builder.append(shoppingCart);

        return builder.toString();
    }
}
