package unit6.models;

import java.util.Scanner;

import unit6.interfaces.CargoShipSpacecraft;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

/**
 * Class for a cargo ship
 */
public class CargoShip extends BaseSpacecraft implements CargoShipSpacecraft {
    private double cargoCapacity;
    private boolean specializedCargoHandling;

    /**
     * Default constructor
     */
    public CargoShip() {
    }

    /**
     * Constructor with all fields
     * 
     * @param name                     the name of the cargo ship
     * @param model                    the model of the cargo ship
     * @param engineType               the type of engine used by the cargo ship
     * @param isRentable               the rentable status of the cargo ship
     * @param rentalCostPerParsec      the rental cost per parsec of the cargo ship
     * @param cargoCapacity            the cargo capacity of the cargo ship
     * @param specializedCargoHandling the presence of a specialized cargo handling
     *                                 system in the cargo ship
     */
    public CargoShip(String name, String model, String engineType, boolean isRentable, double rentalCostPerParsec,
            double cargoCapacity,
            boolean specializedCargoHandling) {

        super(name, model, engineType, isRentable, rentalCostPerParsec);
        this.cargoCapacity = cargoCapacity;
        this.specializedCargoHandling = specializedCargoHandling;
    }

    /**
     * Function to get the type name of the cargo ship
     * 
     * @return the type name of the cargo ship
     */
    public String getTypeName() {
        return "CargoShip";
    }

    /**
     * Function to create a new CargoShip object based on user input
     * 
     * @param scanner the scanner to use for user input
     * @return the created cargo ship
     */
    public static CargoShip createCargoShipFromInput(Scanner scanner) {
        System.out.println(FormatUtils.hr("=", " Enter CargoShip details "));

        CargoShip cargoShip = (CargoShip) BaseSpacecraft.createBaseSpacecraftFromInput(scanner, new CargoShip());
        cargoShip.cargoCapacity = InputValidators.getDoubleInput(scanner, "Cargo Capacity: ");
        cargoShip.specializedCargoHandling = InputValidators.getYesNoInput(scanner,
                "Specialized Cargo Handling (yes/no): ");

        return cargoShip;
    }

    /**
     * Function to edit an existing CargoShip object based on user input
     * 
     * @param scanner the scanner to use for user input
     */
    public void editFromInput(Scanner scanner) {
        System.out.println(FormatUtils.hr("=", " Edit CargoShip details "));

        super.editBaseSpacecraftFromInput(scanner);

        String cargoCapacityStr = InputValidators.getEditInput(scanner, "Cargo Capacity");
        if (!cargoCapacityStr.isEmpty() && InputValidators.isValidDouble(cargoCapacityStr)) {
            setCargoCapacity(Double.parseDouble(cargoCapacityStr));
        }

        String specializedHandlingStr = InputValidators.getEditInput(scanner, "Specialized Cargo Handling yes/no");
        if (!specializedHandlingStr.isEmpty()) {
            setSpecializedCargoHandling(InputValidators.convertYesNoToBoolean(specializedHandlingStr));
        }
    }

    /**
     * Method to get the cargo capacity of the cargo ship
     * 
     * @return the cargo capacity of the cargo ship
     */
    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Method to set the cargo capacity of the cargo ship
     * 
     * @param cargoCapacity the cargo capacity of the cargo ship
     */
    @Override
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Method to get the presence of a specialized cargo handling system in the
     * cargo ship
     * 
     * @return the presence of a specialized cargo handling system in the cargo ship
     */
    @Override
    public boolean hasSpecializedCargoHandling() {
        return specializedCargoHandling;
    }

    /**
     * Method to set the presence of a specialized cargo handling system in the
     * cargo ship
     * 
     * @param specializedCargoHandling the presence of a specialized cargo handling
     *                                 system in the cargo ship
     */
    @Override
    public void setSpecializedCargoHandling(boolean specializedCargoHandling) {
        this.specializedCargoHandling = specializedCargoHandling;
    }

    /**
     * Function to get the string representation of the cargo ship
     * 
     * @return the string representation of the cargo ship
     */
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
