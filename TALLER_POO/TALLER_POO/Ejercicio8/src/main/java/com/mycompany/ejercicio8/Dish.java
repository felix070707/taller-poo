/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio8;

/**
 *
 * @author sergi
 */
public class Dish {

    String name;
    double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void showInfo() {
        System.out.println("Dish:  " + name);
        System.out.println("Price: $" + price);
    }
}
