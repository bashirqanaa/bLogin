package GUI;

import Constants.CommonConstants;
import db.MyJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends Form{
    public LoginForm() {
        super("Login");
        addGuiComponents();
    }

    private void addGuiComponents(){
        // the login label
        JLabel loginlabel = new JLabel("Login");
        // set the position
        loginlabel.setBounds(0,25,520,100);
        // change the font color
        loginlabel.setForeground(CommonConstants.Text_Color);
        //change the font size
        loginlabel.setFont(new Font("Dialog", Font.BOLD, 40));
        // center the text
        loginlabel.setHorizontalAlignment(SwingConstants.CENTER);
        // add components to GUI
        add(loginlabel);

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

        // username text
        JLabel passwrodlabel = new JLabel("Password:");
        // set the position
        passwrodlabel.setBounds(30,335,400,25);
        // change the font color
        passwrodlabel.setForeground(CommonConstants.Text_Color);
        //change the font size
        passwrodlabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        add(passwrodlabel);


        // password TextField
        JPasswordField passwordField = new JPasswordField();
        // set the position
        passwordField.setBounds(30,365,450,55);
        // change the font color
        passwordField.setForeground(CommonConstants.Text_Color);
        // change the Background
        passwordField.setBackground(CommonConstants.Seconday_Color);
        //change the font size
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(125,520,250,50);
        loginButton.setFont(new Font("Dialog",Font.BOLD,18));
        loginButton.setBackground(CommonConstants.Text_Color);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = usernameField.getText();
                String password = passwordField.getText();
                String feedback = validate(name,password);

                if (feedback == ""){
                    // check if these credentials are correct
                    if(MyJDBC.validate(name,password)){
                        JOptionPane.showMessageDialog(LoginForm.this,"Login successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(LoginForm.this,"Wrong username or password!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,feedback);
                }
            }
        });

        // Register text
        JLabel registerlabel = new JLabel("No account? click her to register!");
        registerlabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerlabel.setBounds(125,600,250,30);
        registerlabel.setForeground(CommonConstants.Text_Color);
        registerlabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginForm.this.dispose();
                new RegisterForm().setVisible(true);
            }
        });
        add(registerlabel);

    }

    private static String validate (String username, String password){
        if (username.length()==0 || password.length()==0) return "Username and password can't be empty!";
        return "";
    }
}
