package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SignPage implements ActionListener {
    //https://www.youtube.com/watch?v=iE8tZ0hn2Ws&ab_channel=AlexLee

    JFrame frame;
    JPanel panel1, panel2, panel3, panel4;
    JLabel logIn, passWord;
    JTextField loginT;
    JPasswordField passWordT;
    JButton signUp, back;
    HashMap<String, String> map;
    final static String outputFilePath = "src/UserName.txt";

    public SignPage() {
        frame = new JFrame();
        frame = new JFrame();
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Sign up here");
        frame.setVisible(true);

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 500, 100);
        panel1.setBackground(new Color(254, 247, 220));
        panel1.setLayout(null);

        frame.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(0, 100, 500, 400);
        panel2.setBackground(new Color(254, 247, 220));

        logIn = new JLabel("User Name:");
        logIn.setBounds(10, 20, 80, 25);
        logIn.setForeground(new Color(234, 92, 43)); //set font color of text
        logIn.setFont(new Font("MV Boli", Font.BOLD, 60)); //set font of text

        loginT = new JTextField(35);

        panel2.add(logIn);
        panel2.add(loginT);

        passWord = new JLabel("Password:");
        passWord.setBounds(10, 20, 80, 25);
        passWord.setForeground(new Color(234, 92, 43)); //set font color of text
        passWord.setFont(new Font("MV Boli", Font.BOLD, 60)); //set font of text

        passWordT = new JPasswordField(35);

        panel2.add(passWord);
        panel2.add(passWordT);

        frame.add(panel2);

        panel3 = new JPanel();
        panel3.setBounds(0, 500, 250, 100);
        panel3.setBackground(new Color(254, 247, 220));

        back = new JButton("BACK");
        back.setBounds(0, 150, 256, 50);
        back.setBackground(new Color(254, 247, 220));
        back.setForeground(new Color(234, 92, 43));
        back.setFocusable(false);
        back.setHorizontalTextPosition(JButton.CENTER);
        back.setVerticalTextPosition(JButton.BOTTOM);
        back.setFont(new Font("MV Boli", Font.BOLD, 30));
        back.setBorderPainted(false);
        back.addActionListener(this); //this --> new TitlePage.LogInPage ()
        panel3.add(back);
        frame.add(panel3);

        panel4 = new JPanel();
        panel4.setBounds(250, 500, 250, 100);
        panel4.setBackground(new Color(254, 247, 220));

        signUp = new JButton("SIGN-UP");
        signUp.setBounds(0, 150, 256, 50);
        signUp.setBackground(new Color(254, 247, 220));
        signUp.setForeground(new Color(234, 92, 43));
        signUp.setFocusable(false);
        signUp.setHorizontalTextPosition(JButton.CENTER);
        signUp.setVerticalTextPosition(JButton.BOTTOM);
        signUp.setFont(new Font("MV Boli", Font.BOLD, 30));
        signUp.setBorderPainted(false);
        signUp.addActionListener(this); //this --> new TitlePage.LogInPage ()
        panel4.add(signUp);
        frame.add(panel4);


    }

    @Override
    public void actionPerformed(ActionEvent a) {

        String user = loginT.getText();
        String password = passWordT.getText();

        boolean userFound = false;

        if (a.getSource() == signUp) {
            if (!user.equals("") && !password.equals("")) {
                map = new HashMap<>();
                map.put(user, password);
                try {
                    File file = new File("src/UserName.txt");
                    Scanner scan = new Scanner(file);
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        String[] parts = line.split(" ");
                        String userName = parts[0];
                        String passWord = parts[1];
                        if (user.equals(userName)) {
                            userFound = true;
                        }
                    }
                    if (userFound) {
                        JOptionPane.showMessageDialog(null, "Oops... User name already exist", "Oops", JOptionPane.WARNING_MESSAGE);
                    } else {
                        BufferedWriter bf = null; //BufferedWriter is a subclass of java. io. Writer class. BufferedWriter writes text to character output stream
                        try {
                            bf = new BufferedWriter(new FileWriter(file, true));

                            for (Map.Entry<String, String> entry : map.entrySet()) { //entrySet --> used to create a set out of the same elements contained in the hash map.
                                // Returns a set view of the hash map or we can create a new set and store the map elements into them.
                                bf.write(entry.getKey() + " " + entry.getValue()); // put key and value separated by a colon
                                bf.newLine(); // new line
                            }
                        } catch (IOException ignored) {
                        }

                        try {
                            bf.close();
                        }  // always close the writer
                        catch (Exception ignored) {
                        }

                        new LogInPage();
                        frame.setVisible(false);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a Username and a Password", "Oops", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (a.getSource() == back) {
            new TitlePage();
            frame.setVisible(false);
        }

    }
}
