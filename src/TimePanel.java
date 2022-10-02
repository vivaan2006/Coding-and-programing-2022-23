import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TimePanel extends JPanel implements ActionListener {

    private ImageIcon backgroundImage;
    private JLabel background;

    private JLabel title;
    private JLabel eventLabel;
    private JLabel describeLabel;

    private JButton approval;
    private JButton home;
    private JButton showPoints;
    private JTextArea describe;

    private JComboBox event;
    private String[] events = {"Choose activity", "Football game", "Basketball game", "Volunteer"};

    private JLabel specificLabelFootball;
    private JComboBox specificFootball;
    private String[] specificEventsFootball = {"Choose specific event", "Carbon @ Hillcrest", "Stansbury @ Hillcrest", "Jordan @ Hillcrest"};

    private JLabel specificLabelBasketball;
    private JComboBox specificBasketball;
    private String[] specificEventsBasketball = {"Choose specific event", "Murray @ Hillcrest", "Uintah @ Hillcrest", "Bingham @ Hillcrest"};

    private JLabel specificLabelVolunteer;
    private JComboBox specificVolunteer;
    private String[] specificEventsVolunteer = {"Choose specific event", "Animal shelter", "Tutoring", "CVHS Grader"};

    private int dbPoints;
    private String dbName;
    public TimePanel(String name, int points) {
        setLayout(null);
        setBackground(new Color(0, 120, 74));

        dbName = name;
        dbPoints = points;


        title = new JLabel("Add Time");
        title.setBounds(325, 10, 500, 100);
        title.setFont(new Font("Segoe Print", Font.BOLD, 40));
        title.setForeground(Color.BLACK);
        add(title);

        // Event label
        eventLabel = new JLabel("Choose Event");
        eventLabel.setBounds(75, 160, 200, 50);
        eventLabel.setFont(new Font("Segoe Print", Font.BOLD, 24));
        add(eventLabel);

        // Describe Label
        describeLabel = new JLabel("Describe your Experience");
        describeLabel.setBounds(400, 160, 330, 50);
        describeLabel.setFont(new Font("Segoe Print", Font.BOLD, 24));
        add(describeLabel);

        // Describe field
        describe = new JTextArea();
        describe.setBounds(400, 230, 450, 200);
        describe.setFont(new Font("Ariel", Font.PLAIN, 16));
        describe.setLineWrap(true);
        add(describe);

        // Event combobox
        event = new JComboBox(events);
        event.addActionListener(this);
        event.setBounds(75, 225, 200, 40);
        add(event);

        // Specific football event label
        specificLabelFootball = new JLabel("Football events");
        specificLabelFootball.setBounds(75, 300, 350, 50);
        specificLabelFootball.setFont(new Font("Segoe Print", Font.BOLD, 24));

        // Football specific combobox
        specificFootball = new JComboBox(specificEventsFootball);
        specificFootball.setBounds(75, 350, 200, 40);

        // Specific Basketball event label
        specificLabelBasketball = new JLabel("Basketball events");
        specificLabelBasketball.setBounds(75, 300, 350, 50);
        specificLabelBasketball.setFont(new Font("Segoe Print", Font.BOLD, 24));

        // Basketball specific combobox
        specificBasketball = new JComboBox(specificEventsBasketball);
        specificBasketball.setBounds(75, 350, 210, 40);

        // Specific Volunteer event label
        specificLabelVolunteer = new JLabel("Volunteer Events");
        specificLabelVolunteer.setBounds(75, 300, 350, 50);
        specificLabelVolunteer.setFont(new Font("Segoe Print", Font.BOLD, 24));

        // Volunteer specific combobox
        specificVolunteer = new JComboBox(specificEventsVolunteer);
        specificVolunteer.setBounds(75, 350, 210, 40);

        // Approval button
        approval = new JButton("Send for approval");
        approval.addActionListener(this);
        approval.setBounds(400, 460, 225, 33);
        approval.setFocusable(false);
        approval.setBackground(new Color(0, 180, 0));
        approval.setOpaque(true);
        add(approval);

        showPoints = new JButton("Reset");
        showPoints.addActionListener(this);
        showPoints.setBounds(20, 460, 225, 33);
        showPoints.setFocusable(false);
        showPoints.setBackground(new Color(0, 180, 0));
        showPoints.setOpaque(true);
        add(showPoints);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == event) {
            JComboBox cb = (JComboBox)e.getSource();
            String value = (String)cb.getSelectedItem();

            switch(value) {
                case "Football game":
                    add(specificLabelFootball);
                    add(specificFootball);
                    break;

                case "Basketball game":
                    add(specificLabelBasketball);
                    add(specificBasketball);
                    break;

                case "Volunteer":
                    add(specificLabelVolunteer);
                    add(specificVolunteer);
                    break;

            }
        }

        if(e.getSource() == showPoints) {
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select userPoints from login_info_student where name='" + dbName + "'");

                if(resultSet.next()) {
                    dbPoints = resultSet.getInt("userPoints");
                }

            } catch (SQLException sqlException) {
                JOptionPane.showMessageDialog(null, "Error in connection");
            }
            System.out.println(dbPoints);
        }

        if(e.getSource() == approval) {

                dbPoints = dbPoints + 100;
                JOptionPane.showMessageDialog(null, "Added 100 points");
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("update login_info_student set userPoints='"+dbPoints+"' where name='"+dbName+"'");

                } catch (SQLException sqlException) {
                    JOptionPane.showMessageDialog(null, "Error in connection");
                }
            }




    }
}
