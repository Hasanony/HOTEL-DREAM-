
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    
    Login(){
        setIconImage() ;
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("PICS/icon4.png"));
        JLabel imag1 = new JLabel(i3);
        add(imag1);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("PICS/icon5.png"));
        JLabel imag2 = new JLabel(i4);
        add(imag2);
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("PICS/admin.png"));
        JLabel imag3 = new JLabel(i5);
        imag3.setBounds(370, 30, 125, 125);
        add(imag3);
        
        //layout
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,420);
        setLocation(340,200);
        
        
        //username text
        
        JLabel user = new JLabel("Username");
        user.setBounds(300,180,100,90);
        add(user);
        
        //box for username
        
        username = new JTextField();
        username.setBounds(400,210 ,150 ,30 );
        add(username);
        
        //password text
        
        JLabel pass= new JLabel ("Password ");
         pass.setBounds(300,290,100,30);
         add(pass);
         
         //box for password
         
        password = new JPasswordField();
        password.setBounds(400,290 ,150 ,30 );
        add(password);
        
        //button for login
        
        login = new JButton("Login",i3);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBounds(300,360,112,30);
        add(login);
        
        //button for cancel
        
        cancel = new JButton("Cancel",i4);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(460,360,112,30);
        add(cancel);
        
        setBounds(350,200,850,540);
        setTitle("HOTEL DREAM PALACE");
        
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("PICS/logo5.jpg"));
        JLabel imag= new JLabel(i2);
        imag.setBounds(0,0,850,540);
        add(imag);
        //image of logo
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        //database connect 
        
        if(e.getSource() == login){
             String user =username.getText();
             String pass = password.getText();
              
             try{
                 Connect r= new Connect();
                 
                 String query = " select * from login  where username = '"+ user +"' and password = '"+ pass +"'";
            ResultSet rs=r.s.executeQuery(query);
            
            if(rs.next()){
                setVisible(false);
                new DashBoard();
                
            }else{
                JOptionPane.showMessageDialog(null, "invalid username or password");
            }
            
             }catch(Exception ae){
                 ae.printStackTrace();
             }
        }else if(e.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}
