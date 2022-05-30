/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_gumaan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteLogin extends JFrame implements ActionListener{
    JPanel panel;
    Color color;
    Font f;
    JLabel lblTitle, lbl, lblP;
    JButton btndelete, lblHome;
   JTextField txt;
   JPasswordField txtP;
    Container c;
    JLabel lblimg;
    ImageIcon img, Home;
    Connection con;
    Statement s;
    ResultSet rs;
    Cursor cur;
    DeleteLogin()
    {
        cur= new Cursor(Cursor.HAND_CURSOR);
        c=this.getContentPane();
        //Image 
        img = new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Delete.png");
        lblimg= new JLabel(img);
        lblimg.setSize(img.getIconWidth(), img.getIconHeight());
        lblimg.setLocation(420, 90);
        c.add(lblimg);
        //Label
        lbl=new JLabel("Username*");
        lbl.setSize(100, 20);
        lbl.setLocation(70, 100);
        c.add(lbl);
         lblP=new JLabel("Password*");
        lblP.setSize(100, 20);
        lblP.setLocation(70, 130);
        c.add(lblP);
        //TextField 
        txt=new JTextField ();
        txt.setSize(150, 20);
        txt.setLocation(180, 100);
        c.add(txt);
         txtP=new JPasswordField ();
        txtP.setSize(150, 20);
        txtP.setLocation(180, 130);
        c.add(txtP);
           // Color
        color= new Color(0, 192, 255);
        //Button
        btndelete= new JButton("Delete");
        btndelete.setSize(70, 20);
        btndelete.setLocation(180, 180);
        btndelete.setCursor(cur);
        btndelete.addActionListener(this);
        c.add(btndelete);
               //Back Button
        Home= new ImageIcon("G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Back.jpg");
lblHome= new JButton(Home);
lblHome.setSize(Home.getIconWidth(), Home.getIconHeight());
lblHome.setLocation(10, 210);
lblHome.setCursor(cur);
lblHome.addActionListener(this);
c.add(lblHome);
        //Panels
        panel= new JPanel();
        panel.setSize(600, 70);
        panel.setLocation(0,0);
        panel.setLayout(null);
        panel.setBackground(color);
        c.add(panel);
         //Font
        f= new Font("Calibari", Font.BOLD+Font.ITALIC, 30);
        //Label
        lblTitle=new JLabel("Delete Login");
        lblTitle.setSize(250, 35);
        lblTitle.setLocation(40, 25);
        lblTitle.setFont(f);
        panel.add(lblTitle);
        //Frame 
        setTitle("Newspaper Management System");
       setSize(600, 300);
        setResizable(false);
        setLayout(null);
         setVisible(true);
         setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btndelete)
        {
            if (txt.getText().equals("") || txtP.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Fill All the Required Fields");
            }
            else
            {
                try
                {
                    String db= "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Login.accdb";
                    con=DriverManager.getConnection(db);
                    s= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String Query="select * from Login";
                    rs=s.executeQuery(Query);
                    int i=0;
                    while(rs.next())
                    {
                       
                        if(txt.getText().equals(rs.getString("Username")) && txtP.getText().equals(rs.getString("Password")))
                        {
                            i++;
                            rs.deleteRow();
                            s.close();
                            rs.close();
                            break;
                            
                        }
                        
                    }
                    if (i==0)
                    {
                         txt.setText(null);
                            txtP.setText(null);
                        JOptionPane.showMessageDialog(null, "This Username and Password Not Found");
                    }
                    else
                    {
                         txt.setText(null);
                            txtP.setText(null);
                        JOptionPane.showMessageDialog(null, "This Username and Password Deleted Successfully");
                    }
                }
                catch(Exception er)
                {
                   JOptionPane.showMessageDialog(null,er.getMessage());  
                }
            }
        }
        else if(e.getSource()==lblHome)
        {
            this.setVisible(false);
            new Setting();
        }
    }
    
}
