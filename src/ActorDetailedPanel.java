import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActorDetailedPanel {
    private JTextArea nameArea;
    private JTextArea surnameArea;
    private JTextArea phoneArea;
    private JTextArea birthdateArea;
    private JTextArea genderArea;
    private JPanel panel1;
    private JTextArea moviesText;

    ActorDetailedPanel(Actor actor){
        nameArea.setText(actor.getName());
        surnameArea.setText(actor.getSurname());
        phoneArea.setText(actor.getPhone());
        birthdateArea.setText(actor.getBirthDate().toString());
        genderArea.setText(String.valueOf(actor.getGender()));
        String movie_str="";
        for(Movie movie: actor.getMovies()){
            movie_str+=movie.getName()+",";
        }
        moviesText.setText(movie_str);
        JFrame frame = new JFrame(actor.getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
