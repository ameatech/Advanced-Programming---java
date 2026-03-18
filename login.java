/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package section2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
class Dconnection{
    String sql;
    Connection con;
    Statement st;
    ResultSet rs;
    Dconnection(){
    try {
            String host="jdbc:mysql://localhost:3306/ap",u="root", p="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(host,u,p);
             if(con != null){
                 System.out.println("connection success");
             }
         } catch (Exception ex) {
             System.out.println("error\n"+ex);
         }
    }
    boolean search(String id, String name) throws Exception{
        sql="select * from student where id='"+id+"' && name='"+name+"'";
        st=con.createStatement();
        rs=st.executeQuery(sql);
        if(rs.next()){
            return true;
        }
        else{
        return false;
    }
    }
    void register(String name) throws Exception{
        sql="insert into student(name) values('"+name+"')";
        st=con.createStatement();
        int record=st.executeUpdate(sql);
        if(record>0){
            JOptionPane.showConfirmDialog(null, "one row affected");
        }
    }
           
}


public class login {
    public static void main(String[] args) {
        JFrame f = new JFrame("login demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setBounds(100,100,400,400);
        JLabel l1= new JLabel("Login");
        l1.setBounds(10,10,100,45);
        l1.setFont(new Font("Times new Roman", Font.ROMAN_BASELINE, 40));
        JTextField tf1= new JTextField();
        tf1.setBounds(10,70,100,30);
        JTextField tf2= new JTextField();
        tf2.setBounds(10,103,100,30);
        JButton b1 = new JButton("Login");
        b1.setBounds(50, 135, 100, 30);
        JLabel l3= new JLabel("Haven't you account");
        l3.setBounds(10,165,150,30);
        JButton b2 = new JButton("Register");
        b2.setBounds(165,165,100,30);
        b2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               //redirect to sign up
               signdm si= new signdm();
                si.setVisible(true);
                f.setVisible(false);
            }
        });
        b1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dconnection db = new Dconnection();
                try {
                    if(db.search(tf1.getText(), tf2.getText())){
                    Test t = new Test();
                   t.setVisible(true);
                   f.setVisible(false);
                   
                    }
                    else{
                   JOptionPane.showMessageDialog(null, "wrong usetname or password");
               }
                } catch (Exception e) {
                    
                }
               
            }
        });
        f.add(l1);
        f.add(tf1);
        f.add(tf2);
        f.add(b1);
        f.add(l3);
        f.add(b2);
        //f.getContentPane().setBackground(new Color(0X881111));
        f.setVisible(true);
    }
}
