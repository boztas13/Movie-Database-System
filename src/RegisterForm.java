import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RegisterForm extends JFrame {
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField usernameTextField;
    private JTextField phoneTextField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel registerPanel;
    private JButton completeRegisterButton;
    private JComboBox dayBox;
    private JComboBox monthBox;
    private JComboBox yearBox;
    private Container c;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };

    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };

    private String years[]
            = { "1986", "1987", "1988", "1989",
            "1990", "1991", "1992", "1993",
            "1994","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010"
             };

    private JFrame register;




    public RegisterForm(){
        register=new JFrame("Register Page");
        register.setDefaultCloseOperation(EXIT_ON_CLOSE);
        register.setPreferredSize(new Dimension(600,400));
        register.setResizable(false);
        register.add(registerPanel);
        register.pack();
        register.setLocationRelativeTo(null);
        register.setVisible(true);
        for (int i=1; i<32; i++)
        {
            dayBox.addItem(i);
        }
        for (int i=1; i<13; i++)
        {
            monthBox.addItem(i);
        }
        for (int i=1960; i<2010; i++)
        {
            yearBox.addItem(i);
        }




        completeRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameTextField.getText();
                String surname=surnameTextField.getText();
                String username=usernameTextField.getText();
                String phonenumber=phoneTextField.getText();

                String password= String.valueOf(passwordField1.getPassword());
                String confirm_password= String.valueOf(passwordField2.getPassword());
                char gender='M';
                if(maleRadioButton.isSelected()){
                    gender='M';
                }
                else if(femaleRadioButton.isSelected()){
                    gender='F';
                }


                if (name.length()>=3){
                    if(surname.length()>=3){
                        if (username.length()>=3){
                            if(phonenumber.length()==10){
                                if (password.equals(confirm_password)){
                                    if(password.length()>=6){
                                        int day = (Integer) dayBox.getSelectedItem();
                                        int month = (Integer) monthBox.getSelectedItem();
                                        int year = (Integer) yearBox.getSelectedItem();
                                        String birthdate=(year+"-"+month+"-"+day);
                                        Login.register(name,surname,username,phonenumber,birthdate,password,gender);
                                        try {
                                            MDBS.backUp();
                                        } catch (IOException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        JOptionPane.showMessageDialog(null,"Register Successful! You are now being directed to login page.");
                                        register.dispose();
                                        new LoginForm();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Password is too short.");
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Passwords do not match.");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Phone Number is too short.");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Username is too short.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Surname is too short.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Name is too short.");
                }



            }
        });
        nameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String name= nameTextField.getText();
                int length=name.length();
                char c= e.getKeyChar();

                if(Character.isLetter(c)|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE){

                    if (length<16){
                        nameTextField.setEditable(true);
                    }
                    else {
                        nameTextField.setEditable(false);
                    }
                }
                else {
                        nameTextField.setEditable(false);
                }
                if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    nameTextField.setEditable(true);
                }
            }
        });
        surnameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String surname= surnameTextField.getText();
                int length=surname.length();
                char c= e.getKeyChar();

                if(Character.isLetter(c)|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    if (length<16){
                        surnameTextField.setEditable(true);
                    }
                    else {
                        surnameTextField.setEditable(false);
                    }
                }
                else {
                        surnameTextField.setEditable(false);
                }
                if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    surnameTextField.setEditable(true);
                }
            }
        });
        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String username= usernameTextField.getText();
                int length=username.length();


                if (length<16){
                    usernameTextField.setEditable(true);
                }
                else {
                    usernameTextField.setEditable(false);
                }
                if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    usernameTextField.setEditable(true);
                }
            }
        }
        );
        phoneTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String phoneNumber= phoneTextField.getText();
                int length=phoneNumber.length();
                char c= e.getKeyChar();

                if(Character.isDigit(c) || e.getKeyChar()==KeyEvent.VK_BACK_SPACE){

                    if (length<10){
                        phoneTextField.setEditable(true);
                    }
                    else {
                        phoneTextField.setEditable(false);
                    }
                }
                else {
                    if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE) {
                        phoneTextField.setEditable(true);
                    }
                    else {
                        phoneTextField.setEditable(false);
                    }
                }
                if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    phoneTextField.setEditable(true);
                }
            }
        });


    }

}

