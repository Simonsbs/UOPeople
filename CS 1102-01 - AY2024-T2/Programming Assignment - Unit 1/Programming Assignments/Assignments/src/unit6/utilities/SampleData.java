package unit6.utilities;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.interfaces.Spacecraft;
import unit6.models.CargoShip;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    // Sample Starfighters
    public static Starfighter getSampleStarfighter1() {
        return new Starfighter("X-Wing", "T-65", "Incom 4L4 Fusial Thrust Engine", "Laser Cannons", true);
    }

    public static Starfighter getSampleStarfighter2() {
        return new Starfighter("TIE Fighter", "Twin Ion Engine LN Starfighter", "Sienar Fleet Systems", "Laser Cannons",
                false);
    }

    public static Starfighter getSampleStarfighter3() {
        return new Starfighter("A-Wing", "RZ-1", "Alliance Underground Engineering", "Laser Cannons", true);
    }

    // Sample Shuttles
    public static Shuttle getSampleShuttle1() {
        return new Shuttle("Galaxy Class", "NCC-1701-D", "Warp Drive", 1014, "Exploration and Diplomacy");
    }

    public static Shuttle getSampleShuttle2() {
        return new Shuttle("Imperial Shuttle", "Lambda-class T-4a", "Cygnus Spaceworks", 20, "Troop Transport");
    }

    public static Shuttle getSampleShuttle3() {
        return new Shuttle("Runabout", "Danube Class", "Warp Drive", 40, "Short-range Missions");
    }

    // Sample Cargo Ships
    public static CargoShip getSampleCargoShip1() {
        return new CargoShip("Nostromo", "Lockmart CM-88B Bison M-Class Starfreighter",
                "Rolls-Royce N66 Cyclone Thrust Tunnels", 20000, true);
    }

    public static CargoShip getSampleCargoShip2() {
        return new CargoShip("Sulaco", "Conestoga-class Troop Transport", "Westingland A24", 50000, true);
    }

    public static CargoShip getSampleCargoShip3() {
        return new CargoShip("Valley Forge", "American Airlines Space Freighter", "General Electric CF6-50", 100000,
                false);
    }

    // Method to compile and return all samples
    public static List<Spacecraft> getAllSamples() {
        List<Spacecraft> allSamples = new ArrayList<>();
        allSamples.add(getSampleStarfighter1());
        allSamples.add(getSampleStarfighter2());
        allSamples.add(getSampleStarfighter3());
        allSamples.add(getSampleShuttle1());
        allSamples.add(getSampleShuttle2());
        allSamples.add(getSampleShuttle3());
        allSamples.add(getSampleCargoShip1());
        allSamples.add(getSampleCargoShip2());
        allSamples.add(getSampleCargoShip3());
        return allSamples;
    }
}
