package unit6.utilities;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.models.CargoShip;

public class SampleData {

    // Method to provide a sample Starfighter
    public static Starfighter getSampleStarfighter() {
        Starfighter starfighter = new Starfighter();
        starfighter.setName("X-Wing");
        starfighter.setModel("T-65");
        starfighter.setEngineType("Incom 4L4 Fusial Thrust Engine");
        starfighter.setWeaponSystem("Laser Cannons");
        starfighter.setHyperdriveCapability(true);
        return starfighter;
    }

    // Method to provide a sample Shuttle
    public static Shuttle getSampleShuttle() {
        Shuttle shuttle = new Shuttle();
        shuttle.setName("Galaxy Class");
        shuttle.setModel("NCC-1701-D");
        shuttle.setEngineType("Warp Drive");
        shuttle.setCrewCapacity(1014);
        shuttle.setMissionType("Exploration and Diplomacy");
        return shuttle;
    }

    // Method to provide a sample CargoShip
    public static CargoShip getSampleCargoShip() {
        CargoShip cargoShip = new CargoShip();
        cargoShip.setName("Nostromo");
        cargoShip.setModel("Lockmart CM-88B Bison M-Class Starfreighter");
        cargoShip.setEngineType("Rolls-Royce N66 Cyclone Thrust Tunnels");
        cargoShip.setCargoCapacity(20000); // in metric tons
        cargoShip.setSpecializedCargoHandling(true);
        return cargoShip;
    }
}
