/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_gumaan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Setting extends JFrame implements ActionListener {
    JPanel panel;
    Color color;
    Font f, f2;
    JLabel lblTitle;
    JButton btnimg1, btnimg2, btnimg3, btnimg4, lblHome;
    Container c;
    ImageIcon img1, img2, img3, img4, Home;
    JLabel lbl1, lbl2, lbl3, lbl4;
    Cursor cur;
    Setting()
    {
        //Cursor
        cur= new Cursor(Cursor.HAND_CURSOR);
        
          //Container
        c= this.getContentPane();
        //Buttons Name
        f2= new Font("Clibiri", Font.PLAIN, 16);
        lbl1= new JLabel("Add Employee");
        lbl1.setSize(150, 20);
        lbl1.setLocation(120, 235);
        lbl1.setFont(f2);
        c.add(lbl1);
         lbl2= new JLabel("Delete Employee");
        lbl2.setSize(150, 20);
        lbl2.setLocation(285, 235);
        lbl2.setFont(f2);
        c.add(lbl2);
         lbl3= new JLabel("Delete Administrators");
        lbl3.setSize(200, 20);
        lbl3.setLocation(107, 400);
        lbl3.setFont(f2);
        c.add(lbl3);
         lbl4= new JLabel("Search Employee");
        lbl4.setSize(200, 20);
        lbl4.setLocation(285, 400);
        lbl4.setFont(f2);
        c.add(lbl4);
        //Images
        img1= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Add Members.png");
        img2= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Delete Member.png");
        img3= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Delete Account.png");
        img4= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Search_Employee.png");
       // Button as image
        btnimg1= new JButton(img1);
        btnimg1.setSize(img1.getIconWidth(), img1.getIconHeight());
        btnimg1.setLocation(110, 100);
        btnimg1.setCursor(cur);
        btnimg1.addActionListener(this);
        c.add(btnimg1);
        btnimg2= new JButton(img2);
          btnimg2.setSize(img2.getIconWidth(), img2.getIconHeight());
        btnimg2.setLocation(280, 100);
        btnimg2.setCursor(cur);
        btnimg2.addActionListener(this);
        c.add(btnimg2);
       btnimg3= new JButton(img3);
          btnimg3.setSize(img3.getIconWidth(), img3.getIconHeight());
        btnimg3.setLocation(110, 265);
        btnimg3.setCursor(cur);
        btnimg3.addActionListener(this);
        c.add(btnimg3);
        
         btnimg4= new JButton(img4);
          btnimg4.setSize(img4.getIconWidth(), img4.getIconHeight());
        btnimg4.setLocation(280, 265);
        btnimg4.setCursor(cur);
        btnimg4.addActionListener(this);
        c.add(btnimg4);
       // Color
        color= new Color(0, 192, 255);
        //Home
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Home.png");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(480, 390);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
add(lblHome);
      
        //Panels
        panel= new JPanel();
        panel.setSize(700, 70);
        panel.setLocation(0,0);
        panel.setLayout(null);
        panel.setBackground(color);
        c.add(panel);
        //Font
        f= new Font("Calibari", Font.BOLD+Font.ITALIC, 30);
        //Label
        lblTitle=new JLabel("Settings");
        lblTitle.setSize(150, 35);
        lblTitle.setLocation(40, 25);
        lblTitle.setFont(f);
        panel.add(lblTitle);
        
     //Frame 
     setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       setSize(550, 480);
        setResizable(false);
        setLayout(null);
        setTitle("Newspaper Management System");
         setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnimg1)
        {
           this.setVisible(false);
         new Add_Employee();   
            
        }
        else if (e.getSource()==btnimg2)
        {
            this.setVisible(false);
            new Delete_Employee();
        }
        else if (e.getSource()==btnimg3)
        {
            this.setVisible(false);
            new DeleteLogin();
        }
         else if (e.getSource()==btnimg4)
        {
            this.setVisible(false);
           new Employee_Search();
        }
        else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Main_Screen();
        }
    }
}
