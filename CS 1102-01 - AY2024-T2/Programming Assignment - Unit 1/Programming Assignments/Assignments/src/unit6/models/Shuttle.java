package unit6.models;

import unit6.interfaces.ShuttleSpacecraft;
import unit6.utilities.FormatUtils;

public class Shuttle implements ShuttleSpacecraft {
    private String name;
    private String model;
    private String engineType;
    private int crewCapacity;
    private String missionType;

    // Default constructor
    public Shuttle() {
    }

    // Constructor with all fields
    public Shuttle(String name, String model, String engineType, int crewCapacity, String missionType) {
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.crewCapacity = crewCapacity;
        this.missionType = missionType;
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
    public int getCrewCapacity() {
        return crewCapacity;
    }

    @Override
    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    @Override
    public String getMissionType() {
        return missionType;
    }

    @Override
    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    // toString method for displaying shuttle information
    @Override
    public String toString() {
        return "Shuttle:\n" +
                "  +-------------------------+\n" +
                "  | Name: " + FormatUtils.padRight(name, 18) + "|\n" +
                "  | Model: " + FormatUtils.padRight(model, 18) + "|\n" +
                "  | Engine Type: " + FormatUtils.padRight(engineType, 18) + "|\n" +
                "  | Crew Capacity: " + FormatUtils.padRight(String.valueOf(crewCapacity), 18) + "|\n" +
                "  | Mission Type: " + FormatUtils.padRight(missionType, 18) + "|\n" +
                "  +-------------------------+";
    }

}
