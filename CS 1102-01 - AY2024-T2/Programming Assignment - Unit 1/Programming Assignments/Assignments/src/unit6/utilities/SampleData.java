package unit6.utilities;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.interfaces.Spacecraft;
import unit6.models.CargoShip;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to generate sample data
 */
public class SampleData {
    /**
     * Method to generate a random double between min and max
     * 
     * @param min the minimum value
     * @param max the maximum value
     * @return a random double between min and max
     */
    private static double RandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    /**
     * Method to generate a random double between 50 and 100
     * 
     * @param max the maximum value
     * @return a random double between 50 and 100
     */
    private static int RandomDouble() {
        return (int) RandomDouble(50, 100);
    }

    /**
     * Method builds and returns a list of all sample spacecrafts
     * 
     * @return a list of all sample spacecrafts
     */
    public static void getAllSamples(List<Spacecraft> list) {
        list.add(new Starfighter("X-Wing", "T-65", "Incom 4L4 Fusial Thrust Engine", true, RandomDouble(),
                "Laser Cannons", true));
        list.add(new Starfighter("TIE Fighter", "Twin Ion Engine LN Starfighter", "Sienar Fleet Systems", true,
                RandomDouble(),
                "Laser Cannons",
                false));
        list.add(new Starfighter("A-Wing", "RZ-1", "Alliance Underground Engineering", true, RandomDouble(),
                "Laser Cannons",
                true));
        list.add(new Shuttle("Galaxy Class", "NCC-1701-D", "Warp Drive", true, RandomDouble(), 1014,
                "Exploration and Diplomacy"));
        list.add(new Shuttle("Imperial Shuttle", "Lambda-class T-4a", "Cygnus Spaceworks", true, RandomDouble(), 20,
                "Troop Transport"));
        list.add(new Shuttle("Runabout", "Danube Class", "Warp Drive", true, RandomDouble(), 40,
                "Short-range Missions"));
        list.add(new CargoShip("Nostromo", "Lockmart CM-88B Bison M-Class Starfreighter",
                "Rolls-Royce N66 Cyclone Thrust Tunnels", true, RandomDouble(), 20000, true));
        list.add(new CargoShip("Sulaco", "Conestoga-class Troop Transport", "Westingland A24", true, RandomDouble(),
                50000, true));
        list.add(new CargoShip("Valley Forge", "American Airlines Space Freighter", "General Electric CF6-50", true,
                RandomDouble(), 100000,
                false));
    }
}
