package GUI;
import Constants.CommonConstants;

import javax.swing.*;

public class Form extends JFrame {
    public Form(String title){
        super(title);
        // end the program process once the GUI has been closed.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // set the size of the GUI
        setSize(520,680);
        // center the GUI in the middle of the screen
        setLocationRelativeTo(null);
        // set the layout manger to null so we can position manually
        setLayout(null);
        // prevernt resizing the GUI
        setResizable(false);

        //change the background color
        getContentPane().setBackground(CommonConstants.Primary_Color);
    }

}

