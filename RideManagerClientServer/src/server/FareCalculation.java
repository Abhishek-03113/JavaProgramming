package server;

import common.Vehicle;

public class FareCalculation {


    public static double calculateDefaultFare(Vehicle vehicle) {
        return vehicle.getCost() * 5;
    }

    public static double calculateFare(Vehicle vehicle, int distance) {
        return vehicle.getCost() * distance;
    }

    public static double calculateFare(Vehicle vehicle, int distance, double surgeMultiplier) {
        return calculateFare(vehicle, distance) * surgeMultiplier;
    }

    public static double calculateFare(Vehicle vehicle, int distance, double surgeMultiplier, double discount) {
        return calculateFare(vehicle, distance, surgeMultiplier) * (1 - discount);
    }

}
