package unit6.interfaces;

public interface CarVehicle extends Vehicle {

    // Method to get the number of doors in the car
    int getNumberOfDoors();

    // Method to set the number of doors in the car
    void setNumberOfDoors(int numberOfDoors);

    // Method to get the fuel type of the car (e.g., petrol, diesel, electric)
    String getFuelType();

    // Method to set the fuel type of the car
    void setFuelType(String fuelType);
}
