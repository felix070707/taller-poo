/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio5;

/**
 *
 * @author sergi
 */
public class Vehicle {

    String plate;
    String brand;
    String model;
    double fuel; // litros disponibles
    boolean turnedOn;

    public Vehicle(String plate, String brand, String model, double fuel) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.turnedOn = false; // starts turned off
    }

    public void showInfo() {
        System.out.println("-- Vehicle Information --");
        System.out.println("Plate: " + plate);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Fuel:  " + fuel + " L");
        System.out.println("State: " + (turnedOn ? "ON" : "OFF"));
    }

    public void turnOn() {
        if (turnedOn) {
            System.out.println("The vehicle is already turned on.");
        } else {
            turnedOn = true;
            System.out.println("Vehicle turned on.");
        }
    }

    public void turnOff() {
        if (!turnedOn) {
            System.out.println("The vehicle is already turned off.");
        } else {
            turnedOn = false;
            System.out.println("Vehicle turned off.");
        }
    }

    // Registra un viaje y reduce el combustible disponible.
    public void drive(double distanceKm) {
        double consumption = distanceKm * 0.1; // Regla sencilla: 0,1 L por km.
        if (!turnedOn) {
            System.out.println("The vehicle must be turned on before driving.");
        } else if (consumption > fuel) {
            System.out.println("Not enough fuel for this trip.");
        } else {
            fuel -= consumption;
            System.out.println("Trip of " + distanceKm + " km completed. Fuel consumed: " + consumption + " L");
        }
    }

    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("XYZ-123", "Chevrolet", "Spark", 30.0);
        car1.showInfo();
        car1.turnOn();
        car1.drive(50);
        car1.showInfo();
        car1.turnOff();
    }
}
