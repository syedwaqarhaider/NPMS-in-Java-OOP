
package daily_gumaan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Remaining_Bills extends JFrame implements ActionListener , ItemListener{

	JButton b1, lblHome, search;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10, lblAdds;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	//TextArea ta;
	String Year[]= {"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	String Month[]= {"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
	String Advertisement[]= {"Advertisement","Circulation"};
	JPanel p1;
	JComboBox month, year, advertisement, circulation, Adds_ID;
        ImageIcon Home;
        Cursor cur;
        Connection con;
        Statement s;
        ResultSet rs;
	
	Remaining_Bills()
        {
            cur= new Cursor(Cursor.HAND_CURSOR);
		b1= new JButton("PAY");
                b1.setCursor(cur);
		p1=new JPanel();
		//Adds_ID
                Adds_ID=new JComboBox();
               
		month = new JComboBox(Month);
                month.setCursor(cur);
		year = new JComboBox(Year);
                year.setCursor(cur);
                year.addItemListener(this);
		advertisement= new JComboBox(Advertisement);
                advertisement.addItemListener(this);
		advertisement.setCursor(cur);
		b1= new JButton("Pay");
		l1= new JLabel("Remaining Bills");
		l2= new JLabel("Pay for");
		l3= new JLabel("Paying Month");
		l4= new JLabel("Total");
		l5= new JLabel("Paid");
		l6= new JLabel("Remaining");
		l7= new JLabel("Pay Your Remaining Dues");
		l8= new JLabel("Pay Amount (Rs)");
		l9= new JLabel("Remaining");
		
		t1= new JTextField();
		t2= new JTextField();
		t3= new JTextField();
		t4= new JTextField();
		t5= new JTextField();
		t6= new JTextField();
		t7= new JTextField();
		t8= new JTextField();
		t9= new JTextField();
		//Search Button
                search= new JButton("Search");
                search.setSize(100, 20);
                search.setLocation(400, 150);
                search.setCursor(cur);
                search.addActionListener(this);
                add(search);
		setLayout(null);
		p1.setBounds(0,0,650,70);
		add(p1).setBackground(new Color(0,192,255));
		p1.setLayout(null);
                	l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Calibri",Font.BOLD+Font.ITALIC,30));
		p1.add(l1).setBounds(30,30,250,30);
		//Back Button
                 //Back Buttons
 Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(580, 310);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
	
		add(l2).setBounds(80,100,50,20);
		add(l3).setBounds(300,100,120,20);
		lblAdds= new JLabel("ID/Employee Name");
                add(lblAdds).setBounds(80, 150, 150, 20);
                add(Adds_ID).setBounds(190, 150, 150, 20);
		add(l4).setBounds(80, 200, 70, 20);
                t4.setEditable(false);
		add(t4).setBounds(170, 200, 120, 20);
		
		add(l5).setBounds(80, 230, 70, 20);
                t5.setEditable(false);
		add(t5).setBounds(170, 230, 130, 20);
                
		
		add(l6).setBounds(330,200,70,20 );
                t6.setEditable(false);
		add(t6).setBounds(410,200,120,20);
                l7.setForeground(Color.blue);
		add(l7).setBounds(200,250,250,20 );
		l7.setFont(new Font("Calibiri",Font.BOLD+Font.ITALIC,16));
		add(l8).setBounds(80,280,120,20 );
		add(t8).setBounds(210,280,120,20);
		add(l9).setBounds(350,280,70,20 );
		add(t9).setBounds(430,280,120,20);
                t9.setEditable(false);
		
		//add(ta).setBounds(850, 50, 300, 25i0);
        
        add(month).setBounds(405,100,50,20);
        add(year).setBounds(460,100,70,20);
        add(advertisement).setBounds(150,100,120,20);
        //add(ta);
        add(b1);
        add(b1).setBounds(265, 320, 70, 20);
        b1.addActionListener(this);
        setSize(650, 400);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
        
        
        
   public void itemStateChanged(ItemEvent ee)
   {
       if(ee.getSource()==year)
       {
           t4.setText("");
           t5.setText("");
           t6.setText("");
           
           Adds_ID.removeAllItems();
           if(advertisement.getSelectedItem().equals("Advertisement"))
           {
               int i=0;
               try
               {
                   
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement_Accounts";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        if(rs.getInt("Remaining")>0)
                        {
                            i++;
                        Adds_ID.addItem(rs.getString("Advertisement ID"));
                        }
                    }
                }
                if(i==0)
                {
                    JOptionPane.showMessageDialog(null, "Remaining Not Found");
                }
                s.close();
                rs.close();
                con.close();
               }
               catch(Exception y)
               {
                   JOptionPane.showMessageDialog(null, y.getMessage());
               }
           }
           else if(advertisement.getSelectedItem().equals("Circulation"))
           {
               try
               {
                   int i=0;
                   
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Circulation_Accounts";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        if(rs.getInt("Remaining")>0)
                        {
                            i++;
                        Adds_ID.addItem(rs.getString("Employee"));
                        }
                    }
                }
                   if(i==0)
                {
                    JOptionPane.showMessageDialog(null, "Remaining Not Found");
                }
                s.close();
                rs.close();
                con.close();
               }
               catch(Exception i)
               {
                   JOptionPane.showMessageDialog(null, i.getMessage());
               }
           }
       }
       else if(ee.getSource()==advertisement)
       {
           t4.setText("");
           Adds_ID.removeAllItems();
           t5.setText("");
           t6.setText("");
           t8.setText("");
           t9.setText("");
       }
       
   }

 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==b1)
        {
          if(t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null, "Fill All The Fields");
          }
          else if(t8.getText().equals(""))
                  {
                      JOptionPane.showMessageDialog(null, "Pay Amount First");  
                  }
          else 
          {
              int Repay=0, getremain=0, remain=0;
              try
              {
                  Integer.parseInt(t8.getText());
              }
              catch(Exception r)
              {
                  JOptionPane.showMessageDialog(null, "Check Pay Amount Field");
              }
              Repay=Integer.parseInt(t8.getText());
              getremain=Integer.parseInt(t6.getText());
              remain=getremain-Repay;
              t9.setText(Integer.toString(remain));
              t9.setForeground(Color.RED);
              if(advertisement.getSelectedItem().equals("Advertisement"))
              {
                  try
              {
                   String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement_Accounts";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(Adds_ID.getSelectedItem().equals(rs.getString("Advertisement ID")) && month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        rs.updateInt("Paid", rs.getInt("Paid")+Repay);
                        rs.updateInt("Remaining", remain);
                        break;
                    }
                }
                rs.updateRow();
                s.close();
                rs.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Your Amount Has Been Paid");
              }
              catch(Exception t)
              {
                  JOptionPane.showMessageDialog(null, t.getMessage());
              }
              }
              else if(advertisement.getSelectedItem().equals("Circulation"))
              {
                  try
              {
                   String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
               String Query= "select * from Circulation_Accounts";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(Adds_ID.getSelectedItem().equals(rs.getString("Employee")) && month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        rs.updateInt("Paid", rs.getInt("Paid")+Repay);
                        rs.updateInt("Remaining", remain);
                        break;
                    }
                }
                rs.updateRow();
                s.close();
                rs.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Your Amount Has Been Paid");
              }
              catch(Exception t)
              {
                  JOptionPane.showMessageDialog(null, t.getMessage());
              }
              }
              
          }
        }
        else if(ae.getSource()==search)
        {
          
           if(advertisement.getSelectedItem().equals("Advertisement"))
           {
               try
               {
                   t4.setText("");
                   t5.setText("");
                   t6.setText("");
                   int i=0;
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Advertisement_Accounts";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        if(Adds_ID.getSelectedItem().equals(rs.getString("Advertisement ID")))
                        {
                            i++;
                           t4.setText(Integer.toString(rs.getInt("Without Comission")));
                           t5.setText(Integer.toString(rs.getInt("Paid")));
                           t6.setText(Integer.toString(rs.getInt("Remaining")));
                        }
                    }
                }
                if(i>0)
                {
                    t6.setBackground(Color.GREEN);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Record Not Found");
                }
                s.close();
                rs.close();
                con.close();
               }
               catch(Exception y)
               {
                   JOptionPane.showMessageDialog(null, y.getMessage());
               }
           }
           else if(advertisement.getSelectedItem().equals("Circulation"))
           {
               try
               {
                   t4.setText("");
                   t5.setText("");
                   t6.setText("");
                   int i=0;
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from Circulation_Accounts";
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        if(Adds_ID.getSelectedItem().equals(rs.getString("Employee")))
                        {
                            i++;
                                t4.setText(Integer.toString(rs.getInt("Amount")));
                           t5.setText(Integer.toString(rs.getInt("Paid")));
                           t6.setText(Integer.toString(rs.getInt("Remaining")));
                        }
                    }
                }
                if(i>0)
                {
                    t6.setBackground(Color.GREEN);
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Record Not Found");  
                }
                s.close();
                rs.close();
                con.close();
               }
               catch(Exception i)
               {
                   JOptionPane.showMessageDialog(null, i.getMessage());
               }
           }   
        }
        else if(ae.getSource()==lblHome)
        {
            this.setVisible(false);
            new Accounts_Main_Menu();
        }
    }

    

 
}


