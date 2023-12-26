package unit6;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.interfaces.Spacecraft;
import unit6.models.CargoShip;
import unit6.utilities.FormatUtils;
import unit6.utilities.SampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Spacecraft> spacecrafts = new ArrayList<>();

    public static void main(String[] args) {
        System.err.println(FormatUtils.hr());
        System.out.println(FormatUtils.centerString("Intergalactic Voyages: Simon's Starship Bazaar"));
        System.out.println(FormatUtils.centerString("Zooming Through the Cosmos at Warp Speed!"));
        System.out.println(FormatUtils.centerString("Where Space Oddities Become Your Reality"));
        System.out.println(FormatUtils.centerString("* All sales are final. No refunds or exchanges *"));
        System.err.println(FormatUtils.hr());

        // Load sample data
        spacecrafts.addAll(SampleData.getAllSamples());

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
                    // deleteSpacecraft(); // Method to be implemented
                    break;
                case "4":
                    listAllSpacecrafts();
                    break;
                case "E":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you for using Simon's Spaceship Rental Emporium!");
        System.out.println("We hope to see you again soon!");
    }

    private static void editSpacecraft() {
        System.out.println();
        System.out.println(FormatUtils.hr("=", " Edit Spacecraft "));

        if (spacecrafts.isEmpty()) {
            System.out.println("No spacecrafts to edit.");
            return;
        }

        System.out.println("Select a spacecraft to edit:");
        for (int i = 0; i < spacecrafts.size(); i++) {
            System.out.println((i + 1) + ". " + spacecrafts.get(i).getName());
        }
        System.out.println("B. Back to Main Menu");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("B")) {
            return;
        }

        int index = Integer.parseInt(choice) - 1;
        if (index < 0 || index >= spacecrafts.size()) {
            System.out.println("Invalid option. Please try again.");
            return;
        }

        Spacecraft spacecraft = spacecrafts.get(index);
        if (spacecraft instanceof Starfighter) {
            ((Starfighter) spacecraft).editStarfighterFromInput(scanner);
        } else if (spacecraft instanceof Shuttle) {
            ((Shuttle) spacecraft).editShuttleFromInput(scanner);
        } else if (spacecraft instanceof CargoShip) {
            ((CargoShip) spacecraft).editCargoShipFromInput(scanner);
        }
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println(FormatUtils.hr("=", " Main Menu "));
        System.out.println("1. Add Spacecraft");
        System.out.println("2. Edit Spacecraft");
        System.out.println("3. Delete Spacecraft");
        System.out.println("4. List All Spacecrafts");
        System.out.println("E. Exit");
        System.out.print("Enter your choice: ");
    }

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
