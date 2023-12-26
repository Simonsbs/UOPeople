package unit6;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.interfaces.Spacecraft;
import unit6.models.CargoShip;
import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;
import unit6.utilities.SampleData;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the program
 */
public class MainSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Spacecraft> spacecrafts = new ArrayList<>();

    /**
     * Main entry function for the program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.err.println(FormatUtils.hr());
        System.out.println(FormatUtils.centerString("Intergalactic Voyages: Simon's Starship Bazaar"));
        System.out.println(FormatUtils.centerString("Zooming Through the Cosmos at Warp Speed!"));
        System.out.println(FormatUtils.centerString("Where Space Oddities Become Your Reality"));
        System.out.println(FormatUtils.centerString("* All sales are final. No refunds or exchanges *"));
        System.err.println(FormatUtils.hr());

        // Load sample data
        SampleData.getAllSamples(spacecrafts);

        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    addSpacecraft();
                    break;
                case "2":
                    editSpacecraft();
                    break;
                case "3":
                    deleteSpacecraft();
                    break;
                case "4":
                    listAllSpacecrafts();
                    break;
                case "5":
                    listAllSpacecraftsSimple();
                    break;
                case "E":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you for using Simon's Starship Bazaar!");
        System.out.println("Goodbye. Live long and prosper. NO REFUNDS.");

    }

    /**
     * Method to list all spacecrafts (simple)
     */
    private static void listAllSpacecraftsSimple() {
        System.out.println(FormatUtils.hr("=", " List of All Spacecrafts (Simple) "));

        StringBuilder list = new StringBuilder();

        for (Spacecraft spacecraft : spacecrafts) {
            list.append(spacecraft.getTypeName() + " - " + spacecraft.getName() + "\n");
        }

        System.out.println(list.toString());
    }

    /**
     * Method to select a spacecraft from the list
     * 
     * @param actionTitle the title of the action to perform
     * @return the selected spacecraft
     */
    private static Spacecraft selectSpacecraft(String actionTitle) {
        System.out.println();
        System.out.println(FormatUtils.hr("=", " " + actionTitle + " "));

        if (spacecrafts.isEmpty()) {
            System.out.println("No spacecrafts available.");
            return null;
        }

        System.out.println("Select a spacecraft to " + actionTitle.toLowerCase() + ":");
        for (int i = 0; i < spacecrafts.size(); i++) {
            System.out.println((i + 1) + ". " + spacecrafts.get(i).getName());
        }
        System.out.println("B. Back to Main Menu");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("B")) {
            return null;
        }

        int index;
        try {
            index = Integer.parseInt(choice) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Please try again.");
            return null;
        }

        if (index < 0 || index >= spacecrafts.size()) {
            System.out.println("Invalid option. Please try again.");
            return null;
        }

        return spacecrafts.get(index);
    }

    /**
     * Method to delete a spacecraft
     */
    private static void deleteSpacecraft() {
        Spacecraft spacecraft = selectSpacecraft("Delete");
        if (spacecraft != null) {
            String type = spacecraft.getTypeName();
            System.out
                    .println("Are you sure you want to delete the " + type + " '"
                            + spacecraft.getName() + "'? (yes/no)");
            if (InputValidators.getYesNoInput(scanner, "")) {
                spacecrafts.remove(spacecraft);
                System.out.println(type + " deleted successfully!");
            } else {
                System.out.println(type + " deletion aborted.");
            }
        }
    }

    /**
     * Method to edit a spacecraft
     */
    private static void editSpacecraft() {
        Spacecraft spacecraft = selectSpacecraft("Edit");
        if (spacecraft != null) {
            spacecraft.editFromInput(scanner);
        }
    }

    /**
     * Method to display the main menu
     */
    private static void displayMenu() {
        System.out.println();
        System.out.println(FormatUtils.hr("=", " Main Menu "));
        System.out.println("1. Add Spacecraft");
        System.out.println("2. Edit Spacecraft");
        System.out.println("3. Delete Spacecraft");
        System.out.println("4. List All Spacecrafts (Detailed)");
        System.out.println("5. List All Spacecrafts (Simple)");
        System.out.println("E. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Method to add a spacecraft
     */
    private static void addSpacecraft() {
        System.out.println();
        System.out.println(FormatUtils.hr("=", " Select type to add "));
        System.out.println("1. Starfighter");
        System.out.println("2. Shuttle");
        System.out.println("3. Cargo Ship");
        System.out.println("B. Back to Main Menu");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().toUpperCase();

        Spacecraft spacecraft = null;
        switch (choice) {
            case "1":
                spacecraft = Starfighter.createStarfighterFromInput(scanner);
                break;
            case "2":
                spacecraft = Shuttle.createShuttleFromInput(scanner);
                break;
            case "3":
                spacecraft = CargoShip.createCargoShipFromInput(scanner);
                break;
            case "E":
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        if (spacecraft != null) {
            spacecrafts.add(spacecraft);
            System.out.println("Spacecraft added successfully!");
        }
    }

    /**
     * Method to list all spacecrafts
     */
    private static void listAllSpacecrafts() {
        System.out.println(FormatUtils.hr("=", " List of All Spacecrafts "));
        System.out.println();

        boolean hasStarfighters = false, hasShuttles = false, hasCargoShips = false;
        StringBuilder starfightersList = new StringBuilder();
        StringBuilder shuttlesList = new StringBuilder();
        StringBuilder cargoShipsList = new StringBuilder();

        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft instanceof Starfighter) {
                hasStarfighters = true;
                starfightersList.append(spacecraft.toString());
            } else if (spacecraft instanceof Shuttle) {
                hasShuttles = true;
                shuttlesList.append(spacecraft.toString());
            } else if (spacecraft instanceof CargoShip) {
                hasCargoShips = true;
                cargoShipsList.append(spacecraft.toString());
            }
        }

        System.out.println(FormatUtils.hr("=", " Starfighters "));
        System.out.println();
        System.out.println(hasStarfighters ? starfightersList.toString() : "Out of Stock");
        System.out.println(FormatUtils.hr("=", " Shuttles "));
        System.out.println();
        System.out.println(hasShuttles ? shuttlesList.toString() : "Out of Stock");
        System.out.println(FormatUtils.hr("=", " Cargo Ships "));
        System.out.println();
        System.out.println(hasCargoShips ? cargoShipsList.toString() : "Out of Stock");
    }
}