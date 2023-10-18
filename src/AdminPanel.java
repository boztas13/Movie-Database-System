import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {


    private JRadioButton addMovieRadioButton;
    private JRadioButton addActorRadioButton;
    private JRadioButton logoutRadioButton;
    private JRadioButton addDirectorRadioButton;
    private JButton nextButton;
    private JPanel panel1;

    public AdminPanel() {
        JFrame frame = new JFrame("Admin Page");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (addMovieRadioButton.isSelected()){


                    new MovieAddPanel();
                }
                else if(addActorRadioButton.isSelected()){
                    new ActorAddPanel();
                }
                else if(addDirectorRadioButton.isSelected()){
                    new DirectorAddPanel();
                }
                else if(logoutRadioButton.isSelected()){
                    Login.logout();
                    new LoginForm();
                }
            }
        });
    }







}
