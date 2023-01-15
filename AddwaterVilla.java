import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddwaterVilla extends JFrame implements ActionListener{
        JLabel bedtp;
        JRadioButton single,Double;
        JButton select,back;
    public AddwaterVilla() {
        setLayout(null);
         setIconImage();
        
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
        Double.setBounds(240,270,250,50);
        Double.setForeground(Color.GRAY);
        Double.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,22));
        add(Double);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(single);
        bg.add(Double);
        
        select=new JButton("SELECT");
        select.setBackground(Color.BLACK);
        select.setForeground(Color.WHITE);
        select.setBounds(190, 340, 150, 40);
        select.addActionListener(this);
        add(select);
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 340, 150, 40);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1;
        JLabel roomno,availableb,cleansts,price,vilatp;
        JTextField Room;
        JButton addroom,cancel;
        JComboBox available,clean,vilatype;
        
        setBounds(400,270,701,438);
        setTitle("HOTEL DREAM PALACE");
        i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/villa1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,701,438);
        add(image);
        
        setVisible(true);
        
        
    }public void actionPerformed(ActionEvent e) {
        if(single.isSelected()){
            setVisible(false);
            new Singlebedwat();
        }else if(Double.isSelected()){
            setVisible(false);
           new Doublebedwat();
        }  else if(e.getSource()==back){
            setVisible(false);}
    }
    
    public static void main(String[] args) {
        new AddwaterVilla();
        
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}