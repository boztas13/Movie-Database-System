import javax.swing.*;
import java.awt.*;

public class DirectorDetailedPanel {
    private JTextArea nameArea;
    private JTextArea surnameArea;
    private JTextArea phoneArea;
    private JTextArea birthdateArea;
    private JTextArea genderArea;
    private JPanel panel1;
    private JTextArea movieText;

    DirectorDetailedPanel(Director director){
        nameArea.setText(director.getName());
        surnameArea.setText(director.getSurname());
        phoneArea.setText(director.getPhone());
        birthdateArea.setText(director.getBirthDate().toString());
        genderArea.setText(String.valueOf(director.getGender()));
        String movie_str="";
        for(Movie movie: director.getMovies()){
            movie_str+=movie.getName()+",";
        }
        movieText.setText(movie_str);
        JFrame frame = new JFrame(director.getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
