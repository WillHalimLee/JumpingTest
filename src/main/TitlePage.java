package main;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TitlePage extends JFrame implements ActionListener {
    JFrame frame;
    Container con;

    JButton logInButton, signUpButton;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    JLabel label1;

    public TitlePage() {
        frame = new JFrame();
        frame.setSize(768, 576);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Jumping Mania");

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 768, 192);
        panel1.setBackground(new Color(254, 247, 220));
        panel1.setLayout(null);
        frame.add(panel1);

        label1 = new JLabel();
        label1.setText("JUMPING MANIA");
        label1.setHorizontalTextPosition(JLabel.CENTER); //set text Left, Center, Right of image-icon
        label1.setVerticalTextPosition(JLabel.BOTTOM); //set text Top, center, bottom of image-icon
        label1.setForeground(new Color(234, 92, 43)); //set font color of text
        label1.setFont(new Font("MV Boli", Font.BOLD, 72)); //set font of text
        label1.setBounds(45, 50, 768, 192);
        panel1.add(label1);


        panel2 = new JPanel();
        panel2.setBounds(0, 192, 768, 20);
        panel2.setBackground(new Color(234, 92, 43));
        panel2.setLayout(null);
        frame.add(panel2);

        panel3 = new JPanel();
        panel3.setBounds(0, 212, 256, 300);
        panel3.setBackground(Color.BLACK);
        panel3.setLayout(null);
        frame.add(panel3);

        panel4 = new JPanel();
        panel4.setBounds(256, 212, 256, 300);
        panel4.setBackground(new Color(254, 247, 220));
        panel4.setLayout(null);

        logInButton = new JButton("LOGIN");
        logInButton.setBounds(0, 100, 256, 50);
        logInButton.setBackground(new Color(254, 247, 220));
        logInButton.setForeground(new Color(234, 92, 43));
        logInButton.addActionListener(this);
        logInButton.setFocusable(false);
        logInButton.setHorizontalTextPosition(JButton.CENTER);
        logInButton.setVerticalTextPosition(JButton.BOTTOM);
        logInButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        logInButton.setBorderPainted(false);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(0, 170, 256, 50);
        signUpButton.setBackground(new Color(254, 247, 220));
        signUpButton.setForeground(new Color(234, 92, 43));
        signUpButton.addActionListener(this);
        signUpButton.setFocusable(false);
        signUpButton.setHorizontalTextPosition(JButton.CENTER);
        signUpButton.setVerticalTextPosition(JButton.BOTTOM);
        signUpButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        signUpButton.setBorderPainted(false);
        panel4.add(logInButton);
        panel4.add(signUpButton);
        frame.add(panel4);

        panel5 = new JPanel();
        panel5.setBounds(512, 212, 256, 300);
        panel5.setBackground(Color.BLACK);
        panel5.setLayout(null);
        frame.add(panel5);

        panel6 = new JPanel();
        panel6.setBounds(0, 512, 768, 25);
        panel6.setBackground(new Color(234, 92, 43));
        frame.add(panel6);


        con = frame.getContentPane();

        con.add(panel4);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInButton) {
            new LogInPage();
            frame.setVisible(false);
        }
        else if (e.getSource() == signUpButton) {
            new SignPage();
            frame.setVisible(false);
        }
    }
}

