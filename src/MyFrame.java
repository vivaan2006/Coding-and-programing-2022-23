import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyFrame extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu time;
    private JMenu progress;
    private JMenu leaderBoard;
    private JMenu prizes;
    private JMenuItem prize;
    private JMenu pastWins;
    private JMenuItem PW;
    private JMenuItem tips;
    private  JMenu calendar;
    private JMenu help;
    private JMenuItem faqs;
    private JMenuItem logout;
    private JMenuItem events;
    private JMenuItem standings;
    private JMenuItem profile;
    private JMenuItem addTime;
    private JFrame frame;

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }

    public MyFrame() {

        menuBar = new JMenuBar();
//add time
        time = new JMenu("Add Time"); //sort of like a shopping cart, based on the events attended, attach points.
        time.setPreferredSize(new Dimension(80,30));
        addTime = new JMenuItem("Add Events");
        addTime.addActionListener(this);
        time.add(addTime);
//progress
        progress = new JMenu("My Progress"); //includes points//
        progress.setPreferredSize(new Dimension(80,30));
        profile  = new JMenuItem("View Profile");
        profile.addActionListener(this);
        progress.add(profile);
        menuBar.add(progress);
//leaderboard
        leaderBoard = new JMenu("Leaderboard");
        leaderBoard.setPreferredSize(new Dimension(80,30));
        standings = new JMenuItem("View Current Standings");
        standings.addActionListener(this);
        leaderBoard.add(standings);
        menuBar.add(leaderBoard);


//prizes
        prizes = new JMenu("Prizes");
        prizes.setPreferredSize(new Dimension(80,30));
        prize = new JMenuItem("Prize Shop");
//past winners
        pastWins = new JMenu("Past Winners"); //include random and most points//
        pastWins.setPreferredSize(new Dimension(80,30));
        PW = new JMenuItem("View Past Winners");
        tips = new JMenuItem("Tips to Win");
//calendar
        calendar = new JMenu("Calendar"); //basically events rn//
        calendar.setPreferredSize(new Dimension(80,30));
        events = new JMenuItem("Calendar");

//help
        help = new JMenu("Help");
        help.setPreferredSize(new Dimension(80,30));
        faqs = new JMenuItem("FAQ");
        logout = new JMenuItem("Logout");

        //action listeners//
        time.addActionListener(this);

        progress.addActionListener(this);

        leaderBoard.addActionListener(this);

        prizes.addActionListener(this);
        prize.addActionListener(this);

        pastWins.addActionListener(this);
        PW.addActionListener(this);
        tips.addActionListener(this);

        calendar.addActionListener(this);
        events.addActionListener(this);

        help.addActionListener(this);
        faqs.addActionListener(this);
        logout.addActionListener(this);
        //menubar add//

        help.add(faqs);
        help.add(logout);

        pastWins.add(PW);
        pastWins.add(tips);

        calendar.add(events);

        prizes.add(prize);

        menuBar.add(time);

        menuBar.add(progress);

        menuBar.add(leaderBoard);

        menuBar.add(prizes);

        menuBar.add(pastWins);

        menuBar.add(calendar);

        menuBar.add(help);

        frame = new JFrame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLayout(new FlowLayout());
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTime) {
            frame.dispose();
            Time time = new Time();

        }
        if (e.getSource() == profile) {
            frame.dispose();

        }
        if (e.getSource() == standings) {
            frame.dispose();
        }
        if (e.getSource() == prize) {
            frame.dispose();

        }
        if (e.getSource() == PW) {
            frame.dispose();

        }
        if(e.getSource() == tips){
            frame.dispose();

        }
        //this is the calendar//
        if (e.getSource() == events) {
            frame.dispose();
        }

        if (e.getSource() == logout) {
            frame.dispose();
        }
        if (e.getSource() == faqs) {
            frame.dispose();

        }

    }
}












          
      