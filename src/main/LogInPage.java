package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogInPage implements ActionListener {
    //https://www.youtube.com/watch?v=iE8tZ0hn2Ws&ab_channel=AlexLee
    JFrame frame;
    JPanel panel1, panel2, panel3, panel4;
    JLabel logIn, passWord;
    JTextField loginT;
    JPasswordField passWordT;
    JButton submit, back;

    public LogInPage(){
        frame = new JFrame();
        frame = new JFrame();
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Login Here");
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

        submit = new JButton("LOGIN");
        submit.setBounds(0, 150, 256, 50);
        submit.setBackground(new Color(254, 247, 220));
        submit.setForeground(new Color(234, 92, 43));
        submit.addActionListener(this);//this --> new TitlePage.LogInPage ()
        submit.setFocusable(false);
        submit.setHorizontalTextPosition(JButton.CENTER);
        submit.setVerticalTextPosition(JButton.BOTTOM);
        submit.setFont(new Font("MV Boli", Font.BOLD, 30));
        submit.setBorderPainted(false);

        panel4.add(submit);
        frame.add(panel4);

    }

    @Override
    public void actionPerformed(ActionEvent f) {
        Map<String, String> map = new HashMap<>();

        String user = loginT.getText();
        String password = passWordT.getText();
        String fileUser = "";
        String filePass = "";
        boolean userFound = false;

        if (f.getSource() == submit) {
            try {
                File file = new File("src/UserName.txt");
                Scanner scan = new Scanner(file);
                while(scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    String userName = parts[0];
                    String passWord = parts[1];

                    if (user.equals(userName) && password.equals(passWord)) {
                        userFound = true;
                    }
                }
                if(userFound){
                    JFrame window = new JFrame();
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setResizable(false);
                    window.setTitle("Jumping Mania");

                    GamePanel gamePanel = new GamePanel();
                    window.add(gamePanel);

                    window.pack();
                    window.setLocationRelativeTo(null);
                    window.setVisible(true);

                    gamePanel.startGameThread();

                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong password or username. or username does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }


        }else if (f.getSource() == back){
            new TitlePage();
            frame.setVisible(false);
        }
    }
}
