/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_gumaan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Miscellaneous_Income extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3;
    JButton b1;
    JComboBox d,m,y;
    JPanel p1;
    Color color;
       String Year1[]=new String[21];
	String Day[]=new String[31];
	String Month[] = {"Jan", "Feb","March", "April","May","June","July","Aug","Sept","Oct", "Nov","Dec"};
    Cursor cur;
    Connection con;
    Statement s;
    ResultSet rs;
    ImageIcon Home;
    JButton lblHome;
    Miscellaneous_Income()
    {
        setTitle("Newspaper Management System");
        //Cursor
        cur =new Cursor(Cursor.HAND_CURSOR);
        l3=new JLabel("Miscellaneous Income");
        l3.setBounds(40,20,300,40);
   //Panel Here
    p1=new JPanel();
    p1.setLayout(null);
    p1.setBounds(0, 0, 745, 70);
    color=new Color(0,192,255);
    p1.setBackground(color);
    p1.add(l3);
    add(p1);
    //Home
            Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Home.png");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(530, 260);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
    //Font
    Font f1=new Font("Calibri",Font.BOLD+Font.ITALIC,30);
    l3.setFont(f1);
//Labels
    l1=new JLabel("Amount (Rs.)");
    l2=new JLabel("Source of Income");
    l4=new JLabel("Date");
//Bounds
        l1.setBounds(120,120,80,20);
        l2.setBounds(120,150,120,20);
        l4.setBounds(120,180,50,20);
//Adding
       add(l1);
        add(l2);
        add(l4);
//TextFields
        t1=new JTextField();
        t2=new JTextField();
//Bounds
        t1.setBounds(250,120,120,20);
        t2.setBounds(250,150,120,20);
//Adding
       add(t1);
        add(t2);        

      //Button
        b1=new JButton("Save");
        b1.setBounds(220,240,70,20);
        b1.setCursor(cur);
        b1.addActionListener(this);
        add(b1);
        
     //Combo Box Functionality Year
        //Year =new String[21];
        for(int i=2010;i<=2030;++i)
        {
            Year1[i-2010]=Integer.toString(i);
        }
        y=new JComboBox(Year1);
        y.setCursor(cur);
//Combo Box Functionality Day
        //Day =new String[31];
        for(int j=1;j<=31;++j)
        {
            Day[j-1]=Integer.toString(j);
        }
        d=new JComboBox(Day);
        d.setCursor(cur); 
        m=new JComboBox(Month);
        m.setCursor(cur);
//SetBounds ComboBox
d.setBounds(250,180,40,20);
m.setBounds(295,180,70,20);
y.setBounds(370,180,60,20);

//Adding JComboBox        
add(d);
add(m);
add(y);
//Frame
setDefaultCloseOperation(this.EXIT_ON_CLOSE);
setLayout(null);
setSize(600, 350);
setVisible(true);
setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1)
        {
            if(t1.getText().equals("") || t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill all The Fields");
            }
            else {
                try{
                    
                    Integer.parseInt(t1.getText());
                }
                catch(Exception i)
                {
                    JOptionPane.showMessageDialog(null, "Check Amount Field");
                }
                try
                {
                    
                
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from M_Income";
                rs= s.executeQuery(Query);
                rs.moveToInsertRow();
                rs.updateInt("Amount", Integer.parseInt(t1.getText()));
                rs.updateString("Source Of Income", t2.getText());
                rs.updateString("Day", (String)d.getSelectedItem());
                rs.updateString("Month", (String)m.getSelectedItem());
                rs.updateString("Year", (String)y.getSelectedItem());
                rs.insertRow();
                s.close();
                rs.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Record Has Been Saved");
                }
                catch(Exception ey)
                {
                 JOptionPane.showMessageDialog(null, ey.getMessage());   
                }
            }
        }
        else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Main_Screen();
        }
    }
}
