import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Checkin extends JFrame implements ActionListener{
      JComboBox idc;
      JLabel check,gender,id,number,name,country,room,date,time,deposit;
      JTextField numberf,namef,cf,depositf;
      JRadioButton genderm,genderf;
      Choice roomc;
      JButton submit,back,help;
      
    public Checkin() {
        
        setLayout(null);
        setIconImage();
        
        
        check= new JLabel("CHECK IN FORM");
        check.setBounds(200,0,210,30);
        check.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(check);
        
        
        id= new JLabel("ID");
        id.setBounds(30,60,100,30);
        id.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(id);
        
        String str[]={"Passport","NID"};
        idc = new JComboBox(str);
        idc.setBounds(180, 60, 150, 30);
        idc.setForeground(Color.GRAY);
        idc.setBackground(Color.WHITE);
        add(idc);
        
        number= new JLabel("NUMBER");
        number.setBounds(30,110,100,30);
        number.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(number);
        
        numberf= new JTextField();
        numberf.setBounds(180, 110, 150, 30);
        add(numberf);
        
        name = new JLabel("FULL NAME");
        name.setBounds(30,150,120,30);
        name.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(name);
        
        //name textfield
        
         namef= new JTextField();
        namef.setBounds(180, 150, 150, 30);
        add(namef);
        
        gender = new JLabel("GENDER");
        gender.setBounds(30,190,120,30);
        gender.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(gender);
        
        //gender Raadiobutton
        
        genderm= new JRadioButton("Male");
        genderm.setBounds(180, 190, 150, 30);
        genderm.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        genderm.setBackground(Color.WHITE);
        add(genderm);
        
        genderf= new JRadioButton("Female");
        genderf.setBounds(328, 190, 150, 30);
        genderf.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        genderf.setBackground(Color.WHITE);
        add(genderf);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(genderm);
        bg.add(genderf);
        
        country= new JLabel("COUNTRY");
        country.setBounds(30,230,100,30);
        country.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(country);
        
        cf= new JTextField();
        cf.setBounds(180, 230, 150, 30);
        add(cf);
        
        
        room= new JLabel("ROOM NUMBER");
        room.setBounds(30,270,150,30);
        room.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(room);
        
        
        roomc=new Choice();
        
        roomc.setBounds(180,270,150,50);
        add(roomc);
        
        date= new JLabel("CHECKIN TIME : ");
        date.setBounds(30,310,150,30);
        date.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(date);
        
        Date dat=new Date();
        
        time= new JLabel(""+dat);
        time.setBounds(180,310,250,30);
        time.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(time);
        
        
        deposit= new JLabel("DEPOSIT");
        deposit.setBounds(30,350,100,30);
        deposit.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,17));
        add(deposit);
        
        depositf= new JTextField();
        depositf.setBounds(180, 350, 150, 30);
        add(depositf);
        
        submit=new JButton("CHECK IN");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(100, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 430, 150, 30);
        back.addActionListener(this);
        add(back);
        
        
        help=new JButton("HELP LINE");
        help.setBackground(Color.BLACK);
        help.setForeground(Color.WHITE);
        help.setBounds(600, 470, 150, 30);
        help.addActionListener(this);
        add(help);
        
        try{
            Connect con=new Connect();
            String q="select * from waterdoubleb where available = 'Available'";
            ResultSet rs=con.s.executeQuery(q);
            
            while(rs.next()){
                roomc.add(rs.getString("room"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setBounds(350,400,800,550);
        setTitle("HOTEL DREAM PALACE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("PICS/checkin.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,800,550);
        add(image);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit){
           String ide=(String) idc.getSelectedItem();
           String numbere=numberf.getText();
           String namee=namef.getText();
           String gendere=null;
           
           if(genderm.isSelected()){
               gendere="male";
           }else{
               gendere="female";
           }
           String countrye=cf.getText();
           String roome =roomc.getSelectedItem();
           String time=date.getText();
           String depo=depositf.getText();
           try{
            Connect con= new Connect();
            
           String query = "INSERT INTO checkin values( '"+ide+"', '"+numbere+"', '"+namee+"','"+gendere+"', '"+countrye+"', '"+roome+"','"+time+"', '"+depo+"')'";
           String q2="update waterdoubleb set available = 'Unavailable' where room = '"+roome+"'";
           con.s.executeUpdate(query);
           con.s.executeUpdate(q2);
           JOptionPane.showMessageDialog(null, "CHECKIN SUCESSFULL","success",JOptionPane.INFORMATION_MESSAGE);
           setVisible(false); 
           new ProjectDreamPalace();
        }catch(Exception ae){
            ae.printStackTrace();
        }
       }else if(e.getSource()==back){
           setVisible(false);
           new ProjectDreamPalace();
       }
       else if(e.getSource()==help){
           new Chatbot();
       }
    }

    public static void main(String[] args) {
        new Checkin();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
    
    
    
    
    
    
    
}
