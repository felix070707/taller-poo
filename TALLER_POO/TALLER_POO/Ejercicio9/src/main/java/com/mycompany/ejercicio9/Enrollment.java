/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio9;

/**
 *
 * @author sergi
 */
public class Enrollment {

    Student student;
    Subject subject;

    public Enrollment(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
    }

    public void showInfo() {
        System.out.println("-- Enrollment Information --");
        student.showInfo();
        subject.showInfo();
    }

    public static void main(String[] args) {
        Student student1 = new Student("Daniel Castro", "EST-2026-01");
        Subject subject1 = new Subject("Object-Oriented Programming", 4);
        Enrollment enrollment1 = new Enrollment(student1, subject1);
        enrollment1.showInfo();
    }
}
