/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio6;

/**
 *
 * @author sergi
 */
public class Employee {

    String name;
    String position;
    double baseSalary;
    int overtimeHours;
    static final double OVERTIME_RATE = 8000.0; // valor por hora extra

    public Employee(String name, String position, double baseSalary, int overtimeHours) {
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.overtimeHours = overtimeHours;
    }

    public void showInfo() {
        System.out.println("-- Employee Information --");
        System.out.println("Name:            " + name);
        System.out.println("Position:        " + position);
        System.out.println("Base salary:     $" + baseSalary);
        System.out.println("Overtime hours:  " + overtimeHours);
    }

    // Calcula el salario final, incluyendo el pago de horas extras
    public double calculateFinalSalary() {
        return baseSalary + (overtimeHours * OVERTIME_RATE);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Andres Ruiz", "Developer", 2500000.0, 6);
        employee1.showInfo();
        System.out.println("Final salary: $" + employee1.calculateFinalSalary());
    }
}
