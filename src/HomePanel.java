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

    private Thread thread;


    private JButton tableViewer;


    public HomePanel() {
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
        if (e.getSource() == tableViewer) {

        }
    }
}