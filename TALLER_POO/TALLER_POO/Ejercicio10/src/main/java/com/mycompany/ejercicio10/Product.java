/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio10;

/**
 *
 * @author sergi
 */
public class Product {

    String name;
    double price;
    int quantityPurchased;

    public Product(String name, double price, int quantityPurchased) {
        this.name = name;
        this.price = price;
        this.quantityPurchased = quantityPurchased;
    }

    public double getSubtotal() {
        return price * quantityPurchased;
    }

    public void showInfo() {
        System.out.println(quantityPurchased + " x " + name + " ($" + price + " each) = $" + getSubtotal());
    }
}
