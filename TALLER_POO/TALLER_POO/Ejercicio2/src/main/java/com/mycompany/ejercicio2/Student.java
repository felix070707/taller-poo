/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

/**
 *
 * @author sergi
 */
public class Student {

    String name;
    int age;
    String grade;

    // Constructor: toda la información se almacena en el momento mismo en que se crea el objeto.
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void showInfo() {
        System.out.println("-- Student Information --");
        System.out.println("Name:  " + name);
        System.out.println("Age:   " + age);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Laura Gomez", 15, "10th grade");
        student1.showInfo();
    }
}
