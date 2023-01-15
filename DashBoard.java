import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame  implements ActionListener {

    public DashBoard() {
        setIconImage();
        setBounds(100,50,1300,720);
        setTitle("HOTEL DREAM PALACE");
        setLayout(null);
        //homepage image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("PICS/logo7.jpg"));
        JLabel imag = new JLabel(i4);
        imag.setBounds(1220,655,76,30);
        add(imag);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/homepage.jpg"));
        Image i2= i1.getImage().getScaledInstance(1300,720, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1300, 720);
        add(image);
        
        //welcome text
        
        JLabel text= new JLabel("WELCOME TO HOTEL DREAM PALACE ");
        text.setBounds(440,5,600,200);
        text.setFont(new Font("Monospaced",Font.CENTER_BASELINE,28));
        text.setForeground(Color.DARK_GRAY);
        image.add(text);
        
        //menubar
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,655,1300,30);
        mb.setBackground(Color.BLACK);
        
        image.add(mb);
        
        //menu text
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT ");
        hotel.setFont(new Font("Monospaced",Font.CENTER_BASELINE,13));
        hotel.setForeground(Color.orange);
        mb.add(hotel);
        
        //menu items for hotel management
        
        JMenuItem rec=new JMenuItem("Reception");
        rec.addActionListener(this);
        hotel.add(rec);
        
        
        
        JMenu admin = new JMenu("ADMIN ");
        admin.setFont(new Font("Monospaced",Font.CENTER_BASELINE,13));
        admin.setForeground(Color.orange);
        mb.add(admin);
        
        
        
        //menu items for admin
        
        JMenuItem ae=new JMenuItem("Add Employee");
        ae.addActionListener(this);
        admin.add(ae);
        
         
        
        JMenuItem ar=new JMenuItem("Add Room");
        ar.addActionListener(this);
        admin.add(ar);
        
        JMenuItem ad=new JMenuItem("Add Driver");
        ad.addActionListener(this);
        admin.add(ad);
        
        
        
        
          setVisible(true);
              /*while(true){
        text.setVisible(false);
        
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
        
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
          
          
              }*/
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Employee")){
            new Addemployee();
        }else if(e.getActionCommand().equals("Add Room")){
        new Villatype();
    }else if(e.getActionCommand().equals("Add Driver")){
        new AddDriver();
    }else if(e.getActionCommand().equals("Reception")){
        Reception r=new Reception();
        r.setVisible(true);
    }
        
      
    }
    
    public static void main(String[] args) {
        new DashBoard();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }

    

    
}
