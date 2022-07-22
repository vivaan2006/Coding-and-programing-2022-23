import javax.swing.*;
import java.awt.*;

public class MainPage {
    private JFrame frame;
    private JLabel testLabel;

    public MainPage(String userID) {

        // Test Label
        testLabel = new JLabel("Test");
        testLabel.setBounds(100, 100, 300, 50);
        testLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
        testLabel.setText("Hello " + userID);


        frame = new JFrame("Main Page");
        frame.add(testLabel);
        frame.setSize(840, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
