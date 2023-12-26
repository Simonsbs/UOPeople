package unit6.models;

import java.util.Scanner;

import unit6.interfaces.StarfighterSpacecraft;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

/**
 * Class for a starfighter
 */
public class Starfighter extends BaseSpacecraft implements StarfighterSpacecraft {
    private String weaponSystem;
    private boolean hyperdriveCapability;

    /**
     * Default constructor
     */
    public Starfighter() {
    }

    /**
     * Constructor with all fields
     * 
     * @param name                 the name of the starfighter
     * @param model                the model of the starfighter
     * @param engineType           the type of engine used by the starfighter
     * @param isRentable           the rentable status of the starfighter
     * @param rentalCostPerParsec  the rental cost per parsec of the starfighter
     * @param weaponSystem         the weapon system of the starfighter
     * @param hyperdriveCapability the hyperdrive capability of the starfighter
     */
    public Starfighter(String name, String model, String engineType, boolean isRentable, double rentalCostPerParsec,
            String weaponSystem,
            boolean hyperdriveCapability) {
        super(name, model, engineType, isRentable, rentalCostPerParsec);
        this.weaponSystem = weaponSystem;
        this.hyperdriveCapability = hyperdriveCapability;
    }

    /**
     * Function to get the type name of the starfighter
     * 
     * @return the type name of the starfighter
     */
    public String getTypeName() {
        return "Starfighter";
    }

    /**
     * Function to create a new Starfighter object based on user input
     * 
     * @param scanner the scanner to use for user input
     * @return the created starfighter
     */
    public static Starfighter createStarfighterFromInput(Scanner scanner) {
        System.out.println("Enter Starfighter details:");

        Starfighter starfighter = (Starfighter) BaseSpacecraft.createBaseSpacecraftFromInput(scanner,
                new Starfighter());

        starfighter.weaponSystem = InputValidators.getInput(scanner, "Weapon System: ");
        starfighter.hyperdriveCapability = InputValidators.getYesNoInput(scanner, "Hyperdrive Capability (yes/no): ");

        return starfighter;
    }

    /**
     * Function to edit an existing Starfighter object based on user input
     * 
     * @param scanner the scanner to use for user input
     */
    public void editFromInput(Scanner scanner) {
        System.out.println("Editing Starfighter details:");

        super.editBaseSpacecraftFromInput(scanner);

        String weaponSystem = InputValidators.getEditInput(scanner, "Weapon System");
        if (!weaponSystem.isEmpty()) {
            setWeaponSystem(weaponSystem);
        }

        String hyperdriveCapabilityStr = InputValidators.getEditInput(scanner,
                "Hyperdrive Capability yes/no");
        if (!hyperdriveCapabilityStr.isEmpty()) {
            setHyperdriveCapability(InputValidators.convertYesNoToBoolean(hyperdriveCapabilityStr));
        }
    }

    /**
     * Method to get the weapon system of the starfighter
     * 
     * @return the weapon system of the starfighter
     */
    @Override
    public String getWeaponSystem() {
        return weaponSystem;
    }

    /**
     * Method to set the weapon system of the starfighter
     * 
     * @param weaponSystem the weapon system of the starfighter
     */
    @Override
    public void setWeaponSystem(String weaponSystem) {
        this.weaponSystem = weaponSystem;
    }

    /**
     * Method to get the hyperdrive capability of the starfighter
     * 
     * @return the hyperdrive capability of the starfighter
     */
    @Override
    public boolean hasHyperdriveCapability() {
        return hyperdriveCapability;
    }

    /**
     * Method to set the hyperdrive capability of the starfighter
     * 
     * @param hyperdriveCapability the hyperdrive capability of the starfighter
     */
    @Override
    public void setHyperdriveCapability(boolean hyperdriveCapability) {
        this.hyperdriveCapability = hyperdriveCapability;
    }

    /**
     * Method to get the details of the starfighter
     * 
     * @return the details of the starfighter
     */
    @Override
    public String toString() {
        String hyperdriveStatus = hyperdriveCapability ? "Yes" : "No";
        return FormatUtils.hr("Starfighter") + "\n" +
                super.toString() +
                FormatUtils.padString("| Weapon System: ", weaponSystem + " |\n") +
                FormatUtils.padString("| Hyperdrive: ", hyperdriveStatus + " |\n") +
                FormatUtils.hr() + "\n";
    }

}
