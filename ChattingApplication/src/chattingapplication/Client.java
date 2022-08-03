/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattingapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author FREDO
 */
public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JPanel a1;
    static Socket s;
    static DataOutputStream dout;
    static DataInputStream din;
    Boolean typing;
    static Box vertical=Box.createVerticalBox();
    static JFrame f1=new JFrame();
    Client(){
        f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 70);
        f1.add(p1);
         
               //Back arrow
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/3.png"));
        Image i2= i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(5,17,30,30);
        p1.add(l1);
        
        l1.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        
                 //Profile Pic
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/mba.jpg"));
        Image i5= i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel l2= new JLabel(i6);
        l2.setBounds(40,5,60,60);
        p1.add(l2);
        
             //
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/video.png"));
        Image i8= i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel l5= new JLabel(i9);
        l5.setBounds(290,20,30,30);
        p1.add(l5);
        
           //
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/phone.png"));
        Image i11= i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12= new ImageIcon(i11);
        JLabel l6= new JLabel(i12);
        l6.setBounds(350,20,35,30);
        p1.add(l6);
        
        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("chattingapplication/icons/3icon.png"));
        Image i14= i13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon i15= new ImageIcon(i14);
        JLabel l7= new JLabel(i15);
        l7.setBounds(410,20,13,25);
        p1.add(l7);
        
        
        
        //Name
        JLabel l3=new JLabel("Delphine");
        l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        l3.setForeground(Color.white);
        l3.setBounds(110, 15, 100, 18);
        p1.add(l3);
        
        //Active now
        JLabel l4=new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        l4.setForeground(Color.green);
        l4.setBounds(110, 35, 100, 20);
        p1.add(l4);
        
        Timer t= new Timer(1, new ActionListener(){
          
            public void actionPerformed(ActionEvent ae){
                if(!typing){
                    l4.setText("Active Now");
                }
            }
            
        });
        t.setInitialDelay(2000);
        
            //Text Area
        a1= new JPanel();
        a1.setBounds(5,75,440,570);
        //a1.setBackground(Color.PINK);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));

        f1.add(a1);
        
           //Text Message Box
        t1=new JTextField();
        t1.setBounds(5, 655, 310, 40);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f1.add(t1);
        t1.addKeyListener(new KeyAdapter(){
          public void keyPressed(KeyEvent ke){
              l4.setText("typing...");
              t.stop();
              typing=true;
          }  
         public void keyReleased(KeyEvent ke){
             typing=false;
             if(!t.isRunning()){
                 t.start();
                 
             }
         }
            
        });
        
          //Send Button
         b1=new JButton("Send");
         b1.setBounds(320, 655, 123, 40);
         b1.setBackground(new Color(7,94,84));
         b1.setForeground(Color.WHITE);
         b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
         b1.addActionListener(this);
         f1.add(b1);
        f1.getContentPane().setBackground(Color.WHITE);
        f1.setLayout(null);
        f1.setSize(450,735);
        //setLocation(400,200);
        // toremove exit,minimize and maximize
        f1.setUndecorated(false);
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
        String out=t1.getText();
        JPanel p2= formatLabel(out);
        a1.setLayout(new BorderLayout());
        JPanel right=new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right, BorderLayout.PAGE_START);
        vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical);
        //a1.add(p2);
        dout.writeUTF(out);
        t1.setText("");
        }catch(Exception e){
            
        }
    }
    
    public static  JPanel formatLabel(String out){
        JPanel p3=new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        JLabel l1=new JLabel("<html><p style=\"width:150px\">"+out+"</p></html>");
        l1.setFont(new Font("Tahoma",Font.PLAIN,16));
        l1.setBackground(new Color(37, 211,102));
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(15,15,15,50));
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        JLabel l2=new JLabel();
        l2.setText(sdf.format(cal.getTime()));
       p3.add(l1);
       p3.add(l2);
       return p3;
        
    }
    
    public static void main (String [] args){
        
        new Client().f1.setVisible(true);
        
        try{
            s=new Socket("127.0.0.1",1222);
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            String msgin="";
          while(true){
            a1.setLayout(new BorderLayout());
            msgin=din.readUTF();
            JPanel p2=formatLabel(msgin);
            JPanel left=new JPanel(new BorderLayout());
            left.add(p2, BorderLayout.LINE_START);
            vertical.add(left);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START);
            f1.validate();
            }
            
        }catch(Exception e){
            
        }
    }
}
