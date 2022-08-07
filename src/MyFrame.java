import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener {

    private ImageIcon backgroundImage;
    private JLabel background;

    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu time;
    private JMenu progress;
    private JMenu leaderboard;
    private JMenu prizes;
    private JMenu pastWins;
    private JMenu calendar;
    private JMenu help;

    private JMenuItem addTime;
    private JMenuItem faqs;
    private JMenuItem logout;
    private JMenuItem prize;
    private JMenuItem pastWinners;
    private JMenuItem tips;
    private JMenuItem calendarEvent;
    private JMenuItem standings;
    private JMenuItem profile;

    public MyFrame() {

        // Background Image
        backgroundImage = new ImageIcon(this.getClass().getResource("images/entrybackground.jpg"));
        background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 900, 600);
        background.setSize(900, 600);

        // Menubar
        menuBar = new JMenuBar();
        menuBar.setBounds(50, 50, 200, 100);
        menuBar.setSize(200, 100);

        // Add time
        time = new JMenu("  Add Time ");//sort of like a shopping cart, based on the events attended, attach points.
        time.addActionListener(this);
        addTime = new JMenuItem("Add Events");
        addTime.addActionListener(this);
        time.add(addTime);
        time.setPreferredSize(new Dimension(80,35));

        menuBar.add(time);

        // Progress
        progress = new JMenu("My Progress"); //includes points//
        progress.addActionListener(this);
        profile  = new JMenuItem("View Profile");
        profile.addActionListener(this);
        progress.add(profile);
        menuBar.add(progress);
        progress.setPreferredSize(new Dimension(85,35));


        // Leaderboard
        leaderboard = new JMenu(" Leaderboard");
        leaderboard.addActionListener(this);
        standings = new JMenuItem("View Current Standings");
        standings.addActionListener(this);
        leaderboard.add(standings);
        menuBar.add(leaderboard);
        leaderboard.setPreferredSize(new Dimension(85,35));


        // Prizes
        prizes = new JMenu("      Prizes");
        prizes.addActionListener(this);
        prize = new JMenuItem("Prize shop");
        prize.addActionListener(this);
        prizes.add(prize);
        menuBar.add(prizes);
        prizes.setPreferredSize(new Dimension(80,35));


        // Past winners
        pastWins = new JMenu("Past Winners"); //include random and most points//
        pastWins.addActionListener(this);
        pastWinners = new JMenuItem("View Past Winners");
        pastWinners.addActionListener(this);
        tips = new JMenuItem("Tips to Win");
        tips.addActionListener(this);
        pastWins.add(pastWinners);
        pastWins.add(tips);
        menuBar.add(pastWins);
        pastWins.setPreferredSize(new Dimension(85,35));


        // Calendar
        calendar = new JMenu(" Calender "); //basically events rn//
        calendar.addActionListener(this);
        calendarEvent = new JMenuItem("Calendar");
        calendarEvent.addActionListener(this);
        calendar.add(calendarEvent);
        menuBar.add(calendar);
        calendar.setPreferredSize(new Dimension(80,35));


        // Help Menu
        help = new JMenu("Help");
        help.addActionListener(this);
        faqs = new JMenuItem("FAQ");
        faqs.addActionListener(this);
        logout = new JMenuItem("Logout");
        logout.addActionListener(this);
        help.add(faqs);
        help.add(logout);
        menuBar.add(help);
        help.setPreferredSize(new Dimension(80,35));


        // JFrame
        frame = new JFrame("Main page");
        frame.setSize(900, 600);
        frame.add(background);
        frame.setJMenuBar(menuBar);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTime) {
            frame.dispose();
            LoginScreen loginScreen = new LoginScreen();
        }
        if (e.getSource() == progress) {
            System.out.println("Hallo");
        }
        if (e.getSource() == leaderboard) {
            System.out.println("Hallo");
        }
        if (e.getSource() == prizes) {
            System.out.println("Hallo");
        }
        if (e.getSource() == pastWins) {
            System.out.println("Hallo");
        }
        if (e.getSource() == calendar) {
            System.out.println("Hallo");
        }

        if (e.getSource() == logout) {
            frame.dispose();
            LoginScreen loginScreen = new LoginScreen();
        }
        if (e.getSource() == faqs) {
            System.out.println("Hallo");
        }
    }

}





