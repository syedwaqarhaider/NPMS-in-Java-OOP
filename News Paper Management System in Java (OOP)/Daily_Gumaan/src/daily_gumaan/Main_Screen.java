/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_gumaan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main_Screen extends JFrame  implements ActionListener{
    private JPanel p1;
    private JLabel lblTitle;
    Font f, f2;
    Container c;
    Color color, color2, co;
    Cursor cur;
    ImageIcon img,circulation, Adds, Income, Expenses, Accounts, Setting;
    JLabel img1,  lbl1, lbl2, lbl3, lbl4a,lbl4b, lbl5a, lbl5b, lbl6;
    JButton img2, img3, img4, img5, img6, img7;
    Main_Screen()
    {
        setTitle("Newspaper Management System");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        c=this.getContentPane();
         cur= new Cursor(Cursor.HAND_CURSOR);
         co = new Color(128, 128, 128, 10);
        setLayout(null);
        setResizable(false);
        setSize(745,490);
       img = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Gumaan.jpg");
       img1=new JLabel(img);
       img1.setSize( img.getIconWidth(), img.getIconHeight());
       img1.setLocation(600, 15);
       circulation = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\circulation.png");
       //Circulation Button
       img2=new JButton(circulation);
       img2.setSize( circulation.getIconWidth(), circulation.getIconHeight());
       img2.setLocation(120, 100);
       img2.setCursor(cur);
       img2.addActionListener(this);
       
       //Advertisement Button
        Adds = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Ads.png");
       img3=new JButton(Adds);
       img3.setSize(Adds.getIconWidth(), Adds.getIconHeight());
       img3.setLocation(270, 100);
       img3.setCursor(cur);
       img3.addActionListener(this);
       //Accounts Button
       Accounts = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Accounts.png");
       img4=new JButton(Accounts);
       img4.setSize( Accounts.getIconWidth(), Accounts.getIconHeight());
       img4.setLocation(440, 100);
       img4.setCursor(cur);
       img4.addActionListener(this);
       //Income Button
        Income = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\incom.png");
       img5=new JButton(Income);
       img5.setSize( Income.getIconWidth(), Income.getIconHeight());
       img5.setLocation(120, 260);
       img5.setCursor(cur);
       img5.addActionListener(this);
       //Expenses Button
         Expenses= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Expenses.png");
       img6=new JButton(Expenses);
       img6.setSize( Expenses.getIconWidth(), Expenses.getIconHeight());
       img6.setLocation(270, 260);
       img6.setCursor(cur);
       img6.addActionListener(this);
       //Setting Button
         Setting= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Setting.png");
       img7=new JButton(Setting);
       img7.setSize(Setting.getIconWidth(), Setting.getIconHeight());
       img7.setLocation(440, 260);
       img7.setCursor(cur);
       img7.addActionListener(this);
       lblTitle = new JLabel("Daily Gumaan ");
        lblTitle.setForeground(Color.BLACK);
        color = new Color(0, 192, 255);
        color2 = new Color(160, 160, 160, 40);
        
        
         f2= new Font("Clibiri", Font.PLAIN, 16);
        
        p1= new JPanel();
       p1.setLayout(null);
        p1.setSize(800, 70);
        p1.setLocation(0, 0);
        p1.setBackground(color);
        c.add(p1);
        lblTitle.setSize(300, 40);
        lblTitle.setLocation(50, 20);
        f=new Font("Cilibiri",Font.ITALIC+Font.BOLD, 30);
        lblTitle.setFont(f);
        lbl1= new JLabel("Circulation");
        lbl2= new JLabel("Advertisements");
        lbl3= new JLabel("Accounts");
        lbl4a= new JLabel("Miscelleneous");
        lbl4b= new JLabel("Income");
        lbl5a= new JLabel("Miscelleneous");
        lbl5b= new JLabel("Expenses");
        lbl6= new JLabel("Settings");
        lbl1.setSize(150, 20);
        lbl1.setLocation(145, 230);
        lbl1.setFont(f2);
        lbl2.setSize(150, 20);
        lbl2.setLocation(280, 230);
        lbl2.setFont(f2);
        lbl3.setSize(150, 20);
        lbl3.setLocation(470, 230);
        lbl3.setFont(f2);
        lbl4a.setSize(150, 20);
        lbl4a.setLocation(130, 400);
        lbl4a.setFont(f2);
        lbl4b.setSize(150, 20);
        lbl4b.setLocation(148, 420);
        lbl4b.setFont(f2);
        
          lbl5a.setSize(150, 20);
        lbl5a.setLocation(285, 400);
        lbl5a.setFont(f2);
        lbl5b.setSize(150, 20);
        lbl5b.setLocation(300, 420);
        lbl5b.setFont(f2);
        lbl6.setSize(150, 20);
        lbl6.setLocation(470, 400);
        lbl6.setFont(f2);
        c.add(lbl6);
        c.add(lbl5a);
        c.add(lbl5b);
        c.add(lbl4b);
        c.add(lbl4a);
        c.add(lbl3);
        c.add(lbl2);
        c.add(lbl1);
        p1.add(lblTitle);
        p1.add(img1);
        c.add(img2);
        c.add(img3);
        c.add(img4);
        c.add(img5);
        c.add(img6);
        c.add(img7);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==img2)
        {
            this.setVisible(false);
           new Circulation();
        }
        else if (e.getSource()==img3)
        {
            this.setVisible(false);
           new Advertisement();
        }
        else if (e.getSource()==img4)
        {
            this.setVisible(false);
           new Accounts_Main_Menu();
        }
        else if (e.getSource()==img5)
        {
            this.setVisible(false);
           new Miscellaneous_Income();
        }
        else if (e.getSource()==img6)
        {
            this.setVisible(false);
            new Miscelleneous_Expenses();
        }
         else if (e.getSource()==img7)
        {
            this.setVisible(false);
            new Setting();
        }
        
    }

    }

   
    
    
