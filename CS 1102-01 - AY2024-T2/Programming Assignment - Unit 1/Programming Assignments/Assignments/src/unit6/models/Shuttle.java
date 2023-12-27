// models/Shuttle.java
package unit6.models;

import java.util.Scanner;

import unit6.interfaces.ShuttleSpacecraft;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

/**
 * Class for a shuttle
 */
public class Shuttle extends BaseSpacecraft implements ShuttleSpacecraft {
    private int crewCapacity;
    private String missionType;

    /**
     * Default constructor
     */
    public Shuttle() {
    }

    /**
     * Constructor with all fields
     * 
     * @param name                the name of the shuttle
     * @param model               the model of the shuttle
     * @param engineType          the type of engine used by the shuttle
     * @param isRentable          the rentable status of the shuttle
     * @param rentalCostPerParsec the rental cost per parsec of the shuttle
     * @param crewCapacity        the crew capacity of the shuttle
     * @param missionType         the mission type of the shuttle
     */
    public Shuttle(String name, String model, String engineType, boolean isRentable, double rentalCostPerParsec,
            int crewCapacity, String missionType) {
        super(name, model, engineType, isRentable, rentalCostPerParsec);
        this.crewCapacity = crewCapacity;
        this.missionType = missionType;
    }

    /**
     * Function to get the type name of the shuttle
     * 
     * @return the type name of the shuttle
     */
    public String getTypeName() {
        return "Shuttle";
    }

    /**
     * Function to create a new Shuttle object based on user input
     * 
     * @param scanner the scanner to use for user input
     * @return the created shuttle
     */
    public static Shuttle createShuttleFromInput(Scanner scanner) {
        System.out.println(FormatUtils.hr("=", " Enter Shuttle details "));

        Shuttle shuttle = (Shuttle) BaseSpacecraft.createBaseSpacecraftFromInput(scanner, new Shuttle());
        shuttle.crewCapacity = InputValidators.getIntInput(scanner, "Crew Capacity: ");
        shuttle.missionType = InputValidators.getInput(scanner, "Mission Type: ");
        return shuttle;
    }

    /**
     * Function to edit an existing Shuttle object based on user input
     * 
     * @param scanner the scanner to use for user input
     */
    public void editFromInput(Scanner scanner) {
        System.out.println(FormatUtils.hr("=", " Edit Shuttle details "));

        super.editBaseSpacecraftFromInput(scanner);

        String crewCapacityStr = InputValidators.getEditInput(scanner, "Crew Capacity");
        if (!crewCapacityStr.isEmpty() && InputValidators.isValidInteger(crewCapacityStr)) {
            this.crewCapacity = Integer.parseInt(crewCapacityStr);
        }

        String missionType = InputValidators.getEditInput(scanner, "Mission Type");
        if (!missionType.isEmpty()) {
            this.missionType = missionType;
        }
    }

    /**
     * Method to get the crew capacity of the shuttle
     * 
     * @return the crew capacity of the shuttle
     */
    @Override
    public int getCrewCapacity() {
        return crewCapacity;
    }

    /**
     * Method to set the crew capacity of the shuttle
     * 
     * @param crewCapacity the crew capacity of the shuttle
     */
    @Override
    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    /**
     * Method to get the mission type for the shuttle
     * 
     * @return the mission type for the shuttle
     */
    @Override
    public String getMissionType() {
        return missionType;
    }

    /**
     * Method to set the mission type for the shuttle
     * 
     * @param missionType the mission type for the shuttle
     */
    @Override
    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    /**
     * Function to get the string representation of the shuttle
     * 
     * @return the string representation of the shuttle
     */
    @Override
    public String toString() {
        return FormatUtils.hr("Shuttle") + "\n" +
                super.toString() +
                FormatUtils.padString("| Crew Capacity: ", crewCapacity + " |\n") +
                FormatUtils.padString("| Mission Type: ", missionType + " |\n") +
                FormatUtils.hr() + "\n";
    }

}
