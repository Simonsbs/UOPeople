package unit6.utilities;

import java.util.Scanner;

/**
 * Class for input validators
 */
public class InputValidators {
    private static final String DEF_ERROR_PREFIX = "Invalid input. Please enter ";

    /**
     * Function to check if a string is valid
     * 
     * @param input the string to check
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValidString(String input) {
        return input != null && !input.isEmpty() && !input.trim().isEmpty();
    }

    /**
     * Function to check if an integer is valid
     * 
     * @param input the integer to check
     * @return true if the integer is valid, false otherwise
     */
    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Function to check if a double is valid
     * 
     * @param input the double to check
     * @return true if the double is valid, false otherwise
     */
    public static boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Function to get a yes/no input from the user
     * 
     * @param scanner the scanner to use for user input
     * @param prompt  the prompt to display to the user
     * @return true if the user input is yes, false otherwise
     */
    public static boolean getYesNoInput(Scanner scanner, String prompt) {
        String input = getInput(scanner, prompt);
        while (!isValidYesNoResponse(input) && !input.isEmpty()) {
            System.out.println(DEF_ERROR_PREFIX + "(y)es/(n)o:");
            input = getInput(scanner, prompt);
        }
        return input.equalsIgnoreCase("yes") || input.toLowerCase().startsWith("y");
    }

    /**
     * Function to get a yes/no input from the user
     * 
     * @param scanner the scanner to use for user input
     * @return true if the user input is yes, false otherwise
     */
    public static boolean isValidYesNoResponse(String input) {
        return input.equalsIgnoreCase("yes") ||
                input.equalsIgnoreCase("no") ||
                input.equalsIgnoreCase("y") ||
                input.equalsIgnoreCase("n");
    }

    /**
     * Function to convert a yes/no string to a boolean
     * 
     * @param input the string to convert
     * @return true if the string is yes, false otherwise
     */
    public static boolean convertYesNoToBoolean(String input) {
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }

    /**
     * Function to convert a boolean to a yes/no string
     * 
     * @param input the boolean to convert
     * @return "yes" if the boolean is true, "no" otherwise
     */
    public static String convertBooleanToString(boolean input, String trueString, String falseString) {
        return input ? trueString : falseString;
    }

    /**
     * Function to convert a boolean to a yes/no string
     * 
     * @param input the boolean to convert
     * @return "yes" if the boolean is true, "no" otherwise
     */
    public static String convertBooleanToString(boolean input) {
        return convertBooleanToString(input, "yes", "no");
    }

    /**
     * Function to get a double input from the user
     * 
     * @param scanner the scanner to use for user input
     * @param prompt  the prompt to display to the user
     * @return the double input from the user
     */
    public static double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!isValidDouble(input) && !input.isEmpty()) {
            System.out.println(DEF_ERROR_PREFIX + "a valid number:");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input.isEmpty() ? 0.0 : Double.parseDouble(input);
    }

    /**
     * Function to get a double input from the user
     * 
     * @param scanner the scanner to use for user input
     * @param prompt  the prompt to display to the user
     * @return the double input from the user
     */
    public static String getEditInput(Scanner scanner, String preString, String prompt, String postString) {
        return getInput(scanner, preString + prompt + postString);
    }

    /**
     * Function to get a double input from the user
     * 
     * @param scanner the scanner to use for user input
     * @param prompt  the prompt to display to the user
     * @return the double input from the user
     */
    public static String getEditInput(Scanner scanner, String prompt) {
        return getEditInput(scanner, "New ", prompt, " (leave blank to keep current): ");
    }

    /**
     * Function to get a string input from the user
     * 
     * @param scanner the scanner to use for user input
     * @param prompt  the prompt to display to the user
     * @return the string input from the user
     */
    public static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!isValidString(input)) {
            System.out.println(DEF_ERROR_PREFIX + "a valid string:");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    /**
     * Function to get an integer input from the user
     * 
     * @param scanner the scanner to use for user input
     * @param prompt  the prompt to display to the user
     * @return the integer input from the user
     */
    public static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!isValidInteger(input) && !input.isEmpty()) {
            System.out.println(DEF_ERROR_PREFIX + "a valid integer:");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input.isEmpty() ? 0 : Integer.parseInt(input);
    }
}