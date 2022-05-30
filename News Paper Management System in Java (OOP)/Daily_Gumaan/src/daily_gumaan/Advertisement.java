/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_gumaan;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Advertisement extends JFrame implements ActionListener {
     JPanel lbl;
        JLabel l9;
         Font f;
         Color color;
         JComboBox year;
        JComboBox day, month;
        String Year[];
        String Day[];
        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10;
        JTextField t1, t2, t3, t4, t5, t6, t7, t10;
        Cursor cur;
        JButton b;
        Connection con;
        Statement s;
        ResultSet rs;
        ImageIcon Home;
        JButton lblHome;
        
    Advertisement()
    {
        cur = new Cursor(Cursor.HAND_CURSOR);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Home.png");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(765, 245);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
        setTitle("Newspaper Management System");
        

         setLayout(null);
        setSize(852,350);

        Container x=this.getContentPane();

        
        
        lbl=new JPanel();
        lbl.setLayout(null);
        lbl.setSize(852,70);
        color=new Color(0,192,255);
        lbl.setBackground(color);
        l9=new JLabel("Advertisement Details");
       l9.setLayout(null);
        l9.setSize(500,40);
        l9.setLocation(40, 25);
        f=new Font("Calibiri",Font.BOLD+Font.ITALIC,30);
        l9.setFont(f);
        l9.setForeground(Color.BLACK);
        
       //Combobox
         month= new JComboBox();
        month.setCursor(cur);
        Year= new String [21];
            
             for (int i=2010; i<=2030; i++)
        {
        Year[i-2010]=Integer.toString(i);
        
        }
       year = new JComboBox(Year);
       year.setCursor(cur);
       Day= new String[31];
       for (int i=1; i<=31; i++)
        {
          Day[i-1]=Integer.toString(i);
        }
       day = new JComboBox(Day);
       day.setCursor(cur);
       //Labels
         l1=new JLabel("Title of Advertisement:");      
         l2=new JLabel("Anchor Name:"); 
         l3=new JLabel("Sponser's Name"); 
         l4=new JLabel("Duration:");
         l5=new JLabel("Size of Advertisement:");
         l6=new JLabel("Price of Advertisement:"); 
         l7=new JLabel("Commission (%)"); 
        l8=new JLabel("Date:");
        l10= new JLabel("Advertisement ID");
 //Text Fields       
         t1=new JTextField();
         t2=new JTextField();
         t3=new JTextField();
         t4=new JTextField();
         t5=new JTextField();
         t6=new JTextField();
         t7=new JTextField();
         t10= new JTextField();
        
        //Button
       
        b=new JButton("Save");
       //TextField and label size and location 
        l1.setBounds(100,100,140,20);
        t1.setBounds(240,100,140,20);
  
        l2.setBounds(410,100,140,20);
        t2.setBounds(560,100,140,20);
        
        l3.setBounds(100,130,140,20);
        t3.setBounds(240,130,140,20);
        
        l4.setBounds(410,130,140,20);
        t4.setBounds(560,130,140,20);
        
        l5.setBounds(100,160,140,20);
        t5.setBounds(240,160,140,20);
        
        l6.setBounds(410,160,140,20);
        t6.setBounds(560,160,140,20);
        
        l7.setBounds(100,190,140,20);
        t7.setBounds(240,190,140,20);
        l10.setSize(150, 20);
        l10.setLocation(100, 230);
        t10.setSize(140, 20);
        t10.setLocation(240, 230);
        l8.setBounds(410,190,140,20);
        
        b.setBounds(350,270,100,20);
        
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
        month.setSize(60, 20);
        month.setLocation(615, 190);
        year.setSize(60,20);
        year.setLocation(680,190);
        day.setSize(50,20);
        day.setLocation(560,190);
        //Adding all the Meterilas
        x.add(day);
        x.add(year);
        x.add(month);        
        x.add(l1);
        x.add(l2);
        x.add(l3);
        x.add(l4);
        x.add(l5);
        x.add(l6);
        x.add(l7);
        x.add(l8);
        x.add(l10);
        x.add(t10);
        x.add(b);
        x.add(t1);
        x.add(t2);
        x.add(t3);
        x.add(t4);
        x.add(t5);
        x.add(t6);
        x.add(t7);
        x.add(lbl);
        lbl.add(l9);
       b.setCursor(cur);
        b.addActionListener(this);
        getContentPane().add(month);
         setVisible(true);
        }
    public void actionPerformed(ActionEvent e)
    {
            
    
        if (e.getSource()==b)
        {
            int comission=0, adds_price=0, comission_price = 0, i=0;
            if(t1.getText().equals("") || t2.getText().equals("") ||t3.getText().equals("") || t4.getText().equals("")
                    ||t5.getText().equals("") || t6.getText().equals("")||t7.getText().equals("")||t10.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill all The Fields");
            }
            else
            {
            
                 try{
                        
                     comission=Integer.parseInt(t7.getText());
                     adds_price=Integer.parseInt(t6.getText());
                     comission_price=(adds_price*comission)/100;
                    
                    }
                    catch(Exception et)
                    {
                      JOptionPane.showMessageDialog(null, "Check Price and Comission Fields");  
                    }
                 try
                 {
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(t10.getText().equals(rs.getString("Advertisement ID")))
                    {
                        i++;
                        con.close();
                        break;
                    }
                }
                if(i>0)
                 {
                     JOptionPane.showMessageDialog(null, "This Advertisement ID Exist");
                 }
                 else
                 {
                      
                      
                 rs.moveToInsertRow();
                 rs.updateString("Advertisement ID", t10.getText());
                rs.updateString("Title of Advertisement", t1.getText());
                rs.updateString("Anchor Name", t2.getText());
                rs.updateString("Sponser's Name", t3.getText());
                rs.updateString("Duration", t4.getText());
                rs.updateString("Size of Advertisement", t5.getText());
                rs.updateInt("Price of Advertisement", Integer.parseInt(t6.getText()));
                rs.updateInt("Comission", Integer.parseInt(t7.getText()));
                rs.updateString("Day", (String)day.getSelectedItem());
                rs.updateString("Month", (String)month.getSelectedItem());
                rs.updateString("Year", (String)year.getSelectedItem());
                rs.updateInt("Comission Price", comission_price);
                rs.insertRow();
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t10.setText("");
                s.close();
                rs.close();
                JOptionPane.showMessageDialog(null, "Record Has Been Saved");
                 }
              }
                 
            catch(Exception t)
                 {
                     JOptionPane.showMessageDialog(null, t.getMessage());
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

