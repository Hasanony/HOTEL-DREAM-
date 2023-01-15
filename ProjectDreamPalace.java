
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectDreamPalace extends JFrame implements ActionListener{
    ProjectDreamPalace(){
        setIconImage();
      
        //hotel picture
        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("PICS/logo10.png"));
        JLabel imag = new JLabel(i2);
        imag.setBounds(0, -200, 546, 457);
        add(imag);
        
        
        
        setSize(1200,620);
        setTitle("HOTEL DREAM PALACE");
        setLocation(140,80);
        setResizable(false);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("PICS/hotel.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        
        
       
        
        //hotel management system text
        
        
        
        //next button
        
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,560,1300,30);
        mb.setBackground(Color.BLACK);
        
        image.add(mb);
        
        //menu text
        
        JMenu hotel = new JMenu("PANEL");
        hotel.setFont(new Font("Monospaced",Font.CENTER_BASELINE,13));
        hotel.setForeground(Color.orange);
        mb.add(hotel);
        
        JMenuItem rec=new JMenuItem("CUSTOMER PANEL");
        rec.addActionListener(this);
        hotel.add(rec);
        
        JMenuItem rece=new JMenuItem("ADMIN PANEL");
        rece.addActionListener(this);
        hotel.add(rece);
        
        JMenu help = new JMenu("HELPLINE ");
        help.setFont(new Font("Monospaced",Font.CENTER_BASELINE,13));
        help.setForeground(Color.orange);
        mb.add(help);
        
        JMenuItem cb=new JMenuItem("CHATBOX");
        cb.addActionListener(this);
        help.add(cb);
        
        
        
        
        
        setVisible(true);
        
    
    }

        
    
    
    //goto login page
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("CUSTOMER PANEL")){
            
        new Clogin().setVisible(true);
         
          
            setVisible(false);
        }else if(ae.getActionCommand().equals("ADMIN PANEL")){
        new Login();
        setVisible(false);
    }else if(ae.getActionCommand().equals("CHATBOX")){
        new Chatbot();
    }
    }
    
    public static void main(String[] args) {
       new ProjectDreamPalace();
       
       
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }

    
}
