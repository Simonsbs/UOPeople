package unit6.utilities;

import unit6.models.Starfighter;
import unit6.models.Shuttle;
import unit6.interfaces.Spacecraft;
import unit6.models.CargoShip;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    private static double RandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    private static int RandomDouble() {
        return (int) RandomDouble(50, 100);
    }

    public static List<Spacecraft> getAllSamples() {
        List<Spacecraft> allSamples = new ArrayList<>();
        allSamples.add(new Starfighter("X-Wing", "T-65", "Incom 4L4 Fusial Thrust Engine", true, RandomDouble(),
                "Laser Cannons", true));
        allSamples.add(new Starfighter("TIE Fighter", "Twin Ion Engine LN Starfighter", "Sienar Fleet Systems", true,
                RandomDouble(),
                "Laser Cannons",
                false));
        allSamples.add(new Starfighter("A-Wing", "RZ-1", "Alliance Underground Engineering", true, RandomDouble(),
                "Laser Cannons",
                true));
        allSamples.add(new Shuttle("Galaxy Class", "NCC-1701-D", "Warp Drive", true, RandomDouble(), 1014,
                "Exploration and Diplomacy"));
        allSamples
                .add(new Shuttle("Imperial Shuttle", "Lambda-class T-4a", "Cygnus Spaceworks", true, RandomDouble(), 20,
                        "Troop Transport"));
        allSamples.add(new Shuttle("Runabout", "Danube Class", "Warp Drive", true, RandomDouble(), 40,
                "Short-range Missions"));
        allSamples.add(new CargoShip("Nostromo", "Lockmart CM-88B Bison M-Class Starfreighter",
                "Rolls-Royce N66 Cyclone Thrust Tunnels", true, RandomDouble(), 20000, true));
        allSamples
                .add(new CargoShip("Sulaco", "Conestoga-class Troop Transport", "Westingland A24", true, RandomDouble(),
                        50000, true));
        allSamples
                .add(new CargoShip("Valley Forge", "American Airlines Space Freighter", "General Electric CF6-50", true,
                        RandomDouble(), 100000,
                        false));
        return allSamples;
    }
}
