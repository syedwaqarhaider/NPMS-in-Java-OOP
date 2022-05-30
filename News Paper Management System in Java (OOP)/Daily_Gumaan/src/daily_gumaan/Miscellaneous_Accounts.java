

package daily_gumaan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Miscellaneous_Accounts extends JFrame implements ActionListener, ItemListener{
    
    
    JPanel lbl,lbl2;
    Font f,f1;
    Color color;
     JLabel l1, l2,l3,l4,l5,l6, lbldetail;
     JTextArea a1,a2,a3;
     JButton b, lblHome;
     Cursor cur; 
     Connection con;
     Statement s;
     ResultSet rs;
     JComboBox detail, month, year;
     ImageIcon Home;
    Miscellaneous_Accounts(){
        setVisible(true);
        setLayout(null);
        setSize(600,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Container x=frame.getContentPane();
        cur= new Cursor(Cursor.HAND_CURSOR);
        lbl=new JPanel();
        lbl.setLayout(null);
        lbl.setSize(800,70);
        
        color=new Color(0,192,255);
        lbl.setBackground(color);       
        f=new Font("Calibiri",Font.BOLD+Font.ITALIC,30);
        f1=new Font("Calibiri",Font.ITALIC,20);
        l2=new JLabel("Miscellaneous Accounts");
        l2.setSize(500,40);
        l2.setLocation(20, 10);
        l2.setFont(f);
        l2.setForeground(Color.BLACK);
        
        lbl2=new JPanel();
        lbl2.setLayout(null);
        lbl2.setSize(800,50);
        color=new Color(0,192,255);
        lbl2.setBackground(color);
        
        l1=new JLabel("Search For");
        lbldetail=new JLabel("Details");
        l4=new JLabel("Amount");
        l5=new JLabel("Source Income");
        l6=new JLabel("Date");
        a1=new JTextArea();
        a2=new JTextArea();
        a3=new JTextArea();
        b=new JButton("Search");
        b.setCursor(cur);
        b.addActionListener(this);
        //Back Button
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(525, 605);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
        
        
        
         month= new JComboBox();
        detail= new JComboBox();
        
        detail.addItem("Income");
        detail.addItem("Expenses");
        detail.addItemListener(this);
        String Year[]= new String [21];
        
        for (int i=2010; i<=2030; i++)
        {
        Year[i-2010]=Integer.toString(i);
        
        }
       year = new JComboBox(Year);
        
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
        year.addItemListener(this);
        month.addItemListener(this);
        
        l1.setSize(100,20);
        l1.setLocation(60,100);
        month.setSize(60,20);
        month.setLocation(130,100);
        year.setSize(60,20);
        year.setLocation(195,100);
        detail.setSize(100,20);
        detail.setLocation(380,100);
        
        b.setSize(100,20);
        b.setLocation(250,150);
        lbl2.setLocation(0,200);
        l4.setSize(100,30);
        l4.setLocation(40,10);
        l5.setSize(150,30);
        l5.setLocation(240,10);
        l6.setSize(100,30);
        l6.setLocation(470,10);
        l4.setFont(f1);
        l4.setForeground(Color.BLACK);
        l5.setFont(f1);
        l5.setForeground(Color.BLACK);
        l6.setFont(f1);
        l6.setForeground(Color.BLACK);
        a1.setSize(200,700);
        a1.setLocation(0,250);
        a2.setSize(200,700);
        a2.setLocation(201,250);
        a3.setSize(200,700); 
        a3.setLocation(402,250);
        lbldetail.setSize(100, 20);
        lbldetail.setLocation(320, 100);
        add(lbl2);
        lbl.add(l2);
        add(lbl);
        add(l1);
        add(year);
        add(month);
        add(detail);
        add(lbldetail);
        add(b);
        lbl2.add(l4);
        lbl2.add(l5);
        lbl2.add(l6);
        add(a1);
        add(a2);
        add(a3);
       // frame.getContentPane().add(month);
        //frame.getContentPane().add(year);
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b)
        {
               a1.setText("");
            a2.setText("");
            a3.setText("");
            int i=0;
            try
            {
                String db="jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Daily_Gumaan Confidential.accdb";
                con = DriverManager.getConnection(db);
                s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
                String Query= "select * from M_"+detail.getSelectedItem();
                rs= s.executeQuery(Query);
                while(rs.next())
                {
                    if(month.getSelectedItem().equals(rs.getString("Month")) && year.getSelectedItem().equals(rs.getString("Year")))
                    {
                        i++;
                        a1.append("    "+Integer.toString(rs.getInt("Amount")));
                    a2.append("    "+rs.getString("Source Of Income"));
                    a3.append("     "+rs.getString("Day"));
                    a3.append("/");
                    a3.append(rs.getString("Month"));
                    a3.append("/");
                    a3.append(rs.getString("Year"));
                    a1.append("\n");
                    a2.append("\n");
                    a3.append("\n");
                    }
                }
                if(i==0)
                {
                    JOptionPane.showMessageDialog(null, "No Record Founded");
                }
                con.close();
            }
            catch(Exception r)
            {
                JOptionPane.showMessageDialog(null, r.getMessage());
            }
        }
        else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Accounts_Main_Menu();
        }
    }

 
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==month || ie.getSource()==year || ie.getSource()==detail)
        {
            a1.setText("");
            a2.setText("");
            a3.setText("");
        }
    }
         

}
