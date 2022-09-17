import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {

    private JFrame frame;
    private JPanel buttonPanel;

    private JLabel dashboard;

    // Tabbed pane
    private JTabbedPane tabbedPane;

    // Panels
    private JPanel homePanel;
    private JPanel calendarPanel;


    public MainFrame(String name) {

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1));
        buttonPanel.setBackground(new Color(0, 120,74));
        buttonPanel.setBounds(0, 0, 1000, 125);
        buttonPanel.setSize(1000, 125);

        frame = new JFrame("Main Screen");
        frame.add(buttonPanel);
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        tabbedPane = new JTabbedPane();
        buttonPanel.add(tabbedPane);

        homePanel = new JPanel();
        tabbedPane.add("Home", homePanel);












    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
