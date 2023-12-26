package unit6.interfaces;

/**
 * Interface for a starfighter spacecraft
 */
public interface StarfighterSpacecraft extends Spacecraft {
    /**
     * Method to get the weapon system of the starfighter
     * 
     * @return the weapon system of the starfighter
     */
    String getWeaponSystem();

    /**
     * Method to set the weapon system of the starfighter
     * 
     * @param weaponSystem the weapon system of the starfighter
     */
    void setWeaponSystem(String weaponSystem);

    /**
     * Method to get the hyperdrive capability of the starfighter
     * 
     * @return the hyperdrive capability of the starfighter
     */
    boolean hasHyperdriveCapability();

    /**
     * Method to set the hyperdrive capability of the starfighter
     * 
     * @param hyperdriveCapability the hyperdrive capability of the starfighter
     */
    void setHyperdriveCapability(boolean hyperdriveCapability);
}
