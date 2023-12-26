package unit6;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.interfaces.Spacecraft;
import unit6.models.CargoShip;
import unit6.utilities.SampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Spacecraft> spacecrafts = new ArrayList<>();

    public static void main(String[] args) {
        System.err.println("----------------------------------------------------");
        System.out.println("|   Welcome to Simon's Spaceship Rental Emporium   |");
        System.out.println("|  Explore the stars in your very own spacecraft!  |");
        System.err.println("----------------------------------------------------");

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
                    // editSpacecraft(); // Method to be implemented
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

    private static void displayMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("1. Add Spacecraft");
        System.out.println("2. Edit Spacecraft");
        System.out.println("3. Delete Spacecraft");
        System.out.println("4. List All Spacecrafts");
        System.out.println("E. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addSpacecraft() {
        // Implementation to add a spacecraft
    }

    private static void listAllSpacecrafts() {
        System.out.println("\n=== List of All Spacecrafts ===");

        boolean hasStarfighters = false, hasShuttles = false, hasCargoShips = false;
        StringBuilder starfightersList = new StringBuilder();
        StringBuilder shuttlesList = new StringBuilder();
        StringBuilder cargoShipsList = new StringBuilder();

        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft instanceof Starfighter) {
                hasStarfighters = true;
                starfightersList.append(spacecraft.toString()).append("\n");
            } else if (spacecraft instanceof Shuttle) {
                hasShuttles = true;
                shuttlesList.append(spacecraft.toString()).append("\n");
            } else if (spacecraft instanceof CargoShip) {
                hasCargoShips = true;
                cargoShipsList.append(spacecraft.toString()).append("\n");
            }
        }

        System.out.println("Starfighters:\n"
                + (hasStarfighters ? starfightersList.toString() : "Out of Stock"));
        System.out.println("Shuttles:\n"
                + (hasShuttles ? shuttlesList.toString() : "Out of Stock"));
        System.out.println("Cargo Ships:\n"
                + (hasCargoShips ? cargoShipsList.toString() : "Out of Stock"));
    }

}
