package unit6.models;

import java.util.Scanner;

import unit6.utilities.FormatUtils;
import unit6.utilities.InputValidators;

public abstract class BaseSpacecraft {
    protected String name;
    protected String model;
    protected String engineType;

    // Constructors
    public BaseSpacecraft() {
    }

    public BaseSpacecraft(String name, String model, String engineType) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
    }

    // Generic function to create a BaseSpacecraft object based on user input
    protected static BaseSpacecraft createBaseSpacecraftFromInput(Scanner scanner, BaseSpacecraft spacecraft) {
        spacecraft.name = InputValidators.getInput(scanner, "Name: ");
        spacecraft.model = InputValidators.getInput(scanner, "Model: ");
        spacecraft.engineType = InputValidators.getInput(scanner, "Engine Type: ");
        return spacecraft;
    }

    // Generic function to edit an existing BaseSpacecraft object based on user
    // input
    protected void editBaseSpacecraftFromInput(Scanner scanner) {
        String name = InputValidators.getInput(scanner, "New Name (leave blank to keep current): ");
        if (!name.isEmpty()) {
            this.name = name;
        }

        String model = InputValidators.getInput(scanner, "New Model (leave blank to keep current): ");
        if (!model.isEmpty()) {
            this.model = model;
        }

        String engineType = InputValidators.getInput(scanner, "New Engine Type (leave blank to keep current): ");
        if (!engineType.isEmpty()) {
            this.engineType = engineType;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    // Common toString functionality
    protected String getBaseToString() {
        return "  | Name: " + FormatUtils.padRight(name, 15) + "|\n" +
                "  | Model: " + FormatUtils.padRight(model, 15) + "|\n" +
                "  | Engine Type: " + FormatUtils.padRight(engineType, 15) + "|\n";
    }
}
