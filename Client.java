/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbook;

/**
 *
 * @author thesurajbhan
 */

import static chatbook.Server.a1;
import static chatbook.Server.dout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    
     static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    Client(){
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(146, 44, 171));
        p1.setBounds(0, 0, 350, 60);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatbook/icons/ii.png")); 
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(10, 18, 25, 20);
        p1.add(l1);
        
        l1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
    });
                
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatbook/icons/2.jpeg")); 
        Image i5 = i4.getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(40, 1, 60, 60);
        p1.add(l2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatbook/icons/video.png")); 
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(240, 15, 35, 30);
        p1.add(l5);
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatbook/icons/phone.png")); 
        Image i12 = i11.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel l6 = new JLabel(i13);
        l6.setBounds(285, 15, 35, 30);
        p1.add(l6);
        
        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatbook/icons/3icon.png")); 
        Image i15 = i14.getImage().getScaledInstance(13, 22, Image.SCALE_DEFAULT);
        ImageIcon i16 = new ImageIcon(i15);
        JLabel l7 = new JLabel(i16);
        l7.setBounds(330, 15, 13, 25); 
        p1.add(l7);
        
        
        JLabel l3 = new JLabel("Visheshank");
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        l3.setForeground(Color.WHITE);
        l3.setBounds(110, 15, 100, 18);
        p1.add(l3);
        
        JLabel l4 = new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 13));
        l4.setForeground(Color.WHITE);
        l4.setBounds(110, 35, 100, 20);
        p1.add(l4);
        
        a1 = new JTextArea();
        a1.setBounds(5, 60, 340, 440);
        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);
       
        t1 = new JTextField();
        t1.setBounds(6, 510, 255, 30);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);
        
        b1 = new JButton("Send");
        b1.setBounds(266, 509, 78, 30);
        b1.setBackground(new Color(146, 44, 171));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        setLayout(null);
        setSize(350, 550);
        setLocation(1200, 200);
        setUndecorated(true);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae){
        try{
        String out = t1.getText();
        a1.setText(a1.getText()+"\n\t\t"+out);
        dout.writeUTF(out);
        t1.setText("");
        }catch(Exception e){}
        
      
        
    }
    public static void main(String[] args){
        new Client().setVisible(true);
        
         
        try{
           s=new Socket("127.0.0.1", 6001);
           din=new DataInputStream(s.getInputStream());
           dout=new DataOutputStream(s.getOutputStream());
           
           
           String msginput="";
           
           msginput=din.readUTF();
           a1.setText(a1.getText()+"\n"+msginput);
        }catch(Exception e){}
        
    }
    
}

