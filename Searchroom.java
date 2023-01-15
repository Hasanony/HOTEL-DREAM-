import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

   public class Searchroom extends JFrame implements ActionListener {
JTable table;
JButton back,submit;
JComboBox bedtyp,Villatyp;
JCheckBox av;
    public Searchroom() {
        getContentPane().setBackground(Color.PINK);
        
    setLayout(null);
    setIconImage();
    
        JLabel n=new JLabel("Search Room ");
    n.setBounds(150, -10, 130, 40);
    n.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,20));
    add(n);
    
    
     JLabel bed=new JLabel("BED TYPE");
    bed.setBounds(300, 50, 130, 40);
    bed.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(bed);
    
    bedtyp=new JComboBox(new String[]{"Single bed","Double bed"});
    bedtyp.setBounds(370, 55, 130, 30);
    bedtyp.setBackground(Color.WHITE);
    add(bedtyp);
    
     JLabel villa=new JLabel("Villa TYPE");
    villa.setBounds(10, 50, 130, 40);
    villa.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(villa);
    
    
    String str2[]={"Water Villa","Beach Villa"};
    Villatyp=new JComboBox(str2);
    Villatyp.setBounds(80, 55, 130, 30);
    Villatyp.setBackground(Color.WHITE);
    add(Villatyp);
    
    
    av=new JCheckBox("Only show Avaiable ");
    av.setBounds(550, 220, 170, 30);
    av.setBackground(Color.WHITE);
    add(av);
    
    JLabel m=new JLabel("Room no");
    m.setBounds(10, 120, 130, 40);
    m.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(m);
    
    JLabel l=new JLabel("Avaiablity");
    l.setBounds(90, 120, 130, 40);
    l.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(l);
    
    JLabel o=new JLabel("Status");
    o.setBounds(190, 120, 130, 40);
    o.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(o);
    
    
    JLabel P=new JLabel("Price");
    P.setBounds(270, 120, 130, 40);
    P.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(P);
    
       JLabel v=new JLabel("Villa type");
    v.setBounds(330, 120, 130, 40);
    v.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(v);
    
     JLabel b=new JLabel("Bed type");
    b.setBounds(430, 120, 130, 40);
    b.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,13));
    add(b);
    
    submit=new JButton("SEARCH");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    submit.setBounds(30, 500, 150, 40);
    add(submit);
    
     back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(250, 500, 150, 40);
        
        add(back);
        
        
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("PICS/logo8.jpg"));
    Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(500, 0, 600, 600);
    add(image);
    
    table=new JTable();
    table.setBounds(0, 170, 500, 300);
    table.setBackground(Color.pink);
    table.setForeground(Color.darkGray);
    add(table);
    setTitle("HOTEL DREAM PALACE");
    
    try{
        Connect con=new Connect();
        ResultSet rs=con.s.executeQuery("select * from waterdoubleb ");
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        e.printStackTrace();
    }
    
    
    setBounds(300,200,1050,600);
    setVisible(true);
    
    
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            try{
                String q="select * from waterdoubleb where villatype ='"+Villatyp.getSelectedItem()+"' AND bedtype = '"+bedtyp.getSelectedItem()+"'";
                String q2="select * from waterdoubleb where available= 'Available'AND villatype ='"+Villatyp.getSelectedItem()+"' AND bedtype = '"+bedtyp.getSelectedItem()+"'";
                Connect c=new Connect();
                ResultSet rs;
                if(av.isSelected()){
                    rs=c.s.executeQuery(q2);
                }else{
                    rs=c.s.executeQuery(q);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else if(e.getSource() == back){
            
            setVisible(false);
            Reception r=new Reception();
            r.setVisible(true);
        }
       
    }
    public static void main(String[] args) {
        new Searchroom();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}
