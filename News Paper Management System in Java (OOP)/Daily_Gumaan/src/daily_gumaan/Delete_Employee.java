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

public class Delete_Employee extends JFrame implements ItemListener, ActionListener{
    JPanel panel;
    Color color;
    Font f;
    JLabel lblTitle, lbl, lblP;
    JButton btndelete, lblHome;
   JComboBox stations,employees;
   String station[]={"Lodhran", "Gogran", "Sui_Wala", "Permat", "Dhanot", "Gely_Wal", "Dunya_Pur", "Jalla_Arain", "Kehroor_Pakka", "Bahawalpur"};
   
   //String emp[];
   Container c;
   JLabel lblimg;
   ImageIcon img;
   Connection con;
   Statement s;
   ResultSet rs;
   ImageIcon Home;
   Cursor cur;
    Delete_Employee()
    {
        cur= new Cursor(Cursor.HAND_CURSOR);
        c=this.getContentPane();
        //Imaees
        img = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Delete.png");
        lblimg= new JLabel(img);
        lblimg.setSize(img.getIconWidth(), img.getIconHeight());
        lblimg.setLocation(420, 90);
        c.add(lblimg);
        //Label
        lbl=new JLabel("Stations");
        lbl.setSize(100, 20);
        lbl.setLocation(70, 100);
        c.add(lbl);
         lblP=new JLabel("Employee");
        lblP.setSize(100, 20);
        lblP.setLocation(70, 130);
        c.add(lblP);
//ComboBox
        stations=new JComboBox(station);
        stations.setBounds(180,100,150,20);
        stations.addItemListener(this);
        c.add(stations);
        employees=new JComboBox();
        employees.setBounds(180,130,150,20);
        c.add(employees);

                
           // Color
        color= new Color(0, 192, 255);
        //Button
        btndelete= new JButton("Delete");
        btndelete.setSize(70, 20);
        btndelete.setLocation(180, 180);
        btndelete.setCursor(cur);
        btndelete.addActionListener(this);
        c.add(btndelete);
        //Panels
        panel= new JPanel();
        panel.setSize(600, 70);
        panel.setLocation(0,0);
        panel.setLayout(null);
        panel.setBackground(color);
        c.add(panel);
        //Back Button
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(10, 210);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
         //Font
        f= new Font("Calibari", Font.BOLD+Font.ITALIC, 30);
        //Label
        lblTitle=new JLabel("Delete Employee");
        lblTitle.setSize(250, 35);
        lblTitle.setLocation(40, 25);
        lblTitle.setFont(f);
        panel.add(lblTitle);
        //Frame 
        setTitle("Newspaper Management System");
       setSize(600, 300);
        setResizable(false);
        setLayout(null);
         setVisible(true);
         setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    public void itemStateChanged(ItemEvent ie) {
     if (ie.getSource()==stations)
     {
         employees.removeAllItems();
            try
            {
                String Name=null;
                 int i=0;
            String db= "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan_Data.accdb";
            con= DriverManager.getConnection(db);
            s= con.createStatement();
            String Query="select * from "+(String)stations.getSelectedItem();
            rs= s.executeQuery(Query);
            while(rs.next())
            {
                i++;
                Name=rs.getString("First Name")+" "+rs.getString("Last Name");
                employees.addItem(Name);
                Name=null;
            }
            con.close();
            if (i==0)
            {
                JOptionPane.showMessageDialog(null, "No Any Employee For This Station");
            }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
     }
    }
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource()==btndelete)
       {
          try
          {
              int i=0;
                String db= "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan_Data.accdb";
            con= DriverManager.getConnection(db);
            s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String Query="select * from "+(String)stations.getSelectedItem();
            rs= s.executeQuery(Query);
            while(rs.next())
            {
                
                if (employees.getSelectedItem().equals(rs.getString("First Name")+" "+rs.getString("Last Name")))
                {
                    i++;
                    rs.deleteRow();
                    s.close();
                    rs.close();
                    break;
                }
            }
            con.close();
            if(i>0)
            {
                employees.removeItem(employees.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Employee Has Been Deleted Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Employee Not Found");
            }
          }
          catch(Exception ev)
          {
             JOptionPane.showMessageDialog(null, ev.getMessage());
          }
       }
        else if(ae.getSource()==lblHome)
        {
            this.setVisible(false);
            new Setting();
        }
    }
}
