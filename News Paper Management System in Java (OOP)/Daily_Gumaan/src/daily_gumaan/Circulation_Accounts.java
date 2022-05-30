package daily_gumaan;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Circulation_Accounts extends JFrame implements ItemListener,ActionListener 
{
Connection con;
Statement stmt;
ResultSet rst;    
JComboBox stat,emp,day,month,year;
Color color;
Font f,f2;
JLabel title,st,l2,dt,sch,l3,l4,l5,l6,l7;
JTextField t1,t2,t3,t4;
JPanel p1;
String employees;
JButton pay,search;
String Day[]=new String[31];;
String Month[] = {"Jan", "Feb","March", "April","May","June","July","Aug","Sept","Oct", "Nov","Dec"};
String Year1[]=new String[21];
String stations[]={"Lodhran", "Gogran", "Sui_Wala", "Permat", "Dhanot", "Gely_Wal", "Dunya_Pur", "Jalla_Arain", "Kehroor_Pakka", "Bahawalpur"};
ImageIcon Home;
JButton lblHome;
Cursor cur;
Circulation_Accounts()
{
    cur= new Cursor(Cursor.HAND_CURSOR);
 color= new Color(0,192,255);
 f=new Font("Calibri",Font.BOLD+Font.ITALIC,30);
 f2=new Font("Calibri",Font.ITALIC+Font.BOLD,20);
 //Adding Panel
    p1 = new JPanel();
    p1.setLayout(null);
    p1.setBounds(0,0,800,70);
    p1.setBackground(color);
    add(p1);
    title=new JLabel("Circulation Accounts");
    title.setFont(f);
    title.setBounds(40,25,350,30);
    p1.add(title);   
 
    //Label
    
 sch=new JLabel("Search For");
 sch.setBounds(60,90,100,25);
 add(sch);

 st=new JLabel("Stations");
 st.setBounds(290,90,70,25);
 add(st);
 l2=new JLabel("Employees");
 l2.setBounds(460,90,70,25);
 add(l2);   
 
 l3=new JLabel("Total No Of NewsPaper");
 l3.setBounds(80,200,150,25);
 add(l3);   
 
 l4=new JLabel("Total Price");
 l4.setBounds(400,200,120,25);
 add(l4);   
 
 
 l5=new JLabel("Pay Your Dues ");
 l5.setFont(f2);
 l5.setForeground(Color.BLUE);
 l5.setBounds(280,250,150,20);
 add(l5);   
 
 l6=new JLabel("Pay Amount");
 l6.setBounds(80,300,150,25);
 add(l6);   

 l7=new JLabel("Remaining Amount");
 l7.setBounds(370,300,150,25);
 add(l7);   
 
    //TextFields
 
 t1=new JTextField();
 t1.setBounds(250,200,120,25);
 t1.setEditable(false);
 add(t1);   
 
 
 t2=new JTextField();
 t2.setBounds(485,200,120,25);
 t2.setEditable(false);
 add(t2);   
 
 
 t3=new JTextField();
 t3.setBounds(200,300,120,25);
 //t3.setEditable(false);
 add(t3);   
 
 
 t4=new JTextField();
 t4.setBounds(500,300,120,25);
  t4.setEditable(false);
 add(t4);
 //combo Box
    stat=new JComboBox(stations);
    stat.setCursor(cur);
    stat.setBounds(350,90,100,25);
    stat.addItemListener(this);
    add(stat);
    
 emp=new JComboBox();
 emp.setBounds(530,90,100,25);
 emp.setCursor(cur);
 emp.addItemListener(this);
 add(emp); 
//Buttons
 
 search=new JButton("Search");
 search.setBounds(300,140,80,25);
 search.setCursor(cur);
  search.addActionListener(this);
 add(search);
 pay=new JButton("Pay");
 pay.setBounds(300,350,80,25);
 pay.setCursor(cur);
 pay.addActionListener(this);
 add(pay);
 //Back Buttons
 Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(690, 360);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
 
 //Combo Box Functionality Day
 /*
 for(int j=1;j<=31;++j)
 {
 
 Day[j-1]=Integer.toString(j);
 }
 */
 
 //Combo Box Functionality Year
 for(int i=2010;i<=2030;++i)
 {
 Year1[i-2010]=Integer.toString(i);
 }
 //day=new JComboBox(Day);
 month=new JComboBox(Month);
 year=new JComboBox(Year1);
 month.addItemListener(this);
 year.addItemListener(this);
 month.setCursor(cur);
 year.setCursor(cur);
 //SetBounds ComboBox
 //day.setBounds(200,90,40,25);
 month.setBounds(150,90,50,20);
 year.setBounds(205,90,60,20);
 
 //Adding JComboBox
 //add(day);
 add(month);
 add(year);
//Frame 
setSize(760, 450);
setResizable(false);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
 
}
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==search)
    {
        int i=0;
    try
    {
        
    int price=0, remain;
    int noOfNewsPaper=0;
        String st="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
    con=DriverManager.getConnection(st);
    stmt=con.createStatement();
    String query="select * from Circulation";
    rst=stmt.executeQuery(query);
    while(rst.next())
    {
        if(emp.getSelectedItem().equals(rst.getString("Employee"))&&month.getSelectedItem().equals(rst.getString("Month"))&&year.getSelectedItem().equals(rst.getString("Year")))
        {
            i++;
        price=price+rst.getInt("Price");
        noOfNewsPaper=noOfNewsPaper+rst.getInt("Newspaper Quantity");
        }
        
    }
    con.close();
    if(i==0)
    {
      JOptionPane.showMessageDialog(null, "Record Not Found");
    }
    else
    {
   t1.setText(Integer.toString(noOfNewsPaper));
    t2.setText(Integer.toString(price));
    }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
    else if(ae.getSource()==pay)
     {
         if(t1.getText().equals("")||t2.getText().equals(""))
         {
             JOptionPane.showMessageDialog(null, "Search Your Record Then Pay Amount");
         }
         else if(t3.getText().equals(""))
         {
             JOptionPane.showMessageDialog(null, "Enter Your Amount First");
         }
         else
         {
         int total=0;
         total=Integer.parseInt(t2.getText());
         int pay=0;
         int remaining=0;
         pay=Integer.parseInt(t3.getText());
         remaining=total-pay;
         t4.setText(Integer.toString(remaining));
         t4.setForeground(Color.RED);
         try
         {
           String st="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
    con=DriverManager.getConnection(st);
    stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    String query="select * from Circulation_Accounts";
    rst=stmt.executeQuery(query);
    rst.moveToInsertRow();
    rst.updateString("Station", (String)stat.getSelectedItem());
    rst.updateString("Employee", (String)emp.getSelectedItem());
    rst.updateInt("Number of Newspaper", Integer.parseInt(t1.getText()));
     rst.updateInt("Amount", Integer.parseInt(t2.getText()));
      rst.updateInt("Paid", Integer.parseInt(t3.getText()));
      
      rst.updateString("Month", (String)month.getSelectedItem());
      rst.updateString("Year", (String)year.getSelectedItem());
      if(remaining<0)
      {
       rst.updateInt("Remaining", 0);   
       JOptionPane.showMessageDialog(null, "Return "+remaining+" To Anchor");   
      }
      else
      {
          rst.updateInt("Remaining", Integer.parseInt(t4.getText()));
      }
      rst.insertRow();
      stmt.close();
      rst.close();
      JOptionPane.showMessageDialog(null, "Your Amount Has Been Paid");
         }
         catch(Exception r)
         {
             JOptionPane.showMessageDialog(null, r.getMessage());
         }
         }
     }
    else if(ae.getSource()==lblHome)
    {
        this.setVisible(false);
        new Accounts_Main_Menu();
    }

}
public void itemStateChanged(ItemEvent e)
{
     if(e.getSource()==stat)
     {
         t1.setText("");
         t2.setText("");
         t3.setText("");
         t4.setText("");
         
         int i=0;
         emp.removeAllItems();
try
    {
    String st="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan_Data.accdb";
    con=DriverManager.getConnection(st);
    stmt=con.createStatement();
    String qry="select * from "+stat.getSelectedItem();
    rst=stmt.executeQuery(qry);
    while(rst.next())
    {
        i++;
        emp.addItem(rst.getString("First Name")+" "+rst.getString("Last Name"));
    }
    con.close();
    if(i==0)
    {
        JOptionPane.showMessageDialog(null, "Record Not Found");
    }
    }
    catch(Exception eu)
    {
    JOptionPane.showMessageDialog(null, eu.getMessage());
}

     }
     else if(e.getSource()==emp || e.getSource()==month || e.getSource()== year)
        {
                t1.setText("");
         t2.setText("");
         t3.setText("");
         t4.setText("");
        
        }
     
         
         }
{
    
    
}
    
}