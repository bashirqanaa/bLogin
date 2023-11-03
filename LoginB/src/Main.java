import GUI.Form;
import GUI.LoginForm;
import GUI.RegisterForm;
import db.MyJDBC;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Thread safe updates to the Swing GUI
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new LoginForm().setVisible(true);
                //System.out.println(MyJDBC.checkUser("Mark"));
                //System.out.println(MyJDBC.validate("Mark", "123"));
            }
        });
    }
}
