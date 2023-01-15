import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener{
    JLabel check,id,room,rnum,date,datef,cout,coutf;
    JComboBox idc;
    Choice customer;
    JButton checkout,back;

    public Checkout() {
        setLayout(null);
         setIconImage();
        
        
        
        
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
        rnum.setBounds(200,130,150,30);
        rnum.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(rnum);
        
        date= new JLabel("CHECKIN TIME : ");
        date.setBounds(30,180,150,30);
        date.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(date);
        
        datef= new JLabel();
        datef.setBounds(200,180,150,30);
        datef.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(datef);
        
         cout= new JLabel("CHECKOUT TIME : ");
        cout.setBounds(30,230,160,30);
        cout.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(cout);
        
        Date d=new Date();
        
        coutf= new JLabel(""+d);
        coutf.setBounds(200,230,250,30);
        coutf.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(coutf);
        
        checkout =new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.GREEN);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.GREEN);
        back.setBounds(200, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
         try{
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select* from checkin");
            while(rs.next()){
                customer.add(rs.getString("number"));
                rnum.setText(rs.getString("roomnum"));
                datef.setText(rs.getString("time"));
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
            String q1="delete from checkin where number = '"+customer.getSelectedItem()+"'";
            String q2="update waterdoubleb set available ='Avaiable'where room = '"+rnum.getText()+"'";
            
            try{
                Connect c=new Connect();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "CHECKOUT DONE","success",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            Reception n=new Reception();
            n.setVisible(true);
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
            Reception n=new Reception();
            n.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Checkout();
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
    
}
