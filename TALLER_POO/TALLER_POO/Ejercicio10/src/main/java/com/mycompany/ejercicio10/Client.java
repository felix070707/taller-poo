/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio10;

/**
 *
 * @author sergi
 */
public class Client {

    String name;
    String email;
    String idNumber;

    public Client(String name, String email, String idNumber) {
        this.name = name;
        this.email = email;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("Client: " + name + " | Email: " + email + " | ID: " + idNumber);
    }
}
