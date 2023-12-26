package unit6.models;

import java.util.Scanner;

import unit6.interfaces.ShuttleSpacecraft;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

public class Shuttle extends BaseSpacecraft implements ShuttleSpacecraft {
    private int crewCapacity;
    private String missionType;

    // Default constructor
    public Shuttle() {
    }

    // Constructor with all fields
    public Shuttle(String name, String model, String engineType, boolean isRentable, double rentalCostPerParsec,
            int crewCapacity, String missionType) {
        super(name, model, engineType, isRentable, rentalCostPerParsec);
        this.crewCapacity = crewCapacity;
        this.missionType = missionType;
    }

    public static Shuttle createShuttleFromInput(Scanner scanner) {
        System.out.println("Enter Shuttle details:");

        Shuttle shuttle = (Shuttle) BaseSpacecraft.createBaseSpacecraftFromInput(scanner, new Shuttle());
        shuttle.crewCapacity = InputValidators.getIntInput(scanner, "Crew Capacity: ");
        shuttle.missionType = InputValidators.getInput(scanner, "Mission Type: ");
        return shuttle;
    }

    // Function to edit an existing Shuttle object based on user input
    public void editFromInput(Scanner scanner) {
        System.out.println("Editing Shuttle details:");

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

    @Override
    public int getCrewCapacity() {
        return crewCapacity;
    }

    @Override
    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    @Override
    public String getMissionType() {
        return missionType;
    }

    @Override
    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    // toString method for displaying shuttle information
    @Override
    public String toString() {
        return FormatUtils.hr("Shuttle") + "\n" +
                super.toString() +
                FormatUtils.padString("| Crew Capacity: ", crewCapacity + " |\n") +
                FormatUtils.padString("| Mission Type: ", missionType + " |\n") +
                FormatUtils.hr() + "\n";
    }

}
