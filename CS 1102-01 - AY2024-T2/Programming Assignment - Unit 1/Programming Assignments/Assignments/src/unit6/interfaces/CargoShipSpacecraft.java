package unit6.interfaces;

public interface CargoShipSpacecraft extends Spacecraft {

    // Method to get the cargo capacity of the cargo ship (e.g., in metric tons)
    double getCargoCapacity();

    // Method to set the cargo capacity of the cargo ship
    void setCargoCapacity(double cargoCapacity);

    // Method to check if the cargo ship has a specialized cargo handling system
    boolean hasSpecializedCargoHandling();

    // Method to set the presence of a specialized cargo handling system in the
    // cargo ship
    void setSpecializedCargoHandling(boolean specializedCargoHandling);

    // Additional methods can be added to address other unique aspects of cargo
    // ships
}
