import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame implements ActionListener, MouseListener {

    private JFrame frame;
    private JPanel buttonPanel;


    private JPanel logoutPanel;
    private ImageIcon logoutIcon;
    private JLabel logout;

    private JLabel dashboard;
    private JLabel logoutButton;
    // Tabbed pane

    public MainFrame(String name, int points) {

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(49, 83, 153));
        buttonPanel.setBounds(0, 0, 1000, 600);
        buttonPanel.setSize(1000, 600);
        buttonPanel.setBorder(new EmptyBorder(15, 0, 10, 0));

        frame = new JFrame("Main Screen");
        frame.add(buttonPanel);
        frame.setSize(1018, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        var tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:Tahoma;color:white'>Dashboard</body></html>", new HomePanel(name));
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:Tahoma;color:white'>Calendar</body></html>", new CalendarPanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:Tahoma;color:white'>Prizes</body></html>", new PrizePanel(name, points));
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:Tahoma;color:white'>Add points</body></html>", new TimePanel(name, points));
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:Tahoma;color:white'>Leaderboard</body></html>", new CalendarPanel());
        tabbedPane.addTab("<html><body leftmargin=10 topmargin=8 marginwidth=10 marginheight=5 style='font-family:Tahoma;color:white'>Find Friends</body></html>", new CalendarPanel());
        tabbedPane.setBounds(25,20,960,600);
        tabbedPane.setBackground(new Color(0, 255, 0));
        tabbedPane.setForeground(Color.white);
        buttonPanel.add(tabbedPane);


        logoutPanel = new JPanel();
        logoutPanel.setLayout(null);
        logoutPanel.setBackground(new Color(49, 83, 153));
        logoutPanel.setBounds(860, 10, 100, 40);
        logoutPanel.setSize(100, 40);
        buttonPanel.add(logoutPanel);


        logoutButton = new JLabel(new ImageIcon(this.getClass().getResource("images/logout.png")));
        logoutButton.addMouseListener(this);
        logoutButton.setBounds(0, 0, 100, 40);
        logoutButton.setSize(100, 40);
        logoutButton.setForeground(Color.WHITE);
        logoutPanel.add(logoutButton);


        UIManager.put("TabbedPane.borderHightlightColor",new Color(255, 0, 0));
        UIManager.put("TabbedPane.darkShadow",new Color(246, 0, 0));
        UIManager.put("TabbedPane.light",new Color(243, 3, 3));
        UIManager.put("TabbedPane.selectHighlight",new Color(241, 9, 9));
        UIManager.put("TabbedPane.darkShadow",new Color(236, 6, 6));
        UIManager.put("TabbedPane.focus",new Color(236, 6, 6));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logoutButton) {
            LoginScreen loginScreen = new LoginScreen();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == logoutButton) {
            frame.dispose();
            LoginScreen loginScreen = new LoginScreen();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        logoutPanel.setBackground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        logoutPanel.setBackground(new Color(255, 252, 252));
    }
}
