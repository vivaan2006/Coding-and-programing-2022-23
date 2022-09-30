import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrizePanel extends JPanel implements ActionListener {

    private JLabel totalPoints;
    private int dbPoints;

    // Points for items
    private int homeworkPassPoints = 100;
    private int hoodiePoints = 1000;

    private JButton homeworkPass;
    private ImageIcon homeworkImage;
    private JLabel homework;

    private JButton hoodieButton;
    private ImageIcon hoodieImage;
    private JLabel hoodie;



    public PrizePanel(int points) {
        setLayout(null);
        setBackground(new Color(0, 120, 74));

        dbPoints = points;

        components();


    }

    public void components() {
        totalPoints = new JLabel("Total points: " + dbPoints);
        totalPoints.setBounds(30, 20, 350, 30);
        totalPoints.setFont(new Font("Segoe Print", Font.BOLD, 16));
        totalPoints.setForeground(Color.BLACK);
        add(totalPoints);

        homeworkImage = new ImageIcon(this.getClass().getResource("images/homeworkpass.png"));
        homework = new JLabel(homeworkImage);
        homework.setBounds(30, 80, 200, 133);
        homework.setSize(200, 133);
        add(homework);

        homeworkPass = new JButton("Homework Pass: " + homeworkPassPoints);
        homeworkPass.addActionListener(this);
        homeworkPass.setBounds(30, 220, 200, 33);
        homeworkPass.setFocusable(false);
        homeworkPass.setBackground(new java.awt.Color(0, 180, 0));
        homeworkPass.setOpaque(true);
        add(homeworkPass);

        hoodieImage = new ImageIcon(this.getClass().getResource("images/hoodie.jpg"));
        hoodie = new JLabel(hoodieImage);
        hoodie.setBounds(280, 80, 200, 133);
        hoodie.setSize(200, 133);
        add(hoodie);

        hoodieButton = new JButton("Hoodie: " + hoodiePoints);
        hoodieButton.addActionListener(this);
        hoodieButton.setBounds(280, 220, 200, 33);
        hoodieButton.setFocusable(false);
        hoodieButton.setBackground(new java.awt.Color(0, 180, 0));
        hoodieButton.setOpaque(true);
        add(hoodieButton);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == homeworkPass) {
            if(dbPoints >= homeworkPassPoints) {
                JOptionPane.showMessageDialog(null, "Purchased Homework Pass");
                dbPoints = dbPoints - homeworkPassPoints;
                totalPoints.setText("Total points: " + dbPoints);
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