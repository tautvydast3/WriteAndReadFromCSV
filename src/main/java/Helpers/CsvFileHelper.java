package Helpers;

import Model.Book;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CsvFileHelper {
    public static void main(String[] args) throws IOException {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {

            fw = new FileWriter("testCSV.csv");
            bw = new BufferedWriter(fw);

            bw.write("ID;Year;Author;Name\n");
            bw.write("Pirma eilute\n");
            bw.write("Nauja eilute\n");

        } catch (Exception exc) {
            System.out.println(String.format("Ivyko klaida: %s", exc.getMessage()));
        } finally {
            bw.close();
        }


    }

    ////////////////////////////////////////////////////////////////////
    //Skaitau ish CSV
    public static ArrayList<Book> getFromCsv(String s) throws IOException {

        ArrayList<Book> books = new ArrayList<Book>();

        FileReader fr = null;
        BufferedReader br = null;
        try {

            fr = new FileReader("./src/main/java/Files/testCSV.csv");
            br = new BufferedReader(fr);

            String textLine;
            int counter = 0;
            while ((textLine = br.readLine()) != null) {
                counter++;
                if (counter == 1) {
                    continue;
                }

                String[] bookData = textLine.split(";");
                Book x = new Book(Integer.parseInt(bookData[0]), Integer.parseInt(bookData[1]), bookData[2], bookData[3]);
                books.add(x);
                //System.out.println(textLine);
            }
        } catch (Exception exc) {
            System.out.println(String.format("Ivyko klaida: %s", exc.getMessage()));
        } finally {
            br.close();
        }
        return books;
    }

    ///////////////////////////////////////////////////////
    //Rashau i CSV

    public static ArrayList<Book> setToCsv(int id, int year, String author, String name, String s) throws IOException {

        ArrayList<Book> booksList = new ArrayList<Book>();
        FileReader fr = null;
        BufferedReader br = null;
        try {

            fr = new FileReader("./src/main/java/Files/testCSV.csv");
            br = new BufferedReader(fr);

            String textLine;
            int counter = 0;
            while ((textLine = br.readLine()) != null) {
                counter++;
                if (counter == 1) {
                    continue;
                }

                String[] bookData = textLine.split(";");
                Book x = new Book(Integer.parseInt(bookData[0]), Integer.parseInt(bookData[1]), bookData[2], bookData[3]);
                booksList.add(x);
            }

            ArrayList<Book> books = new ArrayList<Book>();
            books = new ArrayList<Book>() {
                {
                    add(new Book(id, year, author, name));
                    addAll(booksList);
//
//                add(new Book(id, 1987, "Vytaute Zilinskaite", "Robotas ir peteliske"));
//                add(new Book(id, 1564, "Daniel Defo", "Robinzonas Kruzas"));
//                add(new Book(id, 1587, "Martynas Mazvydas", "Katekizmas"));
//                add(new Book(id, 2021, "Victor Uspaskich", "Gyvasis vanduo"));

                }
            };


            FileWriter fw = null;
            BufferedWriter bw = null;
            try {

                fw = new FileWriter("./src/main/java/Files/testCSV.csv");
                bw = new BufferedWriter(fw);

                bw.write("ID;Year;Author;Name\n");

                for (Book p : books) {
                    bw.write(String.format("%s;%s;%s;%s\n", p.getId(), p.getYear(), p.getAuthor(), p.getName()));
                }

            } catch (
                    Exception exc) {
                System.out.println(String.format("Ivyko klaida: %s", exc.getMessage()));
            } finally {
                bw.close();
            }


            return books;

        } finally {

        }
        }}
