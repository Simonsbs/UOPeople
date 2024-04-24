package com.ecommerce;

public class Customer {
    private String customerID;
    private String name;
    private ShoppingCart shoppingCart;

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
    }

    public String getCustomerID() {
        return customerID;
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
        builder.append("ID: ").append(customerID).append("\n");
        builder.append("Name: ").append(name).append("\n");

        builder.append(shoppingCart);

        return builder.toString();
    }
}
