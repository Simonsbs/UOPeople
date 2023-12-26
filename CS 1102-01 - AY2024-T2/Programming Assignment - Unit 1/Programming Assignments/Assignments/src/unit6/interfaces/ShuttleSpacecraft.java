package unit6.interfaces;

/**
 * Interface for a shuttle spacecraft
 */
public interface ShuttleSpacecraft extends Spacecraft {

    /**
     * Method to get the crew capacity of the shuttle
     * 
     * @return the crew capacity of the shuttle
     */
    int getCrewCapacity();

    /**
     * Method to set the crew capacity of the shuttle
     * 
     * @param crewCapacity the crew capacity of the shuttle
     */
    void setCrewCapacity(int crewCapacity);

    /**
     * Method to get the mission type for the shuttle
     * 
     * @return the mission type for the shuttle
     */
    String getMissionType();

    /**
     * Method to set the mission type for the shuttle
     * 
     * @param missionType the mission type for the shuttle
     */
    void setMissionType(String missionType);
}
