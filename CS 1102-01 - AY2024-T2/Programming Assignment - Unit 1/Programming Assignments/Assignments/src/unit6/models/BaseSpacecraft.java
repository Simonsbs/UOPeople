package unit6.models;

import java.util.Scanner;

import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

/**
 * Abstract class for a spacecraft
 */
public abstract class BaseSpacecraft {
    protected String name;
    protected String model;
    protected String engineType;
    protected boolean isRentable;
    protected double rentalCostPerParsec;

    /**
     * Default constructor
     */
    public BaseSpacecraft() {
    }

    /**
     * Constructor with all fields
     * 
     * @param name                the name of the spacecraft
     * @param model               the model of the spacecraft
     * @param engineType          the type of engine used by the spacecraft
     * @param isRentable          the rentable status of the spacecraft
     * @param rentalCostPerParsec the rental cost per parsec of the spacecraft
     */
    public BaseSpacecraft(String name, String model, String engineType, boolean isRentable,
            double rentalCostPerParsec) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.isRentable = isRentable;
        this.rentalCostPerParsec = rentalCostPerParsec;
    }

    /**
     * Function to create a new BaseSpacecraft object based on user input
     * 
     * @param scanner    the scanner to use for user input
     * @param spacecraft the spacecraft to create
     * @return the created spacecraft
     */
    protected static BaseSpacecraft createBaseSpacecraftFromInput(Scanner scanner, BaseSpacecraft spacecraft) {
        spacecraft.name = InputValidators.getInput(scanner, "Name: ");
        spacecraft.model = InputValidators.getInput(scanner, "Model: ");
        spacecraft.engineType = InputValidators.getInput(scanner, "Engine Type: ");
        spacecraft.isRentable = InputValidators.getYesNoInput(scanner, "Is Rentable (yes/no): ");
        spacecraft.rentalCostPerParsec = InputValidators.getDoubleInput(scanner, "Rental Cost Per Parsec: ");
        return spacecraft;
    }

    /**
     * Function to edit an existing BaseSpacecraft object based on user input
     * 
     * @param scanner the scanner to use for user input
     */
    protected void editBaseSpacecraftFromInput(Scanner scanner) {
        String name = InputValidators.getEditInput(scanner, "Name");
        if (!name.isEmpty()) {
            this.name = name;
        }

        String model = InputValidators.getEditInput(scanner, "Model");
        if (!model.isEmpty()) {
            this.model = model;
        }

        String engineType = InputValidators.getEditInput(scanner, "Engine Type");
        if (!engineType.isEmpty()) {
            this.engineType = engineType;
        }

        String isRentableStr = InputValidators.getEditInput(scanner, "Is Rentable (y)es/(n)o");
        if (!isRentableStr.isEmpty()) {
            this.isRentable = InputValidators.convertYesNoToBoolean(isRentableStr);
        }

        String rentalCostPerParsecStr = InputValidators.getEditInput(scanner, "Rental Cost Per Parsec");
        if (!rentalCostPerParsecStr.isEmpty() && InputValidators.isValidDouble(rentalCostPerParsecStr)) {
            this.rentalCostPerParsec = Double.parseDouble(rentalCostPerParsecStr);
        }
    }

    /**
     * Function to get the crew capacity of the spacecraft
     * 
     * @return the crew capacity of the spacecraft
     */
    public String getName() {
        return name;
    }

    /**
     * Function to set the crew capacity of the spacecraft
     * 
     * @param name the crew capacity of the spacecraft
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function to get the model of the spacecraft
     * 
     * @return the model of the spacecraft
     */
    public String getModel() {
        return model;
    }

    /**
     * Function to set the model of the spacecraft
     * 
     * @param model the model of the spacecraft
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Function to get the type of engine used by the spacecraft
     * 
     * @return the type of engine used by the spacecraft
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Function to set the type of engine used by the spacecraft
     * 
     * @param engineType the type of engine used by the spacecraft
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * Function to get the rentable status of the spacecraft
     * 
     * @return the rentable status of the spacecraft
     */
    public boolean getIsRentable() {
        return isRentable;
    }

    /**
     * Function to set the rentable status of the spacecraft
     * 
     * @return the rentable status of the spacecraft
     */
    public void setIsRentable(boolean isRentable) {
        this.isRentable = isRentable;
    }

    /**
     * Function to get the rentable status of the spacecraft
     * 
     * @return the rentable status of the spacecraft
     */
    public double getRentalCostPerParsec() {
        return rentalCostPerParsec;
    }

    /**
     * Function to set the rentable status of the spacecraft
     * 
     * @param isRentable the rentable status of the spacecraft
     */
    public void setRentalCostPerParsec(double rentalCostPerParsec) {
        this.rentalCostPerParsec = rentalCostPerParsec;
    }

    /**
     * Function to get the string representation of the spacecraft
     * 
     * @return the string representation of the spacecraft
     */
    @Override
    public String toString() {
        return FormatUtils.padString("| Name: ", name + " |\n") +
                FormatUtils.padString("| Model: ", model + " |\n") +
                FormatUtils.padString("| Engine Type: ", engineType + " |\n") +
                FormatUtils.padString("| Is Rentable: ", InputValidators.convertBooleanToString(isRentable) + " |\n") +
                FormatUtils.padString("| Rental Cost Per Parsec: ", rentalCostPerParsec + " |\n");
    }

}
