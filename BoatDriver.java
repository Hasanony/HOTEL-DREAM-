import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class BoatDriver extends JFrame implements ActionListener{
    JLabel name,age,gender,boatm,avail,addroom;
    JComboBox availb;
    JTextField namef,agef;
    JComboBox genderf,boatf;
    JButton Go,back;

    public BoatDriver() {
        setLayout(null);
        setIconImage();
        
         addroom= new JLabel("ADD BOAT DRIVER");
        addroom.setBounds(200,0,190,30);
        addroom.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,20));
        add(addroom);
        
        name = new JLabel("NAME");
        name.setBounds(60,80,120,30);
        name.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(name);
        
        //name textfield
        
         namef= new JTextField();
        namef.setBounds(140, 80, 150, 30);
        add(namef);
        
        //age text
        
        age = new JLabel("AGE");
        age.setBounds(60,120,120,30);
        age.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(age);
        
        //age textfield
        
        agef= new JTextField();
        agef.setBounds(140, 120, 150, 30);
        add(agef);
        
        //gender text
        
        gender = new JLabel("Gender");
        gender.setBounds(60,160,140,30);
        gender.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(gender);
        
        //job dropbox
        
        String str[]={"MALE","FEMALE"};
        genderf = new JComboBox(str);
        genderf.setBounds(140, 160, 150, 30);
        genderf.setForeground(Color.GRAY);
        gender.setBackground(Color.WHITE);
        add(genderf);
        
        boatm = new JLabel("MODEL");
        boatm.setBounds(60,200,120,30);
        boatm.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(boatm);
        
        //age textfield
        
        String str1[]={"TOURING","SILVERCAT34"};
        boatf = new JComboBox(str1);
        boatf.setBounds(140, 200, 150, 30);
        boatf.setForeground(Color.GRAY);
        boatf.setBackground(Color.WHITE);
        add(boatf);
        
         avail= new JLabel("Status");
        avail.setBounds(60,250,120,30);
        avail.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(avail);
        
        String str2[]={"Available","Unavailable"};
        availb = new JComboBox(str2);
        availb.setBounds(140, 250, 150, 30);
        availb.setForeground(Color.GRAY);
        availb.setBackground(Color.WHITE);
        add(availb);
        
         Go=new JButton("ADD DRIVER");
        Go.setBackground(Color.BLACK);
        Go.setForeground(Color.WHITE);
         Go.setBounds(25, 330, 150, 40);
        Go.addActionListener(this);
        add(Go);
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 330, 150, 40);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(400,270,700,468);
        setTitle("HOTEL DREAM PALACE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/boatdri.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,701,438);
        add(image);
        
        setVisible(true);
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
       
          try{
            
            if(e.getSource() == Go){
                try{
                Connect c = new Connect();
                String name = namef.getText();
                String gender = (String)genderf.getSelectedItem();
                String status = (String)availb.getSelectedItem();
                 String model = (String)boatf.getSelectedItem();
                String age  = agef.getText();
                
                String str = "INSERT INTO boatdriver values( '"+name+"', '"+age+"', '"+gender+"','"+model+"', '"+status+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Boat Driver Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(e.getSource() == back){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
    
    
    public static void main(String[] args) {
        new BoatDriver();
    }
private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }

    
    
}
