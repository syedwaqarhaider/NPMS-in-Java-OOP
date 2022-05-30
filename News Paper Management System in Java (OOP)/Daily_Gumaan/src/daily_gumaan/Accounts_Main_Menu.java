

package daily_gumaan;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Accounts_Main_Menu extends JFrame implements ActionListener
{
  JLabel title,lbl1, lbl2, lbl3, lbl4,lblimg1, lblimg2, lblimg3, lblimg4;
  JButton b1,b2,b3,b4, lblHome;
  JPanel p1;
    Color color;
    Font f, f2;
    ImageIcon circulation,advertisement,Misce,Remaing, Home;
    
    Cursor cur;
Accounts_Main_Menu()
{
color= new Color(0,192,255);
 f=new Font("Calibri",Font.BOLD+Font.ITALIC,30);
     //Adding Panel
    p1 = new JPanel();
    p1.setLayout(null);
    p1.setBounds(0,0,600,70);
    p1.setBackground(color);
    add(p1);
    title=new JLabel("Accounts Management");
 title.setFont(f);
 title.setBounds(40,25,350,35);
 p1.add(title);
 //Labels
 f2=new Font("Calibri",Font.PLAIN,16);
 lbl1= new JLabel("Manage Circulation");
        lbl2= new JLabel("Manage Advertisements");
        lbl3= new JLabel("Miscelleneous Income & Expenses");
        lbl4= new JLabel("Remaing Bills");
        //Label Location + Size
        lbl1.setFont(f2);
        lbl1.setSize(150, 30);
        lbl1.setLocation(80, 230);
        lbl2.setFont(f2);
        lbl2.setSize(170, 30);
        lbl2.setLocation(270, 230);
        lbl3.setFont(f2);
        lbl3.setSize(230, 20);
        lbl3.setLocation(30, 420);
        lbl4.setFont(f2);
        lbl4.setSize(150, 20);
        lbl4.setLocation(300, 420);
     //Adding Labels
    add(lbl1);
    add(lbl2);
    add(lbl3);
    add(lbl4);
    //Buttons
    cur= new Cursor(Cursor.HAND_CURSOR);
    circulation= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Circulation_Account.png");
    b1=new JButton(circulation);
    b1.setCursor(cur);
    b1.setBounds(80,100,circulation.getIconWidth(),circulation.getIconHeight());
    b1.addActionListener(this);
    add(b1);
    //Home Button
            Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Home.png");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(430, 430);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
    advertisement= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Advertisement_Accounts.png");
    b2=new JButton(advertisement);
    b2.setBounds(280,100,advertisement.getIconWidth(),advertisement.getIconHeight());
    b2.setCursor(cur);
     b2.addActionListener(this);
    add(b2);

    Misce= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Miscelleneous Accounts.png");
    b3=new JButton(Misce);
    b3.setBounds(80,280,Misce.getIconWidth(),Misce.getIconHeight());
    b3.setCursor(cur);
     b3.addActionListener(this);
    add(b3);

        Remaing= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Remaining Bills.png");
    b4=new JButton(Remaing);
    b4.setBounds(280,280,Remaing.getIconWidth(),Remaing.getIconHeight());
    b4.setCursor(cur);
     b4.addActionListener(this);
    add(b4);
    
    //Frame 
setSize(500, 530);
setResizable(false);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b1)
    {
        this.setVisible(false);
        new Circulation_Accounts();
    }
    else if(e.getSource()==b2)
    {
        this.setVisible(false);
       new Advertisement_Management();
    }
        else if(e.getSource()==b3)
    {
        this.setVisible(false);
       new Miscellaneous_Accounts();
    }
        else if(e.getSource()==b4)
    {
        this.setVisible(false);
       new Remaining_Bills();
    }
        else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Main_Screen();
        }
}
}
