import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrizePanel extends JPanel implements ActionListener {
    //overall ones
    private JLabel totalPoints;
    private int points;

    // Points for items
    private int homeworkPassPoints = 100;
    private int hoodiePoints = 1000;
    private int pizzaPoints = 500;
    private int gymPoints = 2000;
    private int amazonPoints = 500;
    private int posterPoints = 500;
//JButtons for prizes
    private JButton homeworkPass;
    private JButton hoodieButton;
    private JButton pizzaButton;
    private JButton gymButton;
    private JButton amazonButton;
    private JButton posterButton;
    //images type
    private ImageIcon homeworkImage;
    private ImageIcon hoodieImage;
    private ImageIcon pizzaImage;
    private ImageIcon gymImage;
    private ImageIcon amazonImage;
    private ImageIcon posterImage;

    //JLabels for prizes
    private JLabel homework;
    private JLabel pizza;
    private JLabel hoodie;
    private JLabel gym;
    private JLabel amazon;
    private JLabel poster;
    public PrizePanel() {
        setLayout(null);
        setBackground(new Color(0, 120, 74));
        components();
    }

    public void components() {
        //total points
        totalPoints = new JLabel("Total points: " + points);
        totalPoints.setBounds(30, 20, 350, 30);
        totalPoints.setFont(new Font("Segoe Print", Font.BOLD, 16));
        totalPoints.setForeground(Color.BLACK);
        add(totalPoints);
        // Images

            //hw image

        homeworkImage = new ImageIcon(this.getClass().getResource("images/homeworkpass.png"));
        homework = new JLabel(homeworkImage);
        homework.setBounds(30, 80, 200, 133);
        homework.setSize(200, 133);
        add(homework);
            //hoodie image

        hoodieImage = new ImageIcon(this.getClass().getResource("images/hoodie.jpg"));
        hoodie = new JLabel(hoodieImage);
        hoodie.setBounds(280, 80, 200, 133);
        hoodie.setSize(200, 133);
        add(hoodie);

            //pizza image
        pizzaImage = new ImageIcon(this.getClass().getResource("images/pizzaa.jpeg"));
        pizza = new JLabel(pizzaImage);
        pizza.setBounds(30, 320, 200, 133);
        pizza.setSize(200, 133);
        add(pizza);

        //membership image
        gymImage = new ImageIcon(this.getClass().getResource("images/Gym.jpeg"));
        gym = new JLabel(gymImage);
        gym.setBounds(530, 80, 200, 133);
        gym.setSize(200, 133);
        add(gym);

        //amazon gift card
        amazonImage = new ImageIcon(this.getClass().getResource("images/Giftcard.jpeg"));
        amazon = new JLabel(amazonImage);
        amazon.setBounds(280, 320, 200, 133);
        amazon.setSize(200, 133);
        add(amazon);

        // poster image
        posterImage = new ImageIcon(this.getClass().getResource("images/poster.jpeg"));
        poster = new JLabel(posterImage);
        poster.setBounds(530, 320, 200, 133);
        poster.setSize(200, 133);
        add(poster);

            // JButtons for images
        homeworkPass = new JButton("Homework Pass: " + homeworkPassPoints);
        homeworkPass.addActionListener(this);
        homeworkPass.setBounds(30, 220, 200, 33);
        homeworkPass.setFocusable(false);
        homeworkPass.setBackground(new java.awt.Color(0, 180, 0));
        homeworkPass.setOpaque(true);
        add(homeworkPass);

        hoodieButton = new JButton("Hoodie: " + hoodiePoints);
        hoodieButton.addActionListener(this);
        hoodieButton.setBounds(280, 220, 200, 33);
        hoodieButton.setFocusable(false);
        hoodieButton.setBackground(new java.awt.Color(0, 180, 0));
        hoodieButton.setOpaque(true);
        add(hoodieButton);

        pizzaButton = new JButton("Free Pizza: " + pizzaPoints);
        pizzaButton.addActionListener(this);
        pizzaButton.setBounds(30, 460, 200, 33);
        pizzaButton.setFocusable(false);
        pizzaButton.setBackground(new java.awt.Color(0, 180, 0));
        pizzaButton.setOpaque(true);
        add(pizzaButton);

        gymButton = new JButton("One Month Gym access: " + gymPoints);
        gymButton.addActionListener(this);
        gymButton.setBounds(530, 220, 200, 33);
        gymButton.setFocusable(false);
        gymButton.setBackground(new java.awt.Color(0, 180, 0));
        gymButton.setOpaque(true);
        add(gymButton);

        amazonButton = new JButton("$5 Amazon Gift Card: " + amazonPoints);
        amazonButton.addActionListener(this);
        amazonButton.setBounds(280, 460, 200, 33);
        amazonButton.setFocusable(false);
        amazonButton.setBackground(new java.awt.Color(0, 180, 0));
        amazonButton.setOpaque(true);
        add(amazonButton);

        posterButton = new JButton("Hillcrest Poster: " + posterPoints);
        posterButton.addActionListener(this);
        posterButton.setBounds(530, 460, 200, 33);
        posterButton.setFocusable(false);
        posterButton.setBackground(new java.awt.Color(0, 180, 0));
        posterButton.setOpaque(true);
        add(posterButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == homeworkPass) {
            if(points >= homeworkPassPoints) {
                JOptionPane.showMessageDialog(null, "Purchased Homework Pass");
                points = points - homeworkPassPoints;
                totalPoints.setText("Total points: " + points);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase homework pass");
            }
        }

        if(e.getSource() == hoodieButton) {
            if(points >= hoodiePoints) {
                JOptionPane.showMessageDialog(null, "Purchased Hoodie");
                points = points - hoodiePoints;
                totalPoints.setText("Total points: " + points);
             } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase hoodie");
            }

        }
        if(e.getSource() == pizzaButton) {
            if(points >= pizzaPoints) {
                JOptionPane.showMessageDialog(null, "Purchased Free Pizza. Show this message to cafeteria");
                points = points - pizzaPoints;
                totalPoints.setText("Total points: " + points);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase pizza");
            }
        }
        if(e.getSource() == gymButton) {
            if(points >= gymPoints) {
                JOptionPane.showMessageDialog(null, "Purchased One month Gym Membership.");
                points = points - gymPoints;
                totalPoints.setText("Total points: " + points);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase membership");
            }
        }
        if(e.getSource() == amazonButton) {
            if(points >= amazonPoints) {
                JOptionPane.showMessageDialog(null, "Purchased Amazon Gift Card.");
                points = points - amazonPoints;
                totalPoints.setText("Total points: " + points);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase gift card");
            }
        }
        if(e.getSource() == posterButton) {
            if(points >= posterPoints) {
                JOptionPane.showMessageDialog(null, "Purchased Poster");
                points = points - posterPoints;
                totalPoints.setText("Total points: " + points);
            } else {
                JOptionPane.showMessageDialog(null, "Not enough points to purchase poster");
            }
        }
    }
}