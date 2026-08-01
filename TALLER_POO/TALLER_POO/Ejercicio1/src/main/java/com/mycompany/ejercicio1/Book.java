/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

/**
 *
 * @author sergi
 */
public class Book {

    // Atributos
    String title;
    String author;
    int pages;

    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // Método para mostrar la información del libro
    public void showInfo() {
        System.out.println("-- Book Information --");
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages:  " + pages);
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert C. Martin", 464);
        book1.showInfo();
    }
}
