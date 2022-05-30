/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_gumaan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Miscelleneous_Expenses extends JFrame implements ActionListener {
    JLabel  lblTitle,lblRS, lblCause, lblDate;
    JTextField txtRS, txtCause;
    JComboBox day, month, year;
    JPanel panel;
    Color color;
    Font f;
    Container c;
    String Day[]=new String[31];
    String Year[]=new String[21];
    String Month[]={"Jan", "Feb", "March", "April", "May", "June", "July"," Aug","Sept", "Oct", "Nov", "Dec"};
    JButton btnsave;
    Cursor cur;
    Connection con;
    Statement s;
    ResultSet rs;
    ImageIcon Home;
    JButton lblHome;
    Miscelleneous_Expenses()
    {
        setTitle("Newspaper Management System");
        //Cursor Shpe
        cur = new Cursor(Cursor.HAND_CURSOR);
        c= this.getContentPane();
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Home.png");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(530, 260);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
        //Making Panel
        panel = new JPanel();
        panel.setSize(600, 70);
        panel.setLocation(0, 0);
        panel.setLayout(null);
        color= new Color(0, 192, 255);
        panel.setBackground(color);
        c.add(panel);
        //Labels
        f= new Font("Calibiri", Font.BOLD+Font.ITALIC, 25);
        lblTitle = new JLabel("Miscelleneous Expenses");
        lblTitle.setFont(f);
        lblTitle.setSize(300, 30);
        lblTitle.setLocation(40, 20);
        panel.add(lblTitle);
        lblRS=new JLabel("Amount (Rs.)");
        lblRS.setSize(80, 20);
        lblRS.setLocation(120, 120);
        lblCause= new JLabel("Cause of Expense");
        lblCause.setSize(120,20);
        lblCause.setLocation(120, 150);
        lblDate= new JLabel("Date");
        lblDate.setSize(50, 20);
        lblDate.setLocation(120, 180);
        c.add(lblRS);
        c.add(lblCause);
        c.add(lblDate);
        //TextFields
        txtRS=new JTextField();
        txtRS.setSize(120, 20);
        txtRS.setLocation(250, 120);
        txtCause= new JTextField();
        txtCause.setSize(120, 20);
        txtCause.setLocation(250, 150);
        c.add(txtRS);
        c.add(txtCause);
        //ComboBox
       for (int i =1; i<=31; i++)
       {
           Day[i-1]=Integer.toString(i);
           
       }
       day= new JComboBox(Day);
       day.setCursor(cur);
       day.setSize(40, 20);
       day.setLocation(250, 180);
       month=new JComboBox(Month);
       month.setSize(70, 20);
       month.setLocation(295, 180);
       month.setCursor(cur);
       for (int i =2010; i<=2030; i++)
       {
           Year[i-2010]=Integer.toString(i);
           
       }
       year= new JComboBox(Year);
       year.setSize(60, 20);
       year.setLocation(370, 180);
       year.setCursor(cur);
       c.add(day);
       c.add(month);
       c.add(year);
       //Button
       
       btnsave= new JButton("Save");
       btnsave.setSize(70, 20);
       btnsave.setLocation(220, 240);
       btnsave.setCursor(cur);
       btnsave.addActionListener(this);
       c.add(btnsave);
       //Frame
        setSize(600, 350);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnsave)
        {
            if(txtRS.getText().equals("") || txtCause.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill all The Fields");
            }
           else {
                
                try{
                    
                    Integer.parseInt(txtRS.getText());
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
                String Query= "select * from M_Expenses";
                rs= s.executeQuery(Query);
                rs.moveToInsertRow();
                rs.updateInt("Amount", Integer.parseInt(txtRS.getText()));
                rs.updateString("Source Of Income", txtCause.getText());
                rs.updateString("Day", (String)day.getSelectedItem());
                rs.updateString("Month", (String)month.getSelectedItem());
                rs.updateString("Year", (String)year.getSelectedItem());
                rs.insertRow();
                s.close();
                rs.close();
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
