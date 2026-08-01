/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio7;

/**
 *
 * @author sergi
 */
public class Pet {

    String name;
    String species;
    int age;
    double weight;
    String ownerName;

    public Pet(String name, String species, int age, double weight, String ownerName) {
        // Validaciones básicas en el constructor
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than zero.");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.ownerName = ownerName;
    }

    public void showInfo() {
        System.out.println("-- Pet Information --");
        System.out.println("Name:    " + name);
        System.out.println("Species: " + species);
        System.out.println("Age:     " + age);
        System.out.println("Weight:  " + weight + " kg");
        System.out.println("Owner:   " + ownerName);
    }

    public void registerConsultation(String reason) {
        System.out.println("Medical consultation registered for " + name + ". Reason: " + reason);
    }

    public static void main(String[] args) {
        Pet pet1 = new Pet("Rocky", "Dog", 3, 12.5, "Maria Torres");
        pet1.showInfo();
        pet1.registerConsultation("Annual vaccination");

    }
}
