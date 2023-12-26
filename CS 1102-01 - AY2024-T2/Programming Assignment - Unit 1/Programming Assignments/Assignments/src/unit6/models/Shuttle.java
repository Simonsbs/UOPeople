package unit6.models;

import unit6.interfaces.ShuttleSpacecraft;

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
        return "Shuttle{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", crewCapacity=" + crewCapacity +
                ", missionType='" + missionType + '\'' +
                '}';
    }
}
