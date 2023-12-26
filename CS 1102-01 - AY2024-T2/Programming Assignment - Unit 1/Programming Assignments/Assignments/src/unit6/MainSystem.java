package unit6;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.models.CargoShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Starfighter> starfighters = new ArrayList<>();
    private static final List<Shuttle> shuttles = new ArrayList<>();
    private static final List<CargoShip> cargoShips = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Simon's Spaceship Rental Emporium...");
        System.out.println("Explore the stars in your very own spacecraft!");

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
        System.out.println("Starfighters:");
        starfighters.forEach(System.out::println);
        System.out.println("Shuttles:");
        shuttles.forEach(System.out::println);
        System.out.println("Cargo Ships:");
        cargoShips.forEach(System.out::println);
    }
}
