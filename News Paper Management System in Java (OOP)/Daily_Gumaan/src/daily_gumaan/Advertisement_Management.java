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
public class Advertisement_Management extends JFrame  implements ItemListener, ActionListener{
     JPanel panel;
    Color color;
    Font f, f2;
    JLabel lblTitle, lbl, lblDate; 
    JButton btndelete, lblHome, btnPay;
   JComboBox Adds_ID, year, month;
   JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10, lblPayment, lblPay, lblRemaining;
        JTextField t1, t2, t3, t4, t5, t6, t7, t8, txtPay, txtRemainig;
        
     Container c;
   JLabel lblimg;
   ImageIcon img;
   Connection con;
   Statement s;
   ResultSet rs;
   ImageIcon Home;
   Cursor cur;
   String  Month[], Year[];
    Advertisement_Management()
    {
        cur= new Cursor(Cursor.HAND_CURSOR);
        c=this.getContentPane();
       
        //Label
        lbl=new JLabel("Advertisement ID");
        lbl.setSize(100, 20);
        lbl.setLocation(345, 100);
        c.add(lbl);
        lblDate=new JLabel("Search For");
        lblDate.setSize(100, 20);
        lblDate.setLocation(80, 100);
         c.add(lblDate);
//ComboBox
        Adds_ID=new JComboBox();
        Adds_ID.setBounds(450,100,145,20);
        Adds_ID.addItemListener(this);
        c.add(Adds_ID);
           month= new JComboBox();
        month.setCursor(cur);
        Year= new String [21];
            
             for (int i=2010; i<=2030; i++)
        {
        Year[i-2010]=Integer.toString(i);
        
        }
       year = new JComboBox(Year);
       year.setCursor(cur);
       
       
       
        month.addItem("Jan");
        month.addItem("Feb");
        month.addItem("March");
        month.addItem("April");
        month.addItem("May");
        month.addItem("June");
        month.addItem("July");
        month.addItem("Aug");
        month.addItem("Sept");
        month.addItem("Oct");
        month.addItem("Nov");
        month.addItem("Dec");
        month.setSize(80, 20);
        month.setLocation(180, 100);
        month.addItemListener(this);
        year.setSize(60,20);
        year.setLocation(262,100);
        year.addItemListener(this);
        
         
        c.add(year);
        c.add(month); 

                
           // Color
        color= new Color(0, 192, 255);
        //Button
        btndelete= new JButton("Search");
        btndelete.setSize(80, 20);
        btndelete.setLocation(305, 140);
        
        btndelete.setCursor(cur);
        btndelete.addActionListener(this);
        //btndelete.addActionListener(this);
        c.add(btndelete);
        //Panels
        panel= new JPanel();
        panel.setSize(750, 70);
        panel.setLocation(0,0);
        panel.setLayout(null);
        panel.setBackground(color);
        c.add(panel);
        //Back Button
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(10, 510);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
//Labels
         l1=new JLabel("Title of Advertisement");      
         l2=new JLabel("Anchor Name"); 
         l3=new JLabel("Sponser's Name"); 
         l4=new JLabel("Duration");
         l5=new JLabel("Size of Advertisement");
         l6=new JLabel("Price of Advertisement"); 
         l7=new JLabel("Commission(%)"); 
        l8=new JLabel("Without commission");
        //TextField
        t1=new JTextField();
         t2=new JTextField();
         t3=new JTextField();
         t4=new JTextField();
         t5=new JTextField();
         t6=new JTextField();
         t7=new JTextField();
         t8=new JTextField();
         //TextField and label size and location 
        l1.setBounds(50,190,140,20);
        t1.setBounds(200,190,140,20);
        
        l2.setBounds(365,190,140,20);
        t2.setBounds(500,190,140,20);
        l3.setBounds(50,220,140,20);
        t3.setBounds(200,220,140,20);
         l4.setBounds(365,220,140,20);
        t4.setBounds(500,220,140,20);
         l5.setBounds(50,250,140,20);
        t5.setBounds(200,250,140,20);
          l6.setBounds(365,250,140,20);
        t6.setBounds(500,250,140,20);
        l7.setBounds(50,280,140,20);
        t7.setBounds(200,280,140,20);
         l8.setSize(140, 20);
        l8.setLocation(365, 280);
        t8.setSize(140, 20);
        t8.setLocation(500, 280);
        //Adding TextField And Label
        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(t2);
          c.add(l3);
        c.add(t3);
        
        c.add(l4);
        c.add(t4);
        c.add(l5);
        c.add(t5);
          c.add(l6);
        c.add(t6);
        c.add(l7);
        c.add(t7);
          c.add(l8);
        c.add(t8);
        //Edititable
         t1.setEditable(false);
                t2.setEditable(false);
                t3.setEditable(false);
                t4.setEditable(false);
                t5.setEditable(false);
                t6.setEditable(false);
                t7.setEditable(false);
                t8.setEditable(false);
                
                
        //Payment
        f2= new Font("Calibri", Font.BOLD+Font.ITALIC, 20);
        lblPayment=new JLabel("Pay Your Dues");
        lblPayment.setSize(250, 20);
        lblPayment.setLocation(280, 330);
        lblPayment.setForeground(Color.BLUE);
        lblPayment.setFont(f2);
        c.add(lblPayment);
        lblPay=new JLabel("Pay Amount (Rs.)");
        lblPay.setSize(140, 20);
        lblPay.setLocation(50, 360);
        txtPay=new JTextField();
        txtPay.setSize(140, 20);
        txtPay.setLocation(200, 360);
        
         lblRemaining=new JLabel("Remaining Amount (Rs.)");
        lblRemaining.setSize(170, 20);
        lblRemaining.setLocation(360, 360);
        txtRemainig=new JTextField();
        txtRemainig.setSize(140, 20);
        txtRemainig.setLocation(500, 360);
        txtRemainig.setEditable(false);
        c.add(lblPay);
        c.add(txtPay);
        c.add(lblRemaining);
        c.add(txtRemainig);
        //Pay Button
        btnPay=new JButton("Pay");
        btnPay.setSize(70, 20);
        btnPay.setLocation(290, 400);
        btnPay.addActionListener(this);
        c.add(btnPay);
         //Font
        f= new Font("Calibari", Font.BOLD+Font.ITALIC, 30);
        //Label
        lblTitle=new JLabel("Advertisement Accounts");
        lblTitle.setSize(400, 35);
        lblTitle.setLocation(40, 25);
        lblTitle.setFont(f);
        panel.add(lblTitle);
        //Frame 
        setTitle("Newspaper Management System");
       setSize(750, 600);
        setResizable(false);
        setLayout(null);
         setVisible(true);
         setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()==year)
        {
            int i=0;
              t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            txtPay.setText("");
            txtRemainig.setText("");
            Adds_ID.removeAllItems();
            try
                
            {
                 String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        i++;
                    Adds_ID.addItem(rs.getString("Advertisement ID"));
                    }
                }
                if(i==0)
                {
                  JOptionPane.showMessageDialog(null, "Record Not Found");    
                }
                s.close();
                rs.close();
                con.close();
            }
            catch(Exception er)
            {
                JOptionPane.showMessageDialog(null, er.getMessage());
            }
        }
        else if(e.getSource()==month || e.getSource()==Adds_ID)
        {
            
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            txtPay.setText("");
            txtRemainig.setText("");
            
        }
        
        
    }
    public void actionPerformed(ActionEvent r)
    {
        if(r.getSource()==btndelete)
        {
            int WithoutComission=0;
            try
            {
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(Adds_ID.getSelectedItem().equals(rs.getString("Advertisement ID")))
                    {
                        t1.setText(rs.getString("Title of Advertisement"));
                        t2.setText(rs.getString("Anchor Name"));
                        t3.setText(rs.getString("Sponser's Name"));
                        t4.setText(rs.getString("Duration"));
                        t5.setText(rs.getString("Size of Advertisement"));
                        t6.setText(Integer.toString(rs.getInt("Price of Advertisement")));
                        t7.setText(Integer.toString(rs.getInt("Comission")));
                         t8.setText(Integer.toString((rs.getInt("Price of Advertisement"))-(rs.getInt("Comission Price"))));
                        
                    }
                }
                t8.setBackground(Color.GREEN);
                con.close();
               
            }
            catch(Exception t)
            {
              JOptionPane.showMessageDialog(null, t.getMessage());
            }
        }
        else if(r.getSource()==btnPay)
        {
            int pay=0, withoutComission=0, Remaining=0, i=0;
            try
            {
             try
            {
                pay=Integer.parseInt(txtPay.getText());
                withoutComission=Integer.parseInt(t8.getText());
            }
            catch(Exception epay)
            {
                JOptionPane.showMessageDialog(null, "Check Pay Amount Field");
            }
             Remaining=withoutComission-pay;
             txtRemainig.setText(Integer.toString(Remaining));
             txtRemainig.setForeground(Color.RED);
             if(Remaining<0)
             {
                 i++;
                 JOptionPane.showMessageDialog(null, "Return "+Remaining+" To your Anchor");
             }
             String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement_Accounts";
                rs= s.executeQuery(Query);
                rs.moveToInsertRow();
                rs.updateString("Advertisement ID", (String)Adds_ID.getSelectedItem());
                rs.updateString("Anchor Name", t2.getText());
                rs.updateString("Sponser's Name", t3.getText());
                rs.updateInt("Advertisement Price", Integer.parseInt(t6.getText()));
                rs.updateInt("Without Comission", Integer.parseInt(t8.getText()));
                rs.updateInt("Paid", Integer.parseInt(txtPay.getText()));
               
                
                if(i>0)
                {
                    rs.updateInt("Remaining", 0);
                   
                }
                else
                {
                    rs.updateInt("Remaining", Integer.parseInt(txtRemainig.getText()));
                     
                }
                rs.updateString("Month", (String)month.getSelectedItem());
                rs.updateString("Year", (String)year.getSelectedItem());
                rs.insertRow();
                 JOptionPane.showMessageDialog(null, "Your Amount Has Been Paid");
                 
                s.close();
                rs.close();
            }
            catch(Exception b)
            {
                JOptionPane.showMessageDialog(null, b.getMessage());
            }
        }
        else if(r.getSource()==lblHome)
        {
            this.setVisible(false);
            new Accounts_Main_Menu();
        }
    }
    }
    

