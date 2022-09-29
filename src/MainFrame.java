import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {

    private JFrame frame;
    private JPanel buttonPanel;


    private JPanel logoutPanel;
    private ImageIcon logoutIcon;
    private JButton logout;

    private JLabel dashboard;

    // Tabbed pane

    public MainFrame(String name) {

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(0, 120,74));
        buttonPanel.setBounds(0, 0, 1000, 600);
        buttonPanel.setSize(1000, 600);
        buttonPanel.setBorder(new EmptyBorder(15, 0, 10, 0));

        frame = new JFrame("Main Screen");
        frame.add(buttonPanel);
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        var tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 16));
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:roboto;color:white'>Dashboard</body></html>", new HomePanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:roboto;color:white'>Calendar</body></html>", new CalendarPanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:roboto;color:white'>Prizes</body></html>", new PrizePanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:roboto;color:white'>Add points</body></html>", new TimePanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:roboto;color:white'>Events</body></html>", new TimePanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:roboto;color:white'>Find Friends</body></html>", new TimePanel());
        tabbedPane.setBounds(20,20,960,600);
        tabbedPane.setBackground(new Color(38, 78, 54));
        tabbedPane.setForeground(Color.white);
        buttonPanel.add(tabbedPane);

        logoutPanel = new JPanel();
        logoutPanel.setLayout(null);
        logoutPanel.setBackground(new Color(0, 58, 120));
        logoutPanel.setBounds(860, 0, 100, 100);
        logoutPanel.setSize(100, 100);
        buttonPanel.add(logoutPanel);

        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setBounds(0, 0, 100, 55);
        logout.setFocusable(false);
        logout.setBackground(new java.awt.Color(0, 180, 0));
        logout.setOpaque(true);
        logoutPanel.add(logout);







        UIManager.put("TabbedPane.borderHightlightColor",new Color(38, 78, 54));
        UIManager.put("TabbedPane.darkShadow",new Color(38, 78, 54));
        UIManager.put("TabbedPane.light",new Color(38, 78, 54));
        UIManager.put("TabbedPane.selectHighlight",new Color(38, 78, 54));
        UIManager.put("TabbedPane.darkShadow",new Color(38, 78, 54));
        UIManager.put("TabbedPane.focus",new Color(38, 78, 54));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logout) {
            LoginScreen loginScreen = new LoginScreen();
        }

    }
}
