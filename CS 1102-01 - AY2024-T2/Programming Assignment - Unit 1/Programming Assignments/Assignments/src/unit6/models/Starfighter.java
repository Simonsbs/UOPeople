package unit6.models;

import unit6.interfaces.StarfighterSpacecraft;

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
        return "Starfighter{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", weaponSystem='" + weaponSystem + '\'' +
                ", hyperdriveCapability=" + hyperdriveCapability +
                '}';
    }
}
