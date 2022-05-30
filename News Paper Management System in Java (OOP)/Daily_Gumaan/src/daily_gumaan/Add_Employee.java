
package daily_gumaan;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.sql.*;
public class Add_Employee extends JFrame implements ActionListener
{
JLabel title,l1,l2,l3,l4;
JTextField t1,t2,t3;
JComboBox t4;
JButton b1, lblHome;
Font f;
JPanel jp;
Color clr;
Connection con;
Statement stmt;
ResultSet rst;
String station[]={"Lodhran", "Gogran", "Sui_Wala", "Permat", "Dhanot", "Gely_Wal", "Dunya Pur", "Jalla_Arain", "Kehroor_Pakka", "Bahawalpur"};
ImageIcon Home;
Cursor cur;
Add_Employee()
{
    cur= new Cursor(Cursor.HAND_CURSOR);
    f= new Font("Calibari", Font.BOLD+Font.ITALIC, 30);
    clr= new Color(0, 192, 255);
    title=new JLabel("Add Employee");
    title.setBounds(40,25,250,40);
    title.setFont(f);
    jp= new JPanel();
     jp.setSize(600, 70);
     jp.setLocation(0,0);
     jp.setLayout(null);
     jp.setBackground(clr);
     add(jp);
     jp.add(title);
             
    //Labels
    
    l1= new JLabel("First Name");
    l2= new JLabel("Last Name");
    l3= new JLabel("Contact No");
    l4= new JLabel("Station");
//SetBounds Label
l1.setBounds(50,100,150,20);
l3.setBounds(50,150,150,20);
l2.setBounds(320,100,150,20);
l4.setBounds(320,150,150,20);
//Adding Labels
add(l1);
add(l2);
add(l3);
add(l4);
    //TExtFields
    t1= new JTextField();
    t2= new JTextField();
    t3= new JTextField();
    //JComboBox
    t4= new JComboBox(station);
//SetBounds TextFields
t1.setBounds(160,100,100,20);
t2.setBounds(400,100,100,20);
t3.setBounds(160,150,100,20);
t4.setBounds(400,150,100,20);
//Adding TExtFields
add(t1);
add(t2);
add(t3);
add(t4);
//Adding Button 
b1=new JButton("Add");
b1.setBounds(270,190,60,25);
b1.setCursor(cur);
b1.addActionListener(this);
add(b1);
//Back pic Buton
Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(530, 210);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
//Frame 
setSize(600, 300);
setResizable(false);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
    if (e.getSource()==b1)
    {
        if (t1.getText().equals("")|| t2.getText().equals("")||t3.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Fill All The Fields");
        }
        else
        {
            try
            {
            long a=Long.parseLong(t3.getText());
            }
            catch(Exception et)
            {
                JOptionPane.showMessageDialog(null, "Contact No should be like this 0300+++++21");
            }
            if(t3.getText().length()==11) {
             
                try
                {
                    String db = "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan_Data.accdb";
                    con=DriverManager.getConnection(db);
                    stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String Query="select * from "+(String)t4.getSelectedItem();
                    rst= stmt.executeQuery(Query);
                    rst.moveToInsertRow();
                    rst.updateString("First Name", t1.getText());
                    rst.updateString("Last Name", t2.getText());
                    rst.updateString("Contact No", t3.getText());
                    rst.updateString("Stations", (String) t4.getSelectedItem());
                    rst.insertRow();
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    stmt.close();
                    rst.close();
                    JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Contact No should be 11 Digits");
            }
            
        }
    }
    else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Setting();
        }
}
}
