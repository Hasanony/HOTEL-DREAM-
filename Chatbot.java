import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.*;
public class Chatbot extends JFrame implements ActionListener{
    JTextArea ca;
    JTextField cf;
    JButton b;
    JLabel l;

    public Chatbot() {
        setLayout(null);
        
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("PICS/send.png"));
        JLabel imag1 = new JLabel(i3);
        add(imag1);
        
        
        
        
        ca=new JTextArea();
        
        ca.setSize(430,460 );
        ca.setText("SAY hi in the chatbox below......");
        ca.setLocation(0,0);
        ca.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT,14));
        ca.setBackground(Color.black);
        ca.setForeground(Color.green);
        add(ca);
       
        
         
        cf=new JTextField();
        cf.setSize(740,50);
        cf.setLocation(-2,455);
        cf.setBackground(Color.black);
        cf.setForeground(Color.green);
        add(cf);
        
        l=new JLabel();
        
        
        b=new JButton(i3);
        b.add(l);
        b.setSize(100,50);
        b.setLocation(735,455);
        b.addActionListener(this);
        b.setBackground(Color.red);
        
        add(b);
        

    
        
        
        
        
        
        setBounds(350,200,850,540);
        setTitle("HOTEL DREAM PALACE CHATBOT ");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("PICS/bot.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(180,-20,850,540);
        add(image);
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
            String text=cf.getText();
            ca.append("You-->"+text+"\n");
            cf.setText("");
            
            if(text.contains("hi")){
                replyMeth("hi there"+"\n"+"DO you need help??yes for taking help/bye for going to homepage");
            }
            else if(text.contains("yes")){
                replyMeth("What kind of do help you want? "+"\n"
                        + "Do you want to Register a Customer ID??"+" "+"write register for that."+"\n"
                        + "Do you want to Sign in?"+" "+"write signin for that."+"\n"
                        + "Do you want to see room deatails?"+"write details for that.");
            }
            else if(text.contains("register")){
                setVisible(false);
                replyMeth("GOING THERE. :)");
                Resgister n=new Resgister();
                n.setVisible(true);
            }
            else if(text.contains("signin")){
                setVisible(false);
                replyMeth("GOING THERE. :)");
                Clogin m=new Clogin();
                m.setVisible(true);
            }
             else if(text.contains("details")){
                 setVisible(false);
                replyMeth("GOING THERE. :)");
                new Searchroom();
               
            }
            
             else if(text.contains("bye")){
                setVisible(false);
                
                
            }
            
            else{
                replyMeth("i can't understand :(");
            }
        }
    }
    public void replyMeth(String s){
        ca.append("DREAMBOT-->"+s+"\n");
    }
    
    public static void main(String[] args) {
        
        new Chatbot();
    }
     private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
    
    
    
}
