/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio8;

/**
 *
 * @author sergi
 */
public class Order {

    int number;
    String date;
    String client;
    Dish dish; // relación: un pedido «tiene» un plato

    public Order(int number, String date, String client, Dish dish) {
        this.number = number;
        this.date = date;
        this.client = client;
        this.dish = dish;
    }

    public void showInfo() {
        System.out.println("-- Order Information --");
        System.out.println("Order number: " + number);
        System.out.println("Date:         " + date);
        System.out.println("Client:       " + client);
        System.out.println("- Dish -");
        dish.showInfo(); // Delegados a la clase de plato
    }

    public static void main(String[] args) {
        Dish dish1 = new Dish("Grilled Chicken", 25000.0);
        Order order1 = new Order(101, "2026-07-31", "Sofia Ramirez", dish1);
        order1.showInfo();
    }
}
