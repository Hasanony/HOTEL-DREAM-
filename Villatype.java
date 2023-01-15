
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Villatype extends JFrame implements ActionListener{
    
        ImageIcon i1;
        JLabel vilatp;
        JButton Go,back;
        JRadioButton Watervilla,Beachvilla;

    public Villatype() {
        setLayout(null);
        setIconImage();
              
        //villatype text
        vilatp=new JLabel("SELECT VILLA TYPE");
        vilatp.setBounds(300,130,300,90);
        vilatp.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,28));
        add(vilatp);
        
        //radiobuttom for villatype
        
        Watervilla=new JRadioButton("Water Villa");
        Watervilla.setBounds(300,230,250,50);
        Watervilla.setBackground(Color.WHITE);
        Watervilla.setForeground(Color.GRAY);
        Watervilla.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,30));
        add(Watervilla);
        
        Beachvilla=new JRadioButton("Beach Villa");
        Beachvilla.setBounds(300,330,250,50);
        Beachvilla.setBackground(Color.WHITE);
        Beachvilla.setForeground(Color.GRAY);
        Beachvilla.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,30));
        add(Beachvilla);
        
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(Watervilla);
        bg.add(Beachvilla);
        
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
        
        //background
        setBounds(350,200,850,540);
        setTitle("HOTEL DREAM PALACE");
        i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/logo8.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,2,850,500);
        add(image);
        
        
        
        
        setVisible(true);
    }
    //button work
   
    public void actionPerformed(ActionEvent e) {
        if(Watervilla.isSelected()){
            setVisible(false);
            new AddwaterVilla();
        }else if(Beachvilla.isSelected()){
            setVisible(false);
           new AddBeachvilla();
        }  else if(e.getSource()==back){
            setVisible(false);}
    }
    public static void main(String[] args) {
        new Villatype();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }

    
}
