

package daily_gumaan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Circulation extends JFrame  implements ItemListener, ActionListener{
    JPanel p1;

	JLabel label,l1,l2,l3,l4,l5,l6,l7;
        

	JTextField t3,t4,t5,t6;

        JButton b1, lblHome;

	JComboBox month,year,day, t1, t2;
        String station[]={"Lodhran", "Gogran", "Sui_Wala", "Permat", "Dhanot", "Gely_Wal", "Dunya_Pur", "Jalla_Arain", "Kehroor_Pakka", "Bahawalpur"};

        String Year1[]=new String[21];

	String Day[]=new String[31];

	String Month[] = {"Jan", "Feb","March", "April","May","June","July","Aug","Sept","Oct", "Nov","Dec"};

        Color color;
        Connection con;
        Statement s;
        ResultSet rs;
        ImageIcon Home;
        Cursor cur;
    Circulation()
            
    {
        cur= new Cursor(Cursor.HAND_CURSOR);
        setTitle("Newspaper Management System");
          //Font

          Font f1=new Font("Calibri",Font.BOLD+Font.ITALIC,30);

            color= new Color(0, 192, 255);

            //JPanel Here

            p1 = new JPanel();

            p1.setLayout(null);

            p1.setBounds(0,0,700,70);

            p1.setBackground(color);

            add(p1);
           

        //Label in JPanel

            label= new JLabel("Circulation Details");

            label.setFont(f1);

            label.setBounds(60,25,350,50);

            p1.add(label);
//stations and Employees JComboBox

t1= new JComboBox(station);
t1.addItemListener(this);
t2= new JComboBox();
            
//Labels
	
	//l1= new JLabel("Circulation Details");

	l2= new JLabel("Stations");

	l3= new JLabel("Employees");

	l4= new JLabel("Newspapers Quantity");

        l5= new JLabel("Awarded Newspapers");

        l6= new JLabel("Charge per Newspapers");

        l7= new JLabel("Date");

     
//SetBounds Labels
	
//l1.setBounds(50,40,150,20);

l2.setBounds(45,110,150,20);

l3.setBounds(45,150,150,20);

l4.setBounds(45,190,150,20);

l5.setBounds(300,110,150,20);

l6.setBounds(300,150,150,20);

l7.setBounds(300,190,150,20);

//Adding Labels

//add(l1);

add(l2);

add(l3);

add(l4);

add(l5);

add(l6);

add(l7);

//TextFields

	t3= new JTextField();

	t4= new JTextField();

	t5= new JTextField();

	//t6= new JTextField();

//SetBounds TextFields
t1.setBounds(170,110,100,20);

t2.setBounds(170,150,100,20);

t3.setBounds(170,190,100,20);

t4.setBounds(450,110,140,20);

t5.setBounds(450,150,140,20);

//t6.setBounds(450,160,140,20);


//Adding TExtFields

add(t1);

add(t2);

add(t3);

add(t4);

add(t5);
//Home Button
Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Home.png");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(627, 247);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);

//Combo Box Functionality Day

        
        for(int j=1;j<=30;++j)

        {
            
Day[j-1]=Integer.toString(j);
        
}
  
      
        
//Combo Box Functionality Year
         
for(int i=2010;i<=2030;++i)

        {
           
 Year1[i-2010]=Integer.toString(i);

        }
        
day=new JComboBox(Day);

        month=new JComboBox(Month);

        year=new JComboBox(Year1);

        
//SetBounds ComboBox

//t6.setBounds(450,160,100,20);
        
day.setBounds(450,190,40,20);

month.setBounds(490,190,50,20);

year.setBounds(540,190,60,20);


//Adding JComboBox
        
add(day);
add(month);
add(year);

//Button

        b1= new JButton();
        b1.setBounds(270,230,70,25);
        b1.setText("Save");
        b1.setCursor(cur);
        b1.addActionListener(this);

        

//Adding Button

add(b1);

//Frame
setDefaultCloseOperation(this.EXIT_ON_CLOSE);
setLayout(null);

setVisible(true);

setSize(700,340);

setResizable(false);



    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource()==t1)
        {
            t2.removeAllItems();
            try
            {
                String Name=null;
                 int i=0;
            String db= "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan_Data.accdb";
            con= DriverManager.getConnection(db);
            s= con.createStatement();
            String Query="select * from "+(String)t1.getSelectedItem();
            rs= s.executeQuery(Query);
            while(rs.next())
            {
                i++;
                Name=rs.getString("First Name")+" "+rs.getString("Last Name");
                t2.addItem(Name);
                Name=null;
            }
            s.close();
            rs.close();
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
        if (ae.getSource()==b1)
        {
            int price=0;
                int Q_News=0, Ch_News, Awarded;
                
            if (t3.getText().equals("")|| t4.getText().equals("")|| t5.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill All the Fields");
            }
            else
            {
                
                try
                {
                    Q_News=Integer.parseInt(t3.getText());
                    Ch_News=Integer.parseInt(t5.getText());
                    price=Q_News*Ch_News;
                    Awarded= Integer.parseInt(t4.getText());
                }
                catch(Exception e)
                {
                  JOptionPane.showMessageDialog(null,"Take care Integer Fields");  
                }
                try 
                {
             String db= "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
            con= DriverManager.getConnection(db);
            s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String Query="select * from Circulation";
            rs= s.executeQuery(Query); 
            rs.moveToInsertRow();
            rs.updateString("Stations", (String)t1.getSelectedItem());
            rs.updateString("Employee", (String)t2.getSelectedItem());
            rs.updateInt("Newspaper Quantity", Integer.parseInt(t3.getText()));
            rs.updateInt("Awarded Newspaper", Integer.parseInt(t4.getText()));
            rs.updateInt("Charge Per Newspaper", Integer.parseInt(t5.getText()));
            rs.updateString("Day", (String)day.getSelectedItem());
            rs.updateString("Month", (String)month.getSelectedItem());
            rs.updateString("Year", (String)year.getSelectedItem());
            rs.updateInt("Price", price);
            rs.insertRow();
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            s.close();
            rs.close();
             con.close();
            
            System.out.println("JOption ");
            JOptionPane.showMessageDialog(null,"Record Has Been Saved");
            
                }
                catch(Exception et)
                {
                    JOptionPane.showMessageDialog(null,"Record Has Been Saved...");
                   System.out.println(et.getMessage());
                }
                    
            }
        }
        else if(ae.getSource()==lblHome)
        {
            this.setVisible(false);
            new Main_Screen();
        }
    }

    
    
}
