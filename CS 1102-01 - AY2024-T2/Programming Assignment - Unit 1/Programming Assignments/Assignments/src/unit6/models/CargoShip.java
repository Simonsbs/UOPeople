package unit6.models;

import unit6.interfaces.CargoShipSpacecraft;

public class CargoShip implements CargoShipSpacecraft {
    private String name;
    private String model;
    private String engineType;
    private double cargoCapacity;
    private boolean specializedCargoHandling;

    // Default constructor
    public CargoShip() {
    }

    // Constructor with all fields
    public CargoShip(String name, String model, String engineType, double cargoCapacity,
            boolean specializedCargoHandling) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.cargoCapacity = cargoCapacity;
        this.specializedCargoHandling = specializedCargoHandling;
    }

    // Implement all interface methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getEngineType() {
        return engineType;
    }

    @Override
    public void setEngineType(String engineType) {
        this.engineType = engineType;
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
    public boolean hasSpecializedCargoHandling() {
        return specializedCargoHandling;
    }

    @Override
    public void setSpecializedCargoHandling(boolean specializedCargoHandling) {
        this.specializedCargoHandling = specializedCargoHandling;
    }

    // toString method for displaying cargo ship information
    @Override
    public String toString() {
        return "CargoShip{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", cargoCapacity=" + cargoCapacity +
                ", specializedCargoHandling=" + specializedCargoHandling +
                '}';
    }
}
