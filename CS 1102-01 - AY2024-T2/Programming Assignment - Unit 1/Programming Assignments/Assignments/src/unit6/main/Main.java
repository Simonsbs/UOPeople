package unit6.main;

import unit6.models.Car;
import unit6.models.Motorcycle;
import unit6.models.Truck;
import unit6.utils.SampleData;

public class Main {
    public static void main(String[] args) {
        // Create sample vehicles using the SampleData utility class
        Car sampleCar = SampleData.getSampleCar();
        Motorcycle sampleMotorcycle = SampleData.getSampleMotorcycle();
        Truck sampleTruck = SampleData.getSampleTruck();

        // Display details of each vehicle
        displayCarDetails(sampleCar);
        displayMotorcycleDetails(sampleMotorcycle);
        displayTruckDetails(sampleTruck);
    }

    private static void displayCarDetails(Car car) {
        System.out.println("Car Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year of Manufacture: " + car.getYearOfManufacture());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
        System.out.println("Fuel Type: " + car.getFuelType());
        System.out.println();
    }

    private static void displayMotorcycleDetails(Motorcycle motorcycle) {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year of Manufacture: " + motorcycle.getYearOfManufacture());
        System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
        System.out.println("Type: " + motorcycle.getType());
        System.out.println();
    }

    private static void displayTruckDetails(Truck truck) {
        System.out.println("Truck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year of Manufacture: " + truck.getYearOfManufacture());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());
        System.out.println();
    }
}
