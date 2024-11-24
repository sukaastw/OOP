/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2.models;

import java.util.ArrayList;

public class Student extends Person {
    String nim;
    ArrayList<String> books;
    ArrayList<Book> booksObj;

    public Student(String nim, String name) {
        this.name = name;
        this.nim = nim;
        this.books = new ArrayList<>();
        this.booksObj = new ArrayList<>();
    }

    public String getNim() {
        return this.nim;
    }

    public String getName() {
        return this.name;
    }

    public void printStudentDetails() {
        System.out.println("NIM: " + nim);
        System.out.println("Name: " + name);
    }

    // Method to get the books of the student
    public ArrayList<String> getBooks() {
        return books;
    }

    // Method to add a book to the student's book list
    public void addBook(String book) {
        books.add(book);
    }

    // Method to add Book object
    public void addBookObj(Book book) {
        booksObj.add(book);
    }

    // Method to get Book objects
    public String getBooksObj() {
        String struct = "Student Name: " + name + "\n";
        for (Book item : booksObj) {
            struct += "Book Code " + item.code + ", Book Name " + item.bookName + "\n";
        }
        return struct;
    }
}
