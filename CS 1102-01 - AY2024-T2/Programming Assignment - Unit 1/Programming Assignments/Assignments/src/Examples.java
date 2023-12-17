import java.util.Scanner;

public class Examples {

    private static Scanner scanner = new Scanner(System.in);

    // Method demonstrating a while loop with a Ghostbusters theme
    public static void ghostbustersWhileLoop() {
        System.out.println("----- Ghostbusters While Loop -----");
        System.out.print("Enter the number of ghosts to bust (up to 5): ");
        int maxGhosts = getIntInput(1, 5);
        int ghostCount = 1;
        while (ghostCount <= maxGhosts) {
            System.out.println("Ghost #" + ghostCount + " busted!");
            ghostCount++;
        }
    }

    // Method demonstrating a do-while loop with a number guessing game
    public static void guessTheNumberGame() {
        System.out.println("----- Guess The Number Game -----");
        int secretNumber = 7; // For simplicity, the secret number is set to 7
        int userGuess;

        do {
            System.out.print("Guess a number between 1 and 10: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number. Please enter a number between 1 and 10:");
                scanner.next(); // Clear the invalid input
            }
            userGuess = scanner.nextInt();

            if (userGuess != secretNumber) {
                System.out.println("Wrong guess. Try again!");
            }
        } while (userGuess != secretNumber);

        System.out.println("Congratulations! You guessed the correct number: " + secretNumber);
    }

    // Method demonstrating a for loop with a Jurassic Park theme
    public static void jurassicParkForLoop() {
        System.out.println("----- Jurassic Park For Loop -----");
        String[] dinosaurs = { "T-Rex", "Velociraptor", "Triceratops", "Brachiosaurus" };
        for (String dinosaur : dinosaurs) {
            System.out.println(dinosaur + " roams in Jurassic Park!");
        }
    }

    // Method demonstrating if-else statements with a Terminator theme
    public static void terminatorIfElse() {
        System.out.println("----- Terminator If-Else -----");
        System.out.print("Enter a Terminator model number (e.g., 101 or 1000): ");
        int modelNumber = getIntInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (modelNumber == 101) {
            System.out.println("I'm a Terminator T-800 Model 101.");
        } else if (modelNumber == 1000) {
            System.out.println("I'm a more advanced T-1000.");
        } else {
            System.out.println("Unknown Terminator model.");
        }
    }

    // Method demonstrating a switch statement with a Star Wars theme
    public static void starWarsSwitch() {
        System.out.println("----- Star Wars Switch -----");
        System.out.print("Enter a Star Wars character name (e.g., Luke, Vader, Yoda): ");
        String character = scanner.next();
        switch (character) {
            case "Luke":
                System.out.println("Luke Skywalker, a Jedi like his father before him.");
                break;
            case "Vader":
                System.out.println("Darth Vader, formerly known as Anakin Skywalker.");
                break;
            case "Yoda":
                System.out.println("Yoda, the Jedi Master.");
                break;
            default:
                System.out.println("May the Force be with you, unknown character.");
                break;
        }
    }

    // Helper method for getting integer input with validation
    private static int getIntInput(int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.next());
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ":");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
        return input;
    }

    public static void main(String[] args) {
        ghostbustersWhileLoop();
        guessTheNumberGame();
        jurassicParkForLoop();
        terminatorIfElse();
        starWarsSwitch();

        scanner.close();
    }
}
