package unit6.utilities;

import java.util.Scanner;

public class InputValidators {
    private static final String DEF_ERROR_PREFIX = "Invalid input. Please enter ";

    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean getYesNoInput(Scanner scanner, String prompt) {
        String input = getInput(scanner, prompt);
        while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") && !input.isEmpty()) {
            System.out.println(DEF_ERROR_PREFIX + "'yes' or 'no':");
            input = getInput(scanner, prompt);
        }
        return input.equalsIgnoreCase("yes");
    }

    public static boolean convertYesNoToBoolean(String input) {
        return input.equalsIgnoreCase("yes");
    }

    public static String convertBooleanToString(boolean input, String trueString, String falseString) {
        return input ? trueString : falseString;
    }

    public static String convertBooleanToString(boolean input) {
        return convertBooleanToString(input, "yes", "no");
    }

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

    public static String getEditInput(Scanner scanner, String preString, String prompt, String postString) {
        return getInput(scanner, preString + prompt + postString);
    }

    public static String getEditInput(Scanner scanner, String prompt) {
        return getEditInput(scanner, "New ", prompt, " (leave blank to keep current): ");
    }

    public static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!isValidString(input) && !input.isEmpty()) {
            System.out.println(DEF_ERROR_PREFIX + "a valid string:");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    // Helper method to get validated integer input
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