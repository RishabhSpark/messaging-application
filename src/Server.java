import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Server implements ActionListener{
	
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JPanel a1;
    static JFrame f1 = new JFrame();
    
    static Box vertical = Box.createVerticalBox();
    
    static ServerSocket skt;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    Boolean typing;
    
    Server(){
        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        f1.setResizable(false);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(114, 137, 217));
        p1.setBounds(0, 0, 450, 70);
        f1.add(p1);
       
       JLabel l3 = new JLabel("Rishabh");
       l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
       l3.setForeground(Color.WHITE);
       l3.setBounds(15, 15, 100, 18);
       p1.add(l3);
       
       JLabel l4 = new JLabel("Online");
       l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
       l4.setForeground(Color.WHITE);
       l4.setBounds(15, 35, 100, 20);
       p1.add(l4);  
       
       Timer t = new Timer(1, new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               if(!typing){
                   l4.setText("Online");
               }
           }
       });
       
       t.setInitialDelay(2000);
       
       
       a1 = new JPanel();
//       a1.setBounds(5, 75, 335, 555);
       a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//       f1.add(a1);

       
       JScrollPane scroll = new JScrollPane(a1);
       scroll.setBounds(5,75,335,555);
       scroll.setBorder(BorderFactory.createEmptyBorder());
       f1.add(scroll);
       
       
       t1 = new JTextField();
       t1.setBounds(5, 635, 255, 40);
       t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       f1.add(t1);
       
       t1.addKeyListener(new KeyAdapter(){
           public void keyPressed(KeyEvent ke){
               l4.setText("typing...");
               
               t.stop();
               
               typing = true;
           }
           
           public void keyReleased(KeyEvent ke){
               typing = false;
               
               if(!t.isRunning()){
                   t.start();
               }
           }
       });
       
       b1 = new JButton("Send");
       b1.setBounds(263, 635, 80, 40);
       b1.setBackground(new Color(114, 137, 217));
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       b1.addActionListener(this);
       f1.add(b1);
        
       f1.getContentPane().setBackground(Color.WHITE);
       f1.setLayout(null);
       f1.setSize(360, 720);
       f1.setLocation(800, 0); 
       f1.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String out = t1.getText();
            MessageToText(t1.getText());
            t1.setText("");
            
            JPanel p2 = formatLabel(out);
            
            a1.setLayout(new BorderLayout());
            
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            
            a1.add(vertical, BorderLayout.PAGE_START);
            
            dout.writeUTF(out);
        }
        catch(Exception e){
        	System.out.println(e);
        }
    }
    
    public void MessageToText(String message) throws FileNotFoundException {
    	try {
            File f1 = new File("Chat_Backup.txt");
            if(!f1.exists()) {
               f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write("Ishaan: " + message + "\n");
            bw.close();
         } catch(IOException e){
            e.printStackTrace();
         }
    }
    
    public static JPanel formatLabel(String out){
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        
        JLabel l1 = new JLabel("<html><p style = \"width : 150px\">"+out+"</p></html>");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBackground(new Color(114, 137, 217));
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(15,15,15,50));
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel l2 = new JLabel();
        l2.setText(sdf.format(cal.getTime()));
        
        p3.add(l1);
        p3.add(l2);
        return p3;
        }
    
    public static void main(String[] args){
        new Server();
		Server.f1.setVisible(true);
        
        String msginput = "";
        try{
            skt = new ServerSocket(6001);
            while(true){
                s = skt.accept();
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
            
	        while(true){
	                	msginput = din.readUTF();
                        JPanel p2 = formatLabel(msginput);
                        
                        JPanel left = new JPanel(new BorderLayout());
                        left.add(p2, BorderLayout.LINE_START);
                        vertical.add(left);
                        f1.validate();
            	}
            }
        }
        
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }
}