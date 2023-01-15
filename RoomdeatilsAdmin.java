import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class RoomdeatilsAdmin extends JFrame implements ActionListener {
JTable table;
JButton back;
    public RoomdeatilsAdmin() {
        getContentPane().setBackground(Color.PINK);
        
    setLayout(null);
    setIconImage();
    
    JLabel n=new JLabel("Room Details");
    n.setBounds(150, -10, 130, 40);
    n.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,20));
    add(n);
    JLabel m=new JLabel("Room no");
    m.setBounds(10, 40, 130, 40);
    m.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(m);
    
    JLabel l=new JLabel("Avaiablity");
    l.setBounds(90, 40, 130, 40);
    l.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(l);
    
    JLabel o=new JLabel("Status");
    o.setBounds(170, 40, 130, 40);
    o.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(o);
    
    
    JLabel P=new JLabel("Price");
    P.setBounds(270, 40, 130, 40);
    P.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(P);
    
     JLabel v=new JLabel("Villa type");
    v.setBounds(330, 40, 130, 40);
    v.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(v);
    
     JLabel b=new JLabel("Bed type");
    b.setBounds(430, 40, 130, 40);
    b.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(b);
    
     back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(150, 450, 150, 40);
        
        add(back);
        
        
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("PICS/logo8.jpg"));
    Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(500, 0, 600, 600);
    add(image);
    
    table=new JTable();
    table.setBounds(0, 80, 500, 400);
    table.setBackground(Color.pink);
    table.setForeground(Color.darkGray);
    add(table);
    setTitle("HOTEL DREAM PALACE");
    
    try{
        Connect con=new Connect();
        
        ResultSet rb=con.s.executeQuery("select * from waterdoubleb");
        table.setModel(DbUtils.resultSetToTableModel(rb));
    }catch(Exception e){
        e.printStackTrace();
    }
    
    setBounds(300,200,1050,600);
    setVisible(true);
    
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back){
            
            setVisible(false);
            Reception r=new Reception();
            r.setVisible(true);
        }
       
    }
    public static void main(String[] args) {
        new RoomdeatilsAdmin();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}