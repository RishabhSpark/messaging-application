import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;

public class GUI extends JFrame implements ActionListener{
    JLabel Register_Login;
    JLabel search;
    JLabel Username;
    JLabel Password;
    JTextField Enter_Username;
    JPasswordField Enter_Password;
    JButton submit_button;
    JButton next_button;
    JTextField Enter_Message;
    JButton send_button;
    JPanel top_bg;
    JTextArea message_box;
    JTextField search_user;
    JButton select_button;
    JButton back_button;
    
    GUI(){
        ImageIcon logo = new ImageIcon("logo.png");

        this.setLayout(null);
        this.setTitle("We Don't Byte");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.setSize(360,640);


        Register_Login = new JLabel();
        Register_Login.setText("     REGISTER/LOGIN");
        Register_Login.setFont(new Font("uni sans", Font.PLAIN, 20));
        Register_Login.setBounds(60, 170, 300, 80);
        this.add(Register_Login);


        // "Enter your name" TEXT, FIRST SCREEN
        Username = new JLabel();
        Username.setText("Username");
        Username.setBounds(20, 250, 89, 40);
        this.add(Username);

        Password = new JLabel();
        Password.setText("Password");
        Password.setBounds(20, 320, 89, 40);
        this.add(Password);


        // INPUT FROM USER, FIRST SCREEN
        Enter_Username = new JTextField();
        Enter_Username.setLocation(90, 250);
        Enter_Username.setSize(220,40);
        this.add(Enter_Username);

        Enter_Password = new JPasswordField();
        Enter_Password.setLocation(90, 320);
        Enter_Password.setSize(220,40);
        this.add(Enter_Password);

        // USERNAME SUBMIT BUTTON, FIRST SCREEN
        submit_button = new JButton("Submit");
        submit_button.addActionListener(this);
        submit_button.setLocation(110,380);
        submit_button.setSize(100,30);
        this.add(submit_button);


        search = new JLabel();
        search.setText("Search User");
        search.setBounds(10, 12, 100, 40);
        search.setVisible(false);
        this.add(search);


        search_user = new JTextField();
        search_user.setLocation(90, 12);
        search_user.setSize(220,40);
        search_user.setVisible(false);
        this.add(search_user);

        select_button = new JButton("Select");
        select_button.setLocation(275,573);
        select_button.setSize(70,28);
        select_button.setVisible(false);
        select_button.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            if(e.getSource()==select_button){
                System.out.println("Messages opened!");
                Register_Login.setVisible(false);
                Username.setVisible(false);
                Password.setVisible(false);
                Enter_Username.setVisible(false);
                Enter_Password.setVisible(false);
                next_button.setVisible(false);
                submit_button.setVisible(false);
                Enter_Message.setVisible(true);
                send_button.setVisible(true);
                message_box.setVisible(true);
                search_user.setVisible(false);
                search.setVisible(false);
                select_button.setVisible(false);
                back_button.setVisible(true);
            }
        }
    });
        this.add(select_button);

        back_button = new JButton("Back");
        back_button.setLocation(275,18);
        back_button.setSize(70,28);
        back_button.setVisible(false);
        back_button.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            if(e.getSource()==back_button){
                System.out.println("Back to search page!");
                Register_Login.setVisible(false);
                Username.setVisible(false);
                Password.setVisible(false);
                Enter_Username.setVisible(false);
                Enter_Password.setVisible(false);
                next_button.setVisible(false);
                submit_button.setVisible(false);
                Enter_Message.setVisible(false);
                send_button.setVisible(false);
                top_bg.setVisible(true);
                message_box.setVisible(false);
                search_user.setVisible(true);
                search.setVisible(true);
                select_button.setVisible(true);
                back_button.setVisible(false);
            }
        }
    });
        this.add(back_button);

        // ENTER MESSAGE TO SEND
        Enter_Message = new JTextField();
        Enter_Message.setLocation(2, 573);
        Enter_Message.setSize(270,30);
        Enter_Message.setVisible(false);
        this.add(Enter_Message);


        // BUTTON TO SEND THE MESSAGE, NEED TO ADD ENTER KEYBIND LATER TOO
        send_button = new JButton("Send");
        send_button.setLocation(275,573);
        send_button.setSize(70,28);
        send_button.setVisible(false);
        send_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==send_button){
                    System.out.println("Message: " + Enter_Message.getText());
                    String s = Enter_Message.getText();
                    message_box.setText(message_box.getText() + "\n"+ s);
                    Enter_Message.setText("");
                    Enter_Message.requestFocus();       // Send button press karte hi next message keliye focus set hojayega Text enter karne wali jagah pe so that the person doesn't need to click on it again
                }
            }
        });
        this.add(send_button);

        
        top_bg = new JPanel();
        top_bg.setBackground(new Color(114, 137, 217));
        top_bg.setBounds(0, 0, 360, 60);
        top_bg.setVisible(false);
        this.add(top_bg);

        message_box = new JTextArea();
        message_box.setBounds(2, 63, 342, 508);
        message_box.setBackground(new Color(60,62,71));
        message_box.setForeground(Color.white);
        message_box.setFont(new Font("uni sans", Font.PLAIN, 14));
        message_box.setVisible(false);
        message_box.setEditable(false);
        message_box.setLineWrap(true);
        message_box.setWrapStyleWord(true);
        this.add(message_box);

        // NEXT BUTTON, FIRST SCREEN
        next_button = new JButton("Next");
        next_button.setLocation(220,550);
        next_button.setSize(100,30);
        next_button.setEnabled(false);
        // NEXT BUTTON ACTION, HIDES EVERYTHING
        next_button.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            if(e.getSource()==next_button){
                System.out.println("Action performed");
                Register_Login.setVisible(false);
                Username.setVisible(false);
                Password.setVisible(false);
                Enter_Username.setVisible(false);
                Enter_Password.setVisible(false);
                next_button.setVisible(false);
                submit_button.setVisible(false);
                // Enter_Message.setVisible(true);
                // send_button.setVisible(true);
                top_bg.setVisible(true);
                // message_box.setVisible(true);
                search_user.setVisible(true);
                search.setVisible(true);
                select_button.setVisible(true);
            }
        }
    });
        this.add(next_button);
        
        this.setVisible(true);
    }



    // SUBMIT BUTTON ACTION, FIRST SCREEN
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit_button){
            System.out.println(Enter_Username.getText() + " joined!");
            submit_button.setEnabled(false);
            Enter_Username.setEditable(false);
            Enter_Password.setEditable(false);
            next_button.setEnabled(true);
        }
    }
}