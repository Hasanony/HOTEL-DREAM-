import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Addemployee extends JFrame implements ActionListener{
    JLabel name,age,gender,job,salary,phone,email,nid;
    ImageIcon i1,i2;
    JTextField namef,emailf,phonef,agef,nidf,salaryf;
    JRadioButton genderm,genderf;
    JButton submit,back;
    JComboBox cbjob;
    
    Addemployee(){
        setLayout(null);
        setIconImage();
        
        //name text
        
        name = new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(name);
        
        //name textfield
        
         namef= new JTextField();
        namef.setBounds(140, 30, 150, 30);
        add(namef);
        
        //age text
        
        age = new JLabel("AGE");
        age.setBounds(60,70,120,30);
        age.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(age);
        
        //age textfield
        
        agef= new JTextField();
        agef.setBounds(140, 70, 150, 30);
        add(agef);
        
        //gender text
        
        gender = new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(gender);
        
        //gender Raadiobutton
        
        genderm= new JRadioButton("Male");
        genderm.setBounds(140, 130, 150, 30);
        genderm.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        genderm.setBackground(Color.WHITE);
        add(genderm);
        
        genderf= new JRadioButton("Female");
        genderf.setBounds(288, 130, 150, 30);
        genderf.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        genderf.setBackground(Color.WHITE);
        add(genderf);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(genderm);
        bg.add(genderf);
        
        //JOB text
        
        job = new JLabel("JOB");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(job);
        
        //job dropbox
        
        String str[]={"Receptionist","Housekeeping","Kitchen Stuff","Room Service","Chefs","Waiter/waitress","Manager","Scubadive guide","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(150, 180, 120, 30);
        cbjob.setForeground(Color.GRAY);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        //salary text
        
        salary = new JLabel("SALARY");
        salary.setBounds(60,240,120,30);
        salary.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(salary);
        
        //salary textfield
        
        salaryf= new JTextField();
        salaryf.setBounds(140, 240, 150, 30);
        add(salaryf);
        
        //phone text
        
        phone = new JLabel("PHONE");
        phone.setBounds(60,290,120,30);
        phone.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(phone);
        
        //phone textfield
        
        phonef= new JTextField();
        phonef.setBounds(140, 290, 150, 30);
        add(phonef);
        
        //email text
        
        email = new JLabel("EMAIL");
        email.setBounds(60,340,120,30);
        email.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(email);
        
        //email textfield
        
        emailf= new JTextField();
        emailf.setBounds(140, 340, 150, 30);
        add(emailf);
        
        //nid text
        
        nid = new JLabel("NID N0");
        nid.setBounds(60,380,120,30);
        nid.setFont(new Font("Tahoma",Font.LAYOUT_NO_LIMIT_CONTEXT,17));
        add(nid);
        
        //nid textfield
        
        nidf= new JTextField();
        nidf.setBounds(140, 380, 150, 30);
        add(nidf);
        
        //submit button
        
        submit=new JButton("SUBMIT");
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
        
        //backgound add
        
         
        i2 = new ImageIcon(ClassLoader.getSystemResource("PICS/emp.jpg"));
        JLabel imag = new JLabel(i2);
        imag.setBounds(250,0,850,540);
        add(imag);
        
        setBounds(350,200,850,540);
        setTitle("HOTEL DREAM PALACE");
        i1 = new ImageIcon(ClassLoader.getSystemResource("PICS/logo5.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(-170,0,850,540);
        add(image);
        
        
        
        
        setVisible(true);
        
        
       
    }
    
    public void actionPerformed(ActionEvent e) {
        
//value from text
        String nameg =namef.getText();
        String ageg = agef.getText();
        String salaryg=salaryf.getText();
        String phoneg=phonef.getText();
        String emailg=emailf.getText();
        String nidg=nidf.getText();
        
        //value from button
        
        String genderg=null;
        
        if(namef.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
        }
        if(emailf.equals("")){
            JOptionPane.showMessageDialog(null, "email should not be empty");
        }
       
        
        if(genderm.isSelected()){
            genderg = "Male";
        }else if(genderf.isSelected()){
            genderg="Female";
        }
        
        //value from combobox
        
        String job = (String)cbjob.getSelectedItem();
        if(e.getSource()==submit){
        try{
            Connect con= new Connect();
           String query = "INSERT INTO employee values( '"+nameg+"', '"+ageg+"', '"+genderg+"','"+job+"', '"+salaryg+"', '"+phoneg+"','"+emailg+"', '"+nidg+"')";
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Employee added successfully");
        }catch(Exception ae){
            ae.printStackTrace();
        }}
        else if(e.getSource()==back){
            setVisible(false);
                
        
        
    }
    }
    
    public static void main(String[] args) {
        new Addemployee();
    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("PICS/logo17.png")));
    }
}

    

