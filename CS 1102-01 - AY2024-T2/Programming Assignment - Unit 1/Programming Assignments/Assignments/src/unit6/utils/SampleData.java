package unit6.utils;

import unit6.models.Car;
import unit6.models.Motorcycle;
import unit6.models.Truck;

public class SampleData {
    // Sample data for Cars
    public static Car getSampleCar() {
        Car car = new Car();
        car.setMake("DeLorean");
        car.setModel("DMC-12");
        car.setYearOfManufacture(1981);
        car.setNumberOfDoors(2);
        car.setFuelType("Petrol");
        return car;
    }

    // Sample data for Motorcycles
    public static Motorcycle getSampleMotorcycle() {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setMake("Yamaha");
        motorcycle.setModel("XT500");
        motorcycle.setYearOfManufacture(1980);
        motorcycle.setNumberOfWheels(2);
        motorcycle.setType("Off-Road");
        return motorcycle;
    }

    // Sample data for Trucks
    public static Truck getSampleTruck() {
        Truck truck = new Truck();
        truck.setMake("Peterbilt");
        truck.setModel("281");
        truck.setYearOfManufacture(1975);
        truck.setCargoCapacity(20); // in tons
        truck.setTransmissionType("Manual");
        return truck;
    }
}
