package unit6.models;

import unit6.interfaces.TruckVehicle;

public class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    // Default constructor
    public Truck() {
    }

    // Constructor with all fields
    public Truck(String make, String model, int yearOfManufacture, double cargoCapacity, String transmissionType) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.cargoCapacity = cargoCapacity;
        this.transmissionType = transmissionType;
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
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    // toString method for displaying truck information
    @Override
    public String toString() {
        return "Truck{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", cargoCapacity=" + cargoCapacity +
                ", transmissionType='" + transmissionType + '\'' +
                '}';
    }
}
