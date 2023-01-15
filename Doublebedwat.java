import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Doublebedwat extends JFrame implements ActionListener{
    ImageIcon i1;
    JLabel addroom,room,avail,clean,price,vtype,btype;
    JComboBox availb,cleanb,villatyp,bedtp;
    JTextField roomf,pricef;
    JButton Addroom,cancel;

    public Doublebedwat() {
        setLayout(null);
        setIconImage();
        
        addroom= new JLabel("ADD ROOM");
        addroom.setBounds(200,0,120,30);
        addroom.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,20));
        add(addroom);
        
        room= new JLabel("Room No");
        room.setBounds(130,60,120,30);
        room.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(room);
        
        roomf= new JTextField();
        roomf.setBounds(220, 60, 150, 30);
        add(roomf);
        
        avail= new JLabel("Status");
        avail.setBounds(130,110,120,30);
        avail.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(avail);
        
        String str[]={"Available","Unavailable"};
        availb = new JComboBox(str);
        availb.setBounds(220, 110, 150, 30);
        availb.setForeground(Color.GRAY);
        availb.setBackground(Color.WHITE);
        add(availb);
        
        clean= new JLabel(" Clean Status");
        clean.setBounds(120,150,120,30);
        clean.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(clean);
        
        String str1[]={"Cleaned","Dirty"};
        cleanb = new JComboBox(str1);
        cleanb.setBounds(220, 150, 150, 30);
        cleanb.setForeground(Color.GRAY);
        cleanb.setBackground(Color.WHITE);
        add(cleanb);
        
        vtype= new JLabel(" Villa Type");
        vtype.setBounds(120,190,120,30);
        vtype.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(vtype);
        
        btype= new JLabel(" Bed Type");
        btype.setBounds(120,240,120,30);
        btype.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(btype);
        
        String str2[]={"Water Villa","Beach Villa"};
        villatyp = new JComboBox(str2);
        villatyp.setBounds(220, 190, 150, 30);
        villatyp.setForeground(Color.GRAY);
        villatyp.setBackground(Color.WHITE);
        add(villatyp);
        
        String str3[]={"Single bed","Double bed"};
        bedtp = new JComboBox(str3);
        bedtp.setBounds(220, 240, 150, 30);
        bedtp.setForeground(Color.GRAY);
        bedtp.setBackground(Color.WHITE);
        add(bedtp);

        
        price= new JLabel("Price");
        price.setBounds(130,290,120,30);
        price.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(price);
        
        pricef= new JTextField();
        pricef.setBounds(220, 290, 150, 30);
        add(pricef);
        
        Addroom=new JButton("Add Room");
        Addroom.setBackground(Color.BLACK);
        Addroom.setForeground(Color.WHITE);
        Addroom.addActionListener(this);
        Addroom.setBounds(100, 330, 150, 40);
        
        add(Addroom);
        
        
        cancel=new JButton("BACK");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(300, 330, 150, 40);
       
        add(cancel);
        
        setBounds(400,270,701,438);
        setTitle("HOTEL DREAM PALACE");
        i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/doublewat.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,701,438);
        add(image);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
       try{
            
            if(ae.getSource() == Addroom){
                try{
                Connect c = new Connect();
                String room = roomf.getText();
                String available = (String)availb.getSelectedItem();
                String status = (String)cleanb.getSelectedItem();
                String v = (String)villatyp.getSelectedItem();
                String b = (String)bedtp.getSelectedItem();
                String price  = pricef.getText();
                
                String str = "INSERT INTO waterdoubleb values( '"+room+"', '"+available+"', '"+status+"','"+price+"','"+v+"','"+b+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Water Villa Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == cancel){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
         
     }
    
    public static void main(String[] args) {
        new Doublebedwat();
    }
     private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}

