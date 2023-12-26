package unit6.interfaces;

public interface ShuttleSpacecraft extends Spacecraft {

    // Method to get the crew capacity of the shuttle
    int getCrewCapacity();

    // Method to set the crew capacity of the shuttle
    void setCrewCapacity(int crewCapacity);

    // Method to get the type of missions the shuttle is designed for (e.g.,
    // exploration, transport)
    String getMissionType();

    // Method to set the mission type for the shuttle
    void setMissionType(String missionType);
}
