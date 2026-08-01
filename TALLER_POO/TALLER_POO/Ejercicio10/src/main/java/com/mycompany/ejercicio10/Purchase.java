/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergi
 */
public class Purchase {

    int number;
    String date;
    Client client;
    List<Product> products;

    public Purchase(int number, String date, Client client) {
        this.number = number;
        this.date = date;
        this.client = client;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // Calcula el importe total que el cliente debe pagar.
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getSubtotal();
        }
        return total;
    }

    public void showInfo() {
        System.out.println("---- Purchase Information ----");
        System.out.println("Purchase number: " + number);
        System.out.println("Date:            " + date);
        client.showInfo();
        System.out.println("--- Products ---");
        for (Product product : products) {
            product.showInfo();
        }
        System.out.println("Total to pay: $" + calculateTotal());
    }

    public static void main(String[] args) {
        Client client1 = new Client("Valentina Diaz", "valentina@email.com", "1094567890");
        Purchase purchase1 = new Purchase(5001, "2026-07-31", client1);

        purchase1.addProduct(new Product("Wireless Mouse", 45000.0, 1));
        purchase1.addProduct(new Product("Keyboard", 80000.0, 1));
        purchase1.addProduct(new Product("USB Cable", 15000.0, 3));

        purchase1.showInfo();
    }
}
