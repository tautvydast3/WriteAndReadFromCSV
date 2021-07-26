import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle(""); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit of of application
        this.setResizable(false); //prevents frame from resizing
        this.setSize(420, 500); //set the x-dimension and y-dimension of frame
        this.setVisible(true); // make frame visible

//        ImageIcon logo = new ImageIcon("src/main/zodiac-logo.png"); //create an ImageIcon
//        this.setIconImage(logo.getImage()); //change icon of frame


        this.getContentPane().setBackground(Color.decode("#335566"));

    }

    public MyFrame(int width, int height, String trispalve) {
    }

}

