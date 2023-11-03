package GUI;

import Constants.CommonConstants;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterForm extends Form{

    public RegisterForm() {
        super("Register");
        addGuiComponents();
    }


    private void addGuiComponents(){
        // the register label
        JLabel registerlabel = new JLabel("Register");
        // set the position
        registerlabel.setBounds(0,25,520,100);
        // change the font color
        registerlabel.setForeground(CommonConstants.Text_Color);
        //change the font size
        registerlabel.setFont(new Font("Dialog", Font.BOLD, 40));
        // center the text
        registerlabel.setHorizontalAlignment(SwingConstants.CENTER);
        // add components to GUI
        add(registerlabel);

        // username text
        JLabel usernameLabel = new JLabel("Username:");
        // set the position
        usernameLabel.setBounds(30,150,400,25);
        // change the font color
        usernameLabel.setForeground(CommonConstants.Text_Color);
        //change the font size
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(usernameLabel);

        // username TextField
        JTextField usernameField = new JTextField();
        // set the position
        usernameField.setBounds(30,185,450,55);
        // change the font color
        usernameField.setForeground(CommonConstants.Text_Color);
        // change the Background
        usernameField.setBackground(CommonConstants.Seconday_Color);
        //change the font size
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameField);

        // password text
        JLabel passwrodlabel = new JLabel("Password:");
        // set the position
        passwrodlabel.setBounds(30,255,400,25);
        // change the font color
        passwrodlabel.setForeground(CommonConstants.Text_Color);
        //change the font size
        passwrodlabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(passwrodlabel);


        // password TextField
        JPasswordField passwordField = new JPasswordField();
        // set the position
        passwordField.setBounds(30,285,450,55);
        // change the font color
        passwordField.setForeground(CommonConstants.Text_Color);
        // change the Background
        passwordField.setBackground(CommonConstants.Seconday_Color);
        //change the font size
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordField);



        // password text
        JLabel passwrodlabel2 = new JLabel("Re-enter Password:");
        // set the position
        passwrodlabel2.setBounds(30,355,400,25);
        // change the font color
        passwrodlabel2.setForeground(CommonConstants.Text_Color);
        //change the font size
        passwrodlabel2.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(passwrodlabel2);


        // password TextField
        JPasswordField passwordField2 = new JPasswordField();
        // set the position
        passwordField2.setBounds(30,385,450,55);
        // change the font color
        passwordField2.setForeground(CommonConstants.Text_Color);
        // change the Background
        passwordField2.setBackground(CommonConstants.Seconday_Color);
        //change the font size
        passwordField2.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordField2);

        //button
        JButton RegisterButton = new JButton("Register");
        RegisterButton.setBounds(125,520,250,50);
        RegisterButton.setFont(new Font("Dialog",Font.BOLD,18));
        RegisterButton.setBackground(CommonConstants.Text_Color);
        RegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(RegisterButton);
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String password2 = passwordField2.getText();

                //validate the user input
                if(validate(username,password,password2)){
                    // register the user
                    if(MyJDBC.register(username,password)){
                        // dispose the UI if true
                        RegisterForm.this.dispose();
                        LoginForm loginForm = new LoginForm();
                        loginForm.setVisible(true);

                        JOptionPane.showMessageDialog(loginForm,"The account has been registered successfully!");

                    }
                    else {
                        JOptionPane.showMessageDialog(RegisterForm.this,"Username already exists!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(RegisterForm.this,"Passwords must match and fields can not be empty");
                }
            }
        });

        // Register text
        JLabel LoginLabel = new JLabel("Have an account? Login!");
        LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LoginLabel.setBounds(125,600,250,30);
        LoginLabel.setForeground(CommonConstants.Text_Color);
        LoginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LoginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterForm.this.dispose();
                new LoginForm().setVisible(true);
            }
        });
        add(LoginLabel);

    }

    private static boolean validate(String username, String password, String password2){
        if (username.length()==0 || password.length()==0 || password2.length()==0) return false;
        if (!password.equals(password2)) return false;
        return true;
    }

}
