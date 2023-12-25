package unit6.interfaces;

public interface MotorVehicle extends Vehicle {

    // Method to get the number of wheels on the motorcycle
    int getNumberOfWheels();

    // Method to set the number of wheels on the motorcycle
    void setNumberOfWheels(int numberOfWheels);

    // Method to get the type of the motorcycle (e.g., sport, cruiser, off-road)
    String getType();

    // Method to set the type of the motorcycle
    void setType(String type);
}
