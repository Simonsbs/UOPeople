// interfaces/Spacecraft.java
package unit6.interfaces;

import java.util.Scanner;

/**
 * Interface for a spacecraft
 */
public interface Spacecraft {

    /**
     * Method to get the name of the spacecraft
     * 
     * @return the name of the spacecraft
     */
    String getName();

    /**
     * Method to set the name of the spacecraft
     * 
     * @param name the name of the spacecraft
     */
    void setName(String name);

    /**
     * Method to get the model of the spacecraft
     * 
     * @return the model of the spacecraft
     */
    String getModel();

    /**
     * Method to set the model of the spacecraft
     * 
     * @param model the model of the spacecraft
     */
    void setModel(String model);

    /**
     * Method to get the type of engine used by the spacecraft
     * 
     * @return the type of engine used by the spacecraft
     */
    String getEngineType();

    /**
     * Method to set the type of engine used by the spacecraft
     * 
     * @param engineType the type of engine used by the spacecraft
     */
    void setEngineType(String engineType);

    /**
     * Method to get the rentable status of the spacecraft
     * 
     * @return the rentable status of the spacecraft
     */
    boolean getIsRentable();

    /**
     * Method to set the rentable status of the spacecraft
     * 
     * @return the rentable status of the spacecraft
     */
    double getRentalCostPerParsec();

    /**
     * Method to set the rentable status of the spacecraft
     * 
     * @param isRentable the rentable status of the spacecraft
     */
    void setIsRentable(boolean isRentable);

    /**
     * Method to get the rental cost per parsec of the spacecraft
     * 
     * @param rentalCostPerParsec the rental cost per parsec of the spacecraft
     */
    void setRentalCostPerParsec(double rentalCostPerParsec);

    /**
     * Method to get the weapon system of the spacecraft
     * 
     * @param scanner the scanner to use for user input
     */
    void editFromInput(Scanner scanner);

    /**
     * Method to get the type name of the spacecraft
     * 
     * @return the type name of the spacecraft
     */
    String getTypeName();
}
