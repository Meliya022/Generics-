//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create inventory for cars
        Inventory<Car> carInventory = new Inventory<>();
        Car car1 = new Car("Mustang", "VIN1234", 450);
        Car car2 = new Car("Focus", "VIN5678", 160);

        // Add cars to inventory
        carInventory.addToInventory(car1);
        carInventory.addToInventory(car2);

        // Display car inventory
        System.out.println("Car Inventory:");
        carInventory.getInventory().forEach(System.out::println);

        // Create inventory for trucks
        Inventory<Truck> truckInventory = new Inventory<>();
        Truck truck1 = new Truck("F-150", "VIN9876", 375);
        Truck truck2 = new Truck("Ranger", "VIN5432", 270);

        // Add trucks to inventory
        truckInventory.addToInventory(truck1);
        truckInventory.addToInventory(truck2);

        // Display truck inventory
        System.out.println("\nTruck Inventory:");
        truckInventory.getInventory().forEach(System.out::println);

        // Remove a car from car inventory by VIN
        carInventory.removeFromInventory("VIN1234");
        System.out.println("\nCar Inventory after removal:");
        carInventory.getInventory().forEach(System.out::println);
    }

    // Abstract Vehicle class
    abstract static class Vehicle {
        public static final String MAKE = "Ford";

        private String model;
        private String vin;
        private int horsepower;

        public Vehicle(String model, String vin, int horsepower) {
            this.model = model;
            this.vin = vin;
            this.horsepower = horsepower;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            return "Vehicle [MAKE=" + MAKE + ", model=" + model + ", vin=" + vin + ", horsepower=" + horsepower + "]";
        }
    }

    // Car class inheriting Vehicle
    static class Car extends Vehicle {
        public Car(String model, String vin, int horsepower) {
            super(model, vin, horsepower);
        }
    }

    // Truck class inheriting Vehicle
    static class Truck extends Vehicle {
        public Truck(String model, String vin, int horsepower) {
            super(model, vin, horsepower);
        }
    }

    // Generic Inventory class
    static class Inventory<T extends Vehicle> {
        private ArrayList<T> inventory = new ArrayList<>();

        public ArrayList<T> getInventory() {
            return inventory;
        }

        public void setInventory(ArrayList<T> inventory) {
            this.inventory = inventory;
        }

        public void addToInventory(T vehicle) {
            inventory.add(vehicle);
        }

        public void removeFromInventory(String vin) {
            inventory.removeIf(vehicle -> vehicle.getVin().equals(vin));
        }
    }
}
