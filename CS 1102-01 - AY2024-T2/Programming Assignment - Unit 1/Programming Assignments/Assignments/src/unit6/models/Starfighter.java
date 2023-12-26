package unit6.models;

import unit6.interfaces.StarfighterSpacecraft;
import unit6.utilities.FormatUtils;

public class Starfighter implements StarfighterSpacecraft {
    private String name;
    private String model;
    private String engineType;
    private String weaponSystem;
    private boolean hyperdriveCapability;

    // Default constructor
    public Starfighter() {
    }

    // Constructor with all fields
    public Starfighter(String name, String model, String engineType, String weaponSystem,
            boolean hyperdriveCapability) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.weaponSystem = weaponSystem;
        this.hyperdriveCapability = hyperdriveCapability;
    }

    // Implement all interface methods
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getEngineType() {
        return engineType;
    }

    @Override
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String getWeaponSystem() {
        return weaponSystem;
    }

    @Override
    public void setWeaponSystem(String weaponSystem) {
        this.weaponSystem = weaponSystem;
    }

    @Override
    public boolean hasHyperdriveCapability() {
        return hyperdriveCapability;
    }

    @Override
    public void setHyperdriveCapability(boolean hyperdriveCapability) {
        this.hyperdriveCapability = hyperdriveCapability;
    }

    // toString method for displaying starfighter information
    @Override
    public String toString() {
        String hyperdriveStatus = hyperdriveCapability ? "Yes" : "No";
        return "Starfighter:\n" +
                "  +--------------------+\n" +
                "  | Name: " + FormatUtils.padRight(name, 15) + "|\n" +
                "  | Model: " + FormatUtils.padRight(model, 15) + "|\n" +
                "  | Engine Type: " + FormatUtils.padRight(engineType, 15) + "|\n" +
                "  | Weapon System: " + FormatUtils.padRight(weaponSystem, 15) + "|\n" +
                "  | Hyperdrive: " + FormatUtils.padRight(hyperdriveStatus, 15) + "|\n" +
                "  +--------------------+";
    }

}
