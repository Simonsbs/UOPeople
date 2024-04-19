// File: com/ecommerce/Customer.java
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
        return "Customer{" +
                "ID='" + customerID + '\'' +
                ", Name='" + name + '\'' +
                ", ShoppingCart=" + shoppingCart +
                '}';
    }
}