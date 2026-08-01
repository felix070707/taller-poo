/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3;

/**
 *
 * @author sergi
 */
public class Product {

    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void showInfo() {
        System.out.println("-- Product Information --");
        System.out.println("Name:     " + name);
        System.out.println("Price:    $" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Método que realiza un cálculo: valor total del inventario
    public double calculateTotalValue() {
        return price * quantity;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Rice 1kg", 3200.0, 50);
        product1.showInfo();
        System.out.println("Total inventory value: $" + product1.calculateTotalValue());
    }
}
