import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PrizePanel extends JPanel implements ActionListener {

    private JLabel totalPoints;
    private JButton pointsButton;
    private int dbPoints;
    private String dbName;

    // Points for items
    private int homeworkPassPoints = 100;
    private int hoodiePoints = 1000;

    private JButton homeworkPass;
    private ImageIcon homeworkImage;
    private JLabel homework;

    private JButton hoodieButton;
    private ImageIcon hoodieImage;
    private JLabel hoodie;



    public PrizePanel(String name, int points) {
        setLayout(null);
        setBackground(new Color(0, 120, 74));

        dbPoints = points;
        dbName = name;

        pointsButton = new JButton("Your points");
        pointsButton.addActionListener(this);
        pointsButton.setBounds(20, 30, 150, 33);
        pointsButton.setFocusable(false);
        pointsButton.setBackground(new java.awt.Color(0, 180, 0));
        pointsButton.setOpaque(true);
        add(pointsButton);

        totalPoints = new JLabel("Total points: " + dbPoints);
        totalPoints.setBounds(30, 75, 350, 30);
        totalPoints.setFont(new Font("Segoe Print", Font.BOLD, 16));
        totalPoints.setForeground(Color.BLACK);
        add(totalPoints);

        homeworkImage = new ImageIcon(this.getClass().getResource("images/homeworkpass.png"));
        homework = new JLabel(homeworkImage);
        homework.setBounds(30, 110, 200, 133);
        homework.setSize(200, 133);
        add(homework);

        homeworkPass = new JButton("Homework Pass: " + homeworkPassPoints);
        homeworkPass.addActionListener(this);
        homeworkPass.setBounds(30, 250, 200, 33);
        homeworkPass.setFocusable(false);
        homeworkPass.setBackground(new java.awt.Color(0, 180, 0));
        homeworkPass.setOpaque(true);
        add(homeworkPass);

        hoodieImage = new ImageIcon(this.getClass().getResource("images/hoodie.jpg"));
        hoodie = new JLabel(hoodieImage);
        hoodie.setBounds(280, 110, 200, 133);
        hoodie.setSize(200, 133);
        add(hoodie);

        hoodieButton = new JButton("Hoodie: " + hoodiePoints);
        hoodieButton.addActionListener(this);
        hoodieButton.setBounds(280, 250, 200, 33);
        hoodieButton.setFocusable(false);
        hoodieButton.setBackground(new java.awt.Color(0, 180, 0));
        hoodieButton.setOpaque(true);
        add(hoodieButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pointsButton) {

            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select userPoints from login_info_student where name='" + dbName + "'");

                if(resultSet.next()) {
                    totalPoints.setText("Total Points: " + resultSet.getInt("userPoints"));
                    dbPoints = resultSet.getInt("userPoints");
                }
            } catch (SQLException sqlException) {
                JOptionPane.showMessageDialog(null, "Error in connection");
            }
            System.out.println(dbPoints + "hello");

        }

        if(e.getSource() == homeworkPass) {
            if(dbPoints >= homeworkPassPoints) {
                JOptionPane.showMessageDialog(null, "Purchased Homework Pass");
                dbPoints = dbPoints - homeworkPassPoints;
                totalPoints.setText("Total points: " + dbPoints);

                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("update login_info_student set userPoints='"+dbPoints+"' where name='"+dbName+"'");
                } catch (SQLException sqlException) {
                    JOptionPane.showMessageDialog(null, "Error in connection");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase item");
            }
        }

        if(e.getSource() == hoodieButton) {
            if(dbPoints >= hoodiePoints) {
                JOptionPane.showMessageDialog(null, "Purchased Hoodie");
                dbPoints = dbPoints - hoodiePoints;
                totalPoints.setText("Total points: " + dbPoints);
             } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase item");
            }

        }
    }
}
