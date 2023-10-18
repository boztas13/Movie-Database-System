import javax.swing.*;
import java.awt.*;

public class MovieDetailedPanel {
    private JTextArea descriptionText;
    private JPanel panel1;

    private JTextArea nameText;
    private JTextArea ratingText;
    private JTextArea durationText;
    private JTextArea categoryText;
    private JTextArea releasedateText;
    private JFrame frame;
    private JScrollPane scroll;
    MovieDetailedPanel(Movie movie){


        nameText.setText(movie.getName());
        ratingText.setText(String.valueOf(movie.getRate()));
        durationText.setText(String.valueOf(movie.getDuration()));
        releasedateText.setText(movie.getReleaseDate().toString());
        descriptionText.setText(movie.getDescription());
        categoryText.setText(movie.getCategory());
        scroll=new JScrollPane(descriptionText);
        descriptionText.setSize(200,60);
        descriptionText.setLineWrap(true);
        descriptionText.setEditable(false);
        descriptionText.setVisible(true);


        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame=new JFrame(movie.getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setResizable(false);

        frame.add(panel1);
        frame.getContentPane().add(scroll,  BorderLayout.AFTER_LINE_ENDS);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
