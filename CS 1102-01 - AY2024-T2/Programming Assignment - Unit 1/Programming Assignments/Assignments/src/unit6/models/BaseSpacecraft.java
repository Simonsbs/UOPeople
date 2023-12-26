package unit6.models;

import java.util.Scanner;

import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

public abstract class BaseSpacecraft {
    protected String name;
    protected String model;
    protected String engineType;
    protected boolean isRentable;
    protected double rentalCostPerParsec;

    // Constructors
    public BaseSpacecraft() {
    }

    public BaseSpacecraft(String name, String model, String engineType, boolean isRentable,
            double rentalCostPerParsec) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.isRentable = isRentable;
        this.rentalCostPerParsec = rentalCostPerParsec;
    }

    // Generic function to create a BaseSpacecraft object based on user input
    protected static BaseSpacecraft createBaseSpacecraftFromInput(Scanner scanner, BaseSpacecraft spacecraft) {
        spacecraft.name = InputValidators.getInput(scanner, "Name: ");
        spacecraft.model = InputValidators.getInput(scanner, "Model: ");
        spacecraft.engineType = InputValidators.getInput(scanner, "Engine Type: ");
        spacecraft.isRentable = InputValidators.getYesNoInput(scanner, "Is Rentable (yes/no): ");
        spacecraft.rentalCostPerParsec = InputValidators.getDoubleInput(scanner, "Rental Cost Per Parsec: ");
        return spacecraft;
    }

    // Generic function to edit an existing BaseSpacecraft object based on user
    // input
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

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public boolean getIsRentable() {
        return isRentable;
    }

    public void setIsRentable(boolean isRentable) {
        this.isRentable = isRentable;
    }

    public double getRentalCostPerParsec() {
        return rentalCostPerParsec;
    }

    public void setRentalCostPerParsec(double rentalCostPerParsec) {
        this.rentalCostPerParsec = rentalCostPerParsec;
    }

    @Override
    public String toString() {
        return FormatUtils.padString("| Name: ", name + " |\n") +
                FormatUtils.padString("| Model: ", model + " |\n") +
                FormatUtils.padString("| Engine Type: ", engineType + " |\n") +
                FormatUtils.padString("| Is Rentable: ", InputValidators.convertBooleanToString(isRentable) + " |\n") +
                FormatUtils.padString("| Rental Cost Per Parsec: ", rentalCostPerParsec + " |\n");
    }

}
