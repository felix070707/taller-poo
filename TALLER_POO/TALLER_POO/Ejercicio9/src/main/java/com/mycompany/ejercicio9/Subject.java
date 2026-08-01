/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio9;

/**
 *
 * @author sergi
 */
public class Subject {

    String name;
    int credits;

    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void showInfo() {
        System.out.println("Subject: " + name + " (" + credits + " credits)");
    }
}
