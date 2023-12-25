package unit6.interfaces;

public interface TruckVehicle extends Vehicle {

    // Method to get the cargo capacity of the truck (in tons)
    double getCargoCapacity();

    // Method to set the cargo capacity of the truck
    void setCargoCapacity(double capacity);

    // Method to get the transmission type of the truck (e.g., manual, automatic)
    String getTransmissionType();

    // Method to set the transmission type of the truck
    void setTransmissionType(String transmissionType);
}
