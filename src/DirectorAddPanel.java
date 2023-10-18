import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class DirectorAddPanel {
    private JPanel panel1;
    private JTextField nameText;
    private JTextField surnameText;
    private JTextField phoneText;
    private JComboBox monthBox;
    private JComboBox yearBox;
    private JComboBox dayBox;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JButton addButton;

    DirectorAddPanel(){
        JFrame frame = new JFrame("Add Director");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        for (int i=1; i<32; i++)
        {
            dayBox.addItem(i);
        }
        for (int i=1; i<13; i++)
        {
            monthBox.addItem(i);
        }
        for (int i=1960; i<2023; i++)
        {
            yearBox.addItem(i);
        }
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= nameText.getText();
                String surname = surnameText.getText();
                String phone = phoneText.getText();
                int day = (Integer) dayBox.getSelectedItem();
                int month = (Integer) monthBox.getSelectedItem();
                int year = (Integer) yearBox.getSelectedItem();
                String birthdate= (day+"-"+month+"-"+year);
                char gender='M';
                if(maleButton.isSelected()){
                    gender='M';
                }
                else if(femaleButton.isSelected()){
                    gender='F';
                }
                Director director = MDBS.personFactory.addDirector(name,surname,phone,birthdate,gender);

                try {
                    MDBS.backUp();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Director Succesfully added. You will now being directed back to Admin Panel");
                frame.dispose();
                new MoviePanel(director);
            }
        });
        phoneText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String phoneNumber= phoneText.getText();
                int length=phoneNumber.length();
                char c= e.getKeyChar();

                if(Character.isDigit(c) || e.getKeyChar()==KeyEvent.VK_BACK_SPACE){

                    if (length<10){
                        phoneText.setEditable(true);
                    }
                    else {
                        phoneText.setEditable(false);
                    }
                }
                else {
                    if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE) {
                        phoneText.setEditable(true);
                    }
                    else {
                        phoneText.setEditable(false);
                    }
                }
                if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    phoneText.setEditable(true);
                }
            }
        });
    }
}
