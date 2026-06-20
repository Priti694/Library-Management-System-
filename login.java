package library.management.system;

import library.management.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.awt.Button.*;

public  class login extends JFrame implements ActionListener  {
    JTextField tf1;
    JPasswordField pf1;
    JButton Button;
   public  login() {
        super("Library Management System");
        getContentPane().setBackground(new Color(68, 75, 230));


        setSize(850, 480);
        setLocation(100, 100);
        setLayout(null);
        JLabel heading = new JLabel("LOGIN");
        heading.setBounds(350, 50, 120, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        add(heading);
        JLabel i1 = new JLabel("username");
        i1.setBounds(200, 100, 100, 30);
        i1.setFont(new Font("Arial", Font.BOLD, 14));
        add(i1);
         tf1 = new JTextField();
        tf1.setBounds(300, 100, 220, 30);
        add(tf1);
        JLabel i2 = new JLabel("password");
        i2.setBounds(200, 140, 100, 30);
        i2.setFont(new Font("Arial", Font.BOLD, 14));
        add(i2);
         pf1 = new JPasswordField();
        pf1.setBounds(300, 140, 220, 30);
        add(pf1);
        JButton Button = new JButton("login");
        Button.setBounds(360, 180, 100, 35);
        Button.setFont(new Font("Arial", Font.BOLD, 15));
        Button.addActionListener(this );
        add(Button);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE );
        setVisible(true);
    }

    @Override

        public void actionPerformed (ActionEvent e){
        String username = tf1.getText() ;
        String password= String.valueOf(pf1.getPassword() );

        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, tf1.getText());
                pst.setString(2, pf1.getText());
                ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose() ;
                HomePage home = new HomePage();
                home.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password");
                }
                rs.close();
                pst.close();
                con.close();

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this,e1.getMessage());

            }

        }

    static void main(String[] args) {

        new login();
    }
}


