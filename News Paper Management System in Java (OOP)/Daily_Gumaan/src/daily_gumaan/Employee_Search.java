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
/**
 *
 * @author Ehtesham
 */
public class Employee_Search extends JFrame implements ActionListener, ItemListener
{
 JTextArea t1,t2,t3;
    JLabel title,l1,l2,l3,l4;
    JPanel p1,p2;
    JComboBox stat;
    JButton search, lblHome;
    Color color;
    Connection con;
    Statement stmt;
    ResultSet rst;
    ImageIcon Home;
    
 Font f,ft;
 Cursor cur; 
 String stations[]={"Lodhran", "Gogran", "Sui_Wala", "Permat", "Dhanot", "Gely_Wal", "Dunya_Pur", "Jalla_Arain", "Kehroor_Pakka", "Bahawalpur"};
     Employee_Search()
 {
     //Cursor
     cur= new Cursor(Cursor.HAND_CURSOR);
     color= new Color(0,192,255);
 f=new Font("Calibri",Font.BOLD+Font.ITALIC,30);
 ft=new Font("Calibri",Font.BOLD+Font.ITALIC,18);    //Adding Panel
    p1 = new JPanel();
    p1.setLayout(null);
    p1.setBounds(0,0,600,70);
    p1.setBackground(color);
    add(p1);
 title=new JLabel("Employee Search");
 title.setFont(f);
 title.setBounds(40,25,250,30);
 p1.add(title);
 //Label
 l1=new JLabel("Search Stations");
 l1.setBounds(50,90,130,25);
 l1.setFont(ft);
 add(l1);

  //combo Box
 stat=new JComboBox(stations);
 stat.setBounds(220,90,150,25);
 stat.addItemListener(this);
 add(stat);
 
//Adding Search Button
 
search=new JButton("Search");
 search.setBounds(420,90,80,25);
 search.setCursor(cur);
 add(search);
search.addActionListener(this);
        //Back Button
 Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(530, 515);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
//Panel2 Here
    p2=new JPanel();
 p2.setLayout(null);
    p2.setBounds(0,130,600,40);
    p2.setBackground(color);
    add(p2);
 //Adding Labels in JPanel2 
    l2=new JLabel("Name");
l2.setBounds(60,10,100,20);
l2.setFont(ft);
p2.add(l2);

 l3=new JLabel("Contact No");
l3.setBounds(260,10,100,20);
l3.setFont(ft);
p2.add(l3);

 l4=new JLabel("Station");
l4.setBounds(460,10,100,20);
l4.setFont(ft);
p2.add(l4);
 
    //Adding TextArea 
    t1=new JTextArea();
    
    t1.setBounds(0,170,200,400);
    add(t1);
    
    t2=new JTextArea();
    t2.setBounds(201,170,200,400);
    add(t2);
    
    t3=new JTextArea();
    t3.setBounds(402,170,200,400);
    add(t3);

 
 //Creating Connection With DataBAse
     
//Frame 
setSize(600, 600);
setResizable(false);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

}
 
     //Button Action Here
public void actionPerformed(ActionEvent e)
{
    if (e.getSource()==search)
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
     try {
         int i=0;
    String db = "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan_Data.accdb";
    con=DriverManager.getConnection(db);
    stmt=con.createStatement();
    String Query="select * from "+stat.getSelectedItem();
    rst= stmt.executeQuery(Query);
    while(rst.next())
    {
        i++;
    t1.append("    "+rst.getString("First Name")+" "+rst.getString("Last Name"));
    t2.append("                  "+rst.getString("Contact No"));
    t3.append("                  "+rst.getString("Stations"));
    t1.append("\n");
    t2.append("\n");
    t3.append("\n");
    }
    stmt.close();
    rst.close();
    if(i==0)
    {
                        JOptionPane.showMessageDialog(null, "No Any Employee For This Station");

    }
     }
     catch (Exception exc)
     {
         JOptionPane.showMessageDialog(null,exc.getMessage());
     }
    }
    else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Setting();
        }
        
}
    public void itemStateChanged(ItemEvent ie) {
     t1.setText("");
    t2.setText("");
    t3.setText("");
    }
}