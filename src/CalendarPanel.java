import javax.swing.*;
import java.awt.*;

public class CalendarPanel extends JPanel {
    public CalendarPanel() {
        setLayout(null);
        setBackground(new Color(38, 78, 54));
        // this is the title
        var tQuestions = new JLabel("Top Questions");
        tQuestions.setFont(new Font("Arial", Font.BOLD, 20));
        tQuestions.setForeground(Color.WHITE);
        tQuestions.setBounds(90,20,140,25);
        add(tQuestions);

        // i used constructor with a position becuase i'm using it inside dashboard .... because dashboard had null layout
        int positionY = 0;


        // this is the title
        var tLessons = new JLabel("Top Lessons");
        tLessons.setFont(new Font("Arial", Font.BOLD, 20));
        tLessons.setForeground(Color.WHITE);
        tLessons.setBounds(420,20,140,25);
        add(tLessons);

        // i used constructor with a position becuase i'm using it inside dashboard .... because dashboard had null layout
        positionY = 0;


        // this is the title
        var tSubjects = new JLabel("Top Subjects");
        tSubjects.setFont(new Font("Arial", Font.BOLD, 20));
        tSubjects.setForeground(Color.WHITE);
        tSubjects.setBounds(740,20,140,25);
        add(tSubjects);

        // i used constructor with a position becuase i'm using it inside dashboard .... because dashboard had null layout
        positionY = 0;

    }
}