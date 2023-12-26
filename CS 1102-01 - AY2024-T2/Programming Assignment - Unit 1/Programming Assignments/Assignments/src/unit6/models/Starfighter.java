package unit6.models;

import java.util.Scanner;

import unit6.interfaces.StarfighterSpacecraft;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

public class Starfighter extends BaseSpacecraft implements StarfighterSpacecraft {
    private String weaponSystem;
    private boolean hyperdriveCapability;

    // Default constructor
    public Starfighter() {
    }

    // Constructor with all fields
    public Starfighter(String name, String model, String engineType, String weaponSystem,
            boolean hyperdriveCapability) {
        super(name, model, engineType);
        this.weaponSystem = weaponSystem;
        this.hyperdriveCapability = hyperdriveCapability;
    }

    // Function to create a new Starfighter object based on user input
    public static Starfighter createStarfighterFromInput(Scanner scanner) {
        System.out.println("Enter Starfighter details:");

        Starfighter starfighter = (Starfighter) BaseSpacecraft.createBaseSpacecraftFromInput(scanner,
                new Starfighter());

        starfighter.weaponSystem = InputValidators.getInput(scanner, "Weapon System: ");
        starfighter.hyperdriveCapability = InputValidators.getYesNoInput(scanner, "Hyperdrive Capability (yes/no): ");

        return starfighter;
    }

    // Function to edit an existing Starfighter object based on user input
    public void editStarfighterFromInput(Scanner scanner) {
        System.out.println("Editing Starfighter details:");

        super.editBaseSpacecraftFromInput(scanner);

        String weaponSystem = InputValidators.getInput(scanner, "New Weapon System (leave blank to keep current): ");
        if (!weaponSystem.isEmpty()) {
            setWeaponSystem(weaponSystem);
        }

        String hyperdriveCapabilityStr = InputValidators.getInput(scanner,
                "New Hyperdrive Capability (yes/no, leave blank to keep current): ");
        if (!hyperdriveCapabilityStr.isEmpty()) {
            setHyperdriveCapability(InputValidators.convertYesNoToBoolean(hyperdriveCapabilityStr));
        }
    }

    @Override
    public String getWeaponSystem() {
        return weaponSystem;
    }

    @Override
    public void setWeaponSystem(String weaponSystem) {
        this.weaponSystem = weaponSystem;
    }

    @Override
    public boolean hasHyperdriveCapability() {
        return hyperdriveCapability;
    }

    @Override
    public void setHyperdriveCapability(boolean hyperdriveCapability) {
        this.hyperdriveCapability = hyperdriveCapability;
    }

    // toString method for displaying starfighter information
    @Override
    public String toString() {
        String hyperdriveStatus = hyperdriveCapability ? "Yes" : "No";
        return "Starfighter:\n" +
                "  +--------------------+\n" +
                "  | Name: " + FormatUtils.padRight(name, 15) + "|\n" +
                "  | Model: " + FormatUtils.padRight(model, 15) + "|\n" +
                "  | Engine Type: " + FormatUtils.padRight(engineType, 15) + "|\n" +
                "  | Weapon System: " + FormatUtils.padRight(weaponSystem, 15) + "|\n" +
                "  | Hyperdrive: " + FormatUtils.padRight(hyperdriveStatus, 15) + "|\n" +
                "  +--------------------+";
    }

}
