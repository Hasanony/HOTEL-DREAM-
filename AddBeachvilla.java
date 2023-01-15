import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class AddBeachvilla extends JFrame implements ActionListener{
    JRadioButton single,Double;
    JLabel bedtp;
    ImageIcon i1;
    JButton select,back;

    public AddBeachvilla() {
    
    
   setLayout(null);
   setIconImage() ;
 
        bedtp=new JLabel("SELECT BED TYPE");
        bedtp.setBounds(240,90,300,90);
        bedtp.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,25));
        add(bedtp);
   
   
        single=new JRadioButton("SINGLE BED");
        single.setBounds(240,160,250,50);
        single.setForeground(Color.GRAY);
        single.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,22));
        add(single);
        
        Double=new JRadioButton("DOUBLE BED");
        Double.setBounds(240,240,250,50);
        Double.setForeground(Color.GRAY);
        Double.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,22));
        add(Double);
        
        
        select=new JButton("SELECT");
        select.setBackground(Color.BLACK);
        select.setForeground(Color.WHITE);
        select.setBounds(190, 300, 150, 40);
        
        select.addActionListener(this);
        add(select);
       
        
        
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 300, 150, 40);
        back.addActionListener(this);
        add(back);
        
        setBounds(400,270,739,415);
        setTitle("HOTEL DREAM PALACE");
        i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/villa2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,739,415);
        add(image);
        
        
        setVisible(true); 
}
    public void actionPerformed(ActionEvent e) {
        if(single.isSelected()){
            setVisible(false);
            new Singlebedbeach();
        }else if(Double.isSelected()){
            setVisible(false);
           new Doublebeach();
        }  else if(e.getSource()==back){
            setVisible(false);}
    }
    
    public static void main(String[] args) {
        new AddBeachvilla();
    }
      private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}
