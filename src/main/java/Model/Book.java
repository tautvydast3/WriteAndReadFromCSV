package Model;

import Helpers.HelperFunctions;

import java.util.ArrayList;

public class Book {
    Integer id;
    Integer year;
    String author;
    String name;

    public static ArrayList<Book> books;


    public ArrayList<Book> getBookArrayList() {
        return books;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.books = bookArrayList;
    }

    //#region Geteriai ir Seteriai
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//#endregion
//Konstruktorius

    public Book(Integer id, Integer year, String author, String name) {
        this.id = HelperFunctions.generateNewId();
        this.year = year;
        this.author = author;
        this.name = name;
    }


}