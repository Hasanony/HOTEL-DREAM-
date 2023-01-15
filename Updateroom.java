
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Updateroom extends JFrame implements ActionListener{
      JLabel check,id,room,a,st,rnum,coutf;
    JComboBox idc;
    Choice customer;
    JButton checkout,back,update;
    JTextField av,s;

    public Updateroom() {
        
        setLayout(null);
         id= new JLabel("CUSTOMER ID");
        id.setBounds(30,80,180,30);
        id.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(id);
        
       customer = new Choice();
        customer.setBounds(220,80,150,25);
        add(customer);
        
        room= new JLabel("ROOM NUMBER : ");
        room.setBounds(30,130,150,30);
        room.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(room);
        
        rnum= new JLabel();
        rnum.setBounds(220,130,150,30);
        add(rnum);
        
         a= new JLabel("AVAILABILITY ");
        a.setBounds(30,180,150,30);
        a.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(a);
        
        av= new JTextField();
        av.setBounds(220,180,150,30);
        av.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(av);
        
        
         st= new JLabel("ROOM NUMBER : ");
        st.setBounds(30,230,150,30);
        st.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(st);
        
        s= new JTextField();
        s.setBounds(220,230,150,30);
        s.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(s);
        
        checkout =new JButton("Check");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.GREEN);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        update =new JButton("UPDATE");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.GREEN);
        update.setBounds(200,280,120,30);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.GREEN);
        back.setBounds(380, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        try{
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select* from checkin");
            while(rs.next()){
                customer.add(rs.getString("number"));
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         setBounds(350,300,1000,450);
        setTitle("HOTEL DREAM PALACE");
        
        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("PICS/cout.png"));
        JLabel imag = new JLabel(i2);
        imag.setBounds(200,-110,325,260);
        add(imag);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("PICS/checkout.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1000,450);
        add(image);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkout){
           
            
            
            try{
                 
                Connect c=new Connect();
                String q1="select* from checkin where number = '"+customer.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(q1);
                while(rs.next()){
                    rnum.setText(rs.getString("roomnum"));
                }
                ResultSet rs2=c.s.executeQuery("select* from waterdoubleb where room='"+rnum.getText()+"'");
                while(rs2.next()){
                    av.setText(rs2.getString("available"));
                    s.setText(rs2.getString("status"));
                }
                
                
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }else if(e.getSource()==update){
           String n=customer.getSelectedItem();
           String r=rnum.getText();
           String avail=av.getText();
           String sta=s.getText();
           
           try{
               Connect c=new Connect();
               c.s.executeUpdate("update waterdoubleb set available = '"+avail+"',status = '"+sta+"'where room = '"+r+"'");
               JOptionPane.showMessageDialog(null, "DATA UPDATE SUCCESSFULLY","success",JOptionPane.INFORMATION_MESSAGE);
           }catch(Exception ae){
               ae.printStackTrace();
           }
        }
        
        else if(e.getSource()==back){
            setVisible(false);
            Reception n=new Reception();
            n.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Updateroom();
    }

    
}
