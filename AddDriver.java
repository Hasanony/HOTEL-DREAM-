import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class AddDriver extends JFrame implements ActionListener {
    ImageIcon i1;
   JLabel tyep; 
    JRadioButton plane,boat;
    JButton Go,back;
    

    public AddDriver() {
        setLayout(null);
        setIconImage();
        tyep=new JLabel("SELECT DRIVER TYPE");
        tyep.setBounds(300,130,300,90);
        tyep.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,28));
        add(tyep);
         
        plane=new JRadioButton("PILOT");
        plane.setBounds(300,230,250,50);
        plane.setBackground(Color.WHITE);
        plane.setForeground(Color.GRAY);
        plane.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,30));
        add(plane);
        
        boat=new JRadioButton("BOAT DRIVER");
        boat.setBounds(300,330,250,50);
        boat.setBackground(Color.WHITE);
        boat.setForeground(Color.GRAY);
        boat.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,30));
        add(boat);
        
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(plane);
        bg.add(boat);
        
        Go=new JButton("GO");
        Go.setBackground(Color.BLACK);
        Go.setForeground(Color.WHITE);
        Go.setBounds(325, 430, 150, 40);
        Go.addActionListener(this);
        add(Go);
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 430, 150, 40);
        back.addActionListener(this);
        add(back);

        
        setBounds(400,200,850,540);
        setTitle("HOTEL DREAM PALACE");
        i1=new ImageIcon(ClassLoader.getSystemResource("PICS/logo9.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,850,540);
        add(image);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(plane.isSelected()){
            setVisible(false);
            new PlaneDriver();
        }else if(boat.isSelected()){
            setVisible(false);
           new BoatDriver();
        }  else if(e.getSource()==back){
            setVisible(false);}
       
    }
    
    public static void main(String[] args) {
        new AddDriver();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }

    
}
