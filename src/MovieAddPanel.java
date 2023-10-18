import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MovieAddPanel {
    private JTextField nameText;
    private JTextField durationText;
    private JTextField categoryText;
    private JTextField descriptionText;
    private JPanel panel1;
    private JButton addButton;
    private JComboBox dayBox;
    private JComboBox monthBox;
    private JComboBox yearBox;

    public MovieAddPanel() {
        JFrame frame = new JFrame("Add Movie");
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

        durationText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c= e.getKeyChar();
                if(Character.isDigit(c) || e.getKeyChar()==KeyEvent.VK_BACK_SPACE) {

                    durationText.setEditable(true);
                }
                else {
                    if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE) {
                        durationText.setEditable(true);
                    }
                    else {
                        durationText.setEditable(false);
                    }
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameText.getText();
                String category=categoryText.getText();
                int duration = Integer.parseInt(durationText.getText());
                String description=descriptionText.getText();
                int day = (Integer) dayBox.getSelectedItem();
                int month = (Integer) monthBox.getSelectedItem();
                int year = (Integer) yearBox.getSelectedItem();
                String birthdate= (day+"-"+month+"-"+year);


                MDBS.movieFactory.addMovie(name,duration,category,birthdate,description);


                try {
                    MDBS.backUp();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Movie Succesfully added. You will now being directed back to Admin Panel");
                frame.dispose();
                new AdminPanel();
            }
        });
    }
}
