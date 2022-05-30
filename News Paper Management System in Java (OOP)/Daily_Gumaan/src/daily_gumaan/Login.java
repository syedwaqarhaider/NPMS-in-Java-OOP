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
public class Login extends JFrame implements ActionListener {
    ImageIcon img;
    Color color, color2;
    private JButton btn, btnCreate;
    private JLabel lblimage, lblTitle, lbluser, lblpass;
    private JLabel lblFName, lblSName, lblMail, lblPassword, lblCPass, lblSTitle, lblWarning;
    private JPanel panel, pane2;
    private javax.swing.JTextField txtuser, txtFName, txtSName, txtMail;
    JPasswordField txtpass,  txtPassword, txtCPass;
    Font f, f1, f2;
    Container c;
    Cursor cur;
    Connection con;
    Statement s;
    ResultSet rs;
    Login()
    {
        setTitle("Newspaper Management System");
         cur= new Cursor(Cursor.HAND_CURSOR);
       
      
        lblFName= new JLabel("First Name*");
        lblSName= new JLabel("Last Name*");
        lblMail= new JLabel("Username*");
        lblPassword= new JLabel("Password*");
        lblCPass= new JLabel("Confirm Password*");
        lblSTitle= new JLabel("Create New Account");
        lblWarning= new JLabel("Password doesn't match");
        txtFName= new JTextField();
        txtSName=new JTextField();
        txtMail=new JTextField();
        txtPassword=new JPasswordField(); 
        txtCPass=new JPasswordField();
        btn=new JButton ("Log In");
        btn.setCursor(cur);
        txtuser=new JTextField();
        txtpass = new JPasswordField();
        f=new Font("Cilibiri",Font.ITALIC+Font.BOLD, 30);
        f1=new Font("Cilibiri",Font.PLAIN, 16);
        f2=new Font("Cilibiri",Font.BOLD, 16);
        lblTitle =new JLabel("Gumaan Publications");
         lbluser =new JLabel("Username");
          lblpass =new JLabel("Password");
        color = new Color(255, 255, 255, 100);
        panel=new JPanel();
        pane2=new JPanel();
        lblimage =new JLabel();
        c=this.getContentPane();
        setLayout(null);
         img=new ImageIcon("\\G:\\Semester 2\\OOP In JAVA\\Project\\Logo\\Login.jpg");
        lblimage =new JLabel(img);
        setSize(852, 400);
        
        lblimage.setSize(img.getIconWidth(), img.getIconHeight());
        lblimage.setLocation(0, 0);
        btn.setSize(70, 20);
        btn.setLocation(710, 40);
        
        btn.addActionListener(this);
        panel.setSize(852, 90);
        panel.setLocation(0,0);
        panel.setBackground(color);
        panel.setLayout(null);
        panel.add(btn);
        pane2.setLayout(null);
        pane2.setBackground(color);
        pane2.setSize(852, 290 );
        pane2.setLocation(0, 100);
        c.add(pane2);
        lblTitle.setSize(320, 30);
        lblTitle.setLocation(15, 50);
        lblTitle.setFont(f);
        lbluser.setSize(80, 20);
        lbluser.setLocation(370, 30);
        lbluser.setFont(f1);
        lblSTitle.setSize(320, 30);
        lblSTitle.setLocation(230, 10);
        lblSTitle.setFont(f);
        txtuser.setSize(150, 25);
        txtuser.setLocation(370, 50);
        lblpass.setSize(70, 20);
        lblpass.setLocation(540, 30);
        lblpass.setFont(f1);
        txtpass.setSize(150, 25);
        txtpass.setLocation(540, 50);
        lblFName.setSize(100, 20);
        lblFName.setLocation(60, 70);
        lblFName.setFont(f2);
        txtFName.setSize(170, 20);
        txtFName.setLocation(170, 70);
        lblSName.setSize(100, 20);
        lblSName.setLocation(370, 70);
        lblSName.setFont(f2);
        txtSName.setSize(170, 20);
        txtSName.setLocation(485, 70);
        lblMail.setSize(100, 20);
        lblMail.setLocation(60,110);
        lblMail.setFont(f2);
        txtMail.setSize(170, 20);
        txtMail.setLocation(170, 110);
        lblPassword.setSize(100, 20);
        lblPassword.setLocation(370, 110);
        lblPassword.setFont(f2);
        txtPassword.setSize(170, 20);
        txtPassword.setLocation(485, 110);
        lblCPass.setSize(150, 20);
        lblCPass.setLocation(190, 150);
        lblCPass.setFont(f2);
        txtCPass.setSize(170, 20);
        txtCPass.setLocation(360, 150);
       
        btnCreate= new JButton("Create");
        btnCreate.setSize(100, 20);
        btnCreate.setLocation(320, 200);
        btnCreate.addActionListener(this);
        btnCreate.setCursor(cur);
        
         lblWarning.setForeground(Color.red);
            c.add(lblWarning);
                
       setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
        pane2.add(btnCreate);
        pane2.add(lblCPass);
        pane2.add(lblPassword);
        pane2.add(lblMail);
        pane2.add(lblSName);
        pane2.add(txtFName);
        pane2.add(txtSName);
        pane2.add(txtMail);
        pane2.add(txtPassword);
        pane2.add(txtCPass);
        pane2.add(lblFName);
        pane2.add(lblSTitle);
        panel.add(lbluser);
        panel.add(lblpass);
        panel.add(lblTitle);
        panel.add(txtuser);
         panel.add(txtpass);
        c.add(panel);
        c.add(lblimage);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent e)
    {
        if(e.getSource()==btn)
        {
            try
            {
                String db = "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Login.accdb";
                con=DriverManager.getConnection(db);
                s=con.createStatement();
                String Query="select * from Login";
                rs=s.executeQuery(Query);
                int i=0;
                while (rs.next())
                {
                    if (txtuser.getText().equals(rs.getString("Username")) && txtpass.getText().equals(rs.getString("Password")))
                    {
                        i++;
                        con.close();
                        this.setVisible(false);
                        Main_Screen main =new  Main_Screen();
                    }
                    
                }
                if (i==0){
                JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
                }
            }
            catch(Exception ee)
            {
                ee.getMessage();
            }
        }
        else if(e.getSource()==btnCreate)
        {
           if (txtFName.getText().equals("") || txtSName.getText().equals("")|| txtMail.getText().equals("")|| txtPassword.getText().equals("")|| txtCPass.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "Please fill All the Fields");
           }
           else
           {
               
           
            if ((txtPassword.getText()).equals(txtCPass.getText()))
            {
                lblWarning.setVisible(false);
                
                try
                {
                String db = "jdbc:ucanaccess://G:\\Semester 2\\OOP In JAVA\\Project\\Login.accdb";
                con=DriverManager.getConnection(db);
                s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String Query="select * from Login";
                rs=s.executeQuery(Query);
                rs.moveToInsertRow();
                rs.updateString("First Name", txtFName.getText());
                rs.updateString("Last Name", txtSName.getText());
                rs.updateString("Username", txtMail.getText());
                rs.updateString("Password", txtPassword.getText());
                rs.insertRow();
                s.close();
                rs.close();
                txtFName.setText("");
                txtSName.setText("");
                 txtMail.setText("");
                txtPassword.setText("");
                txtCPass.setText("");
                JOptionPane.showMessageDialog(null, "Your Account Has Been Created Successfully\n\t     Now Login");
                }
                catch(Exception ex)
                {
                    ex.getMessage();
                }
             }
            else
            {
                lblWarning.setSize(250, 20);
                lblWarning.setLocation(372, 268); 
            }
           }
        }
    }
}
