import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomePanel extends JPanel implements ActionListener {

    private JPanel anotherPanel;
    private JLabel upcomingEvents;

    // Pictures for slideshow
    private JLabel picture1;
    private ImageIcon pic1;
    private ImageIcon pic2;

    private JRadioButton r1, r2, r3;

    // Portfolio Panel

    private JPanel portfolioPanel;
    private JLabel realName;
    private String dbname;
    private JButton seePoints;
    private JLabel points;

    private Thread thread;

    public HomePanel(String name) {

        dbname = name;

        setLayout(null);
        setBackground(new Color(0, 120, 74));

        anotherPanel = new JPanel();
        anotherPanel.setLayout(null);
        anotherPanel.setBounds(50, 75, 225, 387);
        anotherPanel.setSize(225, 387);
        anotherPanel.setBackground(Color.WHITE);
        add(anotherPanel);

        upcomingEvents = new JLabel("Upcoming Events");
        upcomingEvents.setBounds(60, 20, 200, 60);
        upcomingEvents.setFont(new Font("Calibri", Font.BOLD, 20));
        upcomingEvents.setForeground(Color.BLACK);
        add(upcomingEvents);

        pic1 = new ImageIcon(this.getClass().getResource("images/burningH.png"));
        picture1 = new JLabel(pic1);
        picture1.setBounds(0, 0, 225, 387);
        anotherPanel.add(picture1);

        pic2 = new ImageIcon(this.getClass().getResource("images/hocogame.png"));

        r1 = new JRadioButton();
        r1.setBounds(50, 390, 32, 32);
        anotherPanel.add(r1);

        r2 = new JRadioButton();
        r2.setBounds(90, 390, 32, 32);
        anotherPanel.add(r2);

        thread = new Thread(runnable);
        thread.start();

        portfolioPanel = new JPanel();
        portfolioPanel.setLayout(null);
        portfolioPanel.setBounds(475, 75, 400, 387);
        portfolioPanel.setSize(400, 387);
        portfolioPanel.setBackground(Color.WHITE);
        add(portfolioPanel);

        realName = new JLabel("Name: " + name);
        realName.setBounds(20, 20, 200, 50);
        realName.setFont(new Font("Segoe Print", Font.BOLD, 18));
        realName.setForeground(Color.BLACK);
        portfolioPanel.add(realName);

        seePoints = new JButton("Your points");
        seePoints.addActionListener(this);
        seePoints.setBounds(20, 75, 150, 33);
        seePoints.setFocusable(false);
        seePoints.setBackground(new java.awt.Color(0, 180, 0));
        seePoints.setOpaque(true);
        portfolioPanel.add(seePoints);

        points = new JLabel();
        points.setBounds(20, 120, 200, 30);
        points.setFont(new Font("Calibri", Font.BOLD, 20));
        points.setForeground(Color.BLACK);
        portfolioPanel.add(points);

    }

    Runnable runnable = ()-> {
        try {
            while(true) {
                thread.sleep(3000);
                picture1.setIcon(pic2);
                r1.setSelected(false);
                r2.setSelected(true);

                thread.sleep(3000);
                picture1.setIcon(pic1);
                r1.setSelected(true);
                r2.setSelected(false);
            }
        } catch(Exception e) {

        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == seePoints) {
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select userPoints from login_info_student where name='"+dbname+"'");

                if(resultSet.next()) {
                    points.setText("Points: " + resultSet.getInt("userPoints"));
                } else {
                    JOptionPane.showMessageDialog(null, "Name not found");
                }
            } catch(SQLException sqlException) {
                JOptionPane.showMessageDialog(null, "Error in connection");
            }
        }
    }
}