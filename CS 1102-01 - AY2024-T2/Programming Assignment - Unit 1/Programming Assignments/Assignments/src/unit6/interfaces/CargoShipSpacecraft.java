// interfaces/ShuttleSpacecraft.java
package unit6.interfaces;

/**
 * Interface for a cargo ship spacecraft
 */
public interface CargoShipSpacecraft extends Spacecraft {

    /**
     * Method to get the cargo capacity of the cargo ship
     * 
     * @return the cargo capacity of the cargo ship
     */
    double getCargoCapacity();

    /**
     * Method to set the cargo capacity of the cargo ship
     * 
     * @param cargoCapacity the cargo capacity of the cargo ship
     */
    void setCargoCapacity(double cargoCapacity);

    /**
     * Method to get the presence of a specialized cargo handling system in the
     * cargo ship
     * 
     * @return the presence of a specialized cargo handling system in the cargo ship
     */
    boolean hasSpecializedCargoHandling();

    /**
     * Method to set the presence of a specialized cargo handling system in the
     * cargo ship
     * 
     * @param specializedCargoHandling the presence of a specialized cargo handling
     *                                 system in the cargo ship
     */
    void setSpecializedCargoHandling(boolean specializedCargoHandling);
}
