import Helpers.CsvFileHelper;
import Model.Book;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Book> books = new ArrayList<Book>();

    public static int id;
    public static int year;
    public static String author;
    public static String name;


    public static void main(String[] args) {
        int width = 420;
        int height = 420;

        MyFrame frame = new MyFrame(width, height, "Trispalve");
        frame.setSize(height, width);
        frame.setTitle("CSV WRITER");
        Border border = LineBorder.createGrayLineBorder();


        //#endregion

        //#region sukurti JPanel header
        JPanel header = new JPanel();
        header.setBackground(Color.decode("#f4f4f4"));
        header.setSize(width, height / 10);
        frame.add(header, BorderLayout.PAGE_START);
        //#endregion

        //#region sukurti JPanel body
        JPanel body = new JPanel();
        body.setBackground(Color.decode("#999999"));
        body.setSize(width, height / 3);
        body.setLayout(new BorderLayout(1, 1));
        body.setVisible(true);
        frame.add(body, BorderLayout.CENTER);

        //#endregion

        //#region sukurti JPanel footer
        JPanel footer = new JPanel();
        footer.setBackground(Color.decode("#f4f4f4"));
        footer.setSize(width, height / 3);
        frame.add(footer, BorderLayout.PAGE_END);
        //#endregion

        //Sukuriu input boxams krastus ir nustatau ju spalva
        Border borderGray = BorderFactory.createLineBorder(Color.GRAY, 1);
        Border borderRed = BorderFactory.createLineBorder(Color.RED, 1);
        //sukuriu input boxus
        JTextField yearBox = new JTextField("2021", 10);
        JTextField authorBox = new JTextField("Author", 10);
        JTextField nameBox = new JTextField("Name", 10);

        // input boxus pridedu prie header paneles
        header.add(yearBox);
        header.add(authorBox);
        header.add(nameBox);

        // Jlabel dialogBox pridedu prie body

        JLabel dialogBox = new JLabel("");
        dialogBox.setSize(width, height / 5);
        dialogBox.setHorizontalTextPosition(JLabel.CENTER);
        dialogBox.setVerticalTextPosition(JLabel.BOTTOM);
        dialogBox.setBorder(border);
        dialogBox.setBackground(Color.decode("#f4f4f4"));
        dialogBox.setVisible(true);
        body.add(dialogBox);

        //Sukuriu mygtukus

        JButton btnWrite = new JButton("Write");
        JButton btnRead = new JButton("Read");
        btnWrite.setSize(width / 3, height / 10);
        btnRead.setSize(width / 3, height / 10);
        // mygtukus pridedu prie footer paneles

        footer.add(btnWrite);
        footer.add(btnRead);

        frame.setVisible(true);

        //#region Mygtuku logika
        btnWrite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                year = Integer.parseInt(yearBox.getText());
                author = (authorBox.getText());
                name = (nameBox.getText());
                // new WriteTextToFile();
                try {
                    ArrayList<Book> books = CsvFileHelper.setToCsv(id, year, author, name, "./src/main/java/Files/testCSV.csv");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
//                System.out.println(id + year + author + name);
//                System.out.println("paspausta Write");
            }
        });


        btnRead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    books = CsvFileHelper.getFromCsv("./src/main/java/Files/testCSV.csv");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String displayText = "";
                String displayText1 = "";
                for (int i = 0; i < books.size(); i++) {
                    displayText = (books.get(i).getId() + ", " + books.get(i).getYear() + ", " + books.get(i).getAuthor() + ", " + books.get(i).getName() + "\n");

                    displayText1 = ("<html>" + displayText + "<br/>" + displayText1 + "</html>");

                    dialogBox.setText(displayText1);
                }
              //  System.out.println(displayText1);
            }
        });
    }
}