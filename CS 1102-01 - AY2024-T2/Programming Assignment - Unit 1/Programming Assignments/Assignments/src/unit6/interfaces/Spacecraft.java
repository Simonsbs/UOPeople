package unit6.interfaces;

import java.util.Scanner;

public interface Spacecraft {

    // Method to get the name of the spacecraft
    String getName();

    // Method to set the name of the spacecraft
    void setName(String name);

    // Method to get the model of the spacecraft
    String getModel();

    // Method to set the model of the spacecraft
    void setModel(String model);

    // Method to get the type of engine used by the spacecraft
    String getEngineType();

    // Method to set the type of engine used by the spacecraft
    void setEngineType(String engineType);

    boolean getIsRentable();

    double getRentalCostPerParsec();

    void setIsRentable(boolean isRentable);

    void setRentalCostPerParsec(double rentalCostPerParsec);

    void editFromInput(Scanner scanner);
}
