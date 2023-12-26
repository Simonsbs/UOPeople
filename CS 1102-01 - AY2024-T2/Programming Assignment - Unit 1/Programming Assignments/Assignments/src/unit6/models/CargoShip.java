package unit6.models;

import java.util.Scanner;

import unit6.interfaces.CargoShipSpacecraft;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

public class CargoShip extends BaseSpacecraft implements CargoShipSpacecraft {
    private double cargoCapacity;
    private boolean specializedCargoHandling;

    // Default constructor
    public CargoShip() {
    }

    // Constructor with all fields
    public CargoShip(String name, String model, String engineType, boolean isRentable, double rentalCostPerParsec,
            double cargoCapacity,
            boolean specializedCargoHandling) {

        super(name, model, engineType, isRentable, rentalCostPerParsec);
        this.cargoCapacity = cargoCapacity;
        this.specializedCargoHandling = specializedCargoHandling;
    }

    // Function to create a new CargoShip object based on user input
    public static CargoShip createCargoShipFromInput(Scanner scanner) {
        System.out.println("Enter CargoShip details:");

        CargoShip cargoShip = (CargoShip) BaseSpacecraft.createBaseSpacecraftFromInput(scanner, new Shuttle());
        cargoShip.cargoCapacity = InputValidators.getDoubleInput(scanner, "Cargo Capacity: ");
        cargoShip.specializedCargoHandling = InputValidators.getYesNoInput(scanner,
                "Specialized Cargo Handling (yes/no): ");

        return cargoShip;
    }

    // Function to edit an existing CargoShip object based on user input
    public void editCargoShipFromInput(Scanner scanner) {
        System.out.println("Editing CargoShip details:");

        super.editBaseSpacecraftFromInput(scanner);

        String cargoCapacityStr = InputValidators.getInput(scanner,
                "New Cargo Capacity (leave blank to keep current): ");
        if (!cargoCapacityStr.isEmpty() && InputValidators.isValidDouble(cargoCapacityStr)) {
            setCargoCapacity(Double.parseDouble(cargoCapacityStr));
        }

        String specializedHandlingStr = InputValidators.getInput(scanner,
                "New Specialized Cargo Handling (yes/no, leave blank to keep current): ");
        if (!specializedHandlingStr.isEmpty()) {
            setSpecializedCargoHandling(InputValidators.convertYesNoToBoolean(specializedHandlingStr));
        }
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
        return FormatUtils.hr("CargoShip") + "\n" +
                super.toString() +
                FormatUtils.padString("| Cargo Capacity: ", cargoCapacity + " |\n") +
                FormatUtils.padString("| Specialized Handling: ",
                        InputValidators.convertBooleanToString(specializedCargoHandling) + " |\n")
                +
                FormatUtils.hr() + "\n";
    }
}
