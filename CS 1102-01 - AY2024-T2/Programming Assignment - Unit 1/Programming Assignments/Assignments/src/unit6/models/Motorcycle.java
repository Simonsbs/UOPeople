package unit6.models;

import unit6.interfaces.MotorVehicle;

public class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String type; // e.g., sport, cruiser, off-road

    // Default constructor
    public Motorcycle() {
    }

    // Constructor with all fields
    public Motorcycle(String make, String model, int yearOfManufacture, int numberOfWheels, String type) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.numberOfWheels = numberOfWheels;
        this.type = type;
    }

    // Getters and setters for all fields
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    // toString method for displaying motorcycle information
    @Override
    public String toString() {
        return "Motorcycle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", numberOfWheels=" + numberOfWheels +
                ", type='" + type + '\'' +
                '}';
    }
}
