import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePanel extends JPanel implements ActionListener {

    private ImageIcon backgroundImage;
    private JLabel background;

    private JLabel title;
    private JLabel eventLabel;
    private JLabel describeLabel;

    private JButton approval;
    private JButton home;
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

    private JLabel gameCodeLabel;
    private JTextField gameCode;

    public TimePanel() {
        setLayout(null);
        setBackground(new Color(0, 120, 74));


        title = new JLabel("Add Time");
        title.setBounds(325, 10, 500, 100);
        title.setFont(new Font("Segoe Print", Font.BOLD, 40));
        title.setForeground(Color.BLACK);
        add(title);

        // Event label
        eventLabel = new JLabel("Choose Event");
        eventLabel.setBounds(75, 100, 200, 50);
        eventLabel.setFont(new Font("Segoe Print", Font.BOLD, 24));
        add(eventLabel);

        // Describe Label
        describeLabel = new JLabel("Describe your Experience");
        describeLabel.setBounds(400, 100, 300, 50);
        describeLabel.setFont(new Font("Segoe Print", Font.BOLD, 24));
        add(describeLabel);

        // Describe field
        describe = new JTextArea();
        describe.setBounds(400, 170, 450, 200);
        describe.setFont(new Font("Ariel", Font.PLAIN, 16));
        describe.setLineWrap(true);
        add(describe);

        // Event combobox
        event = new JComboBox(events);
        event.addActionListener(this);
        event.setBounds(75, 165, 200, 40);
        add(event);

        // Specific football event label
        specificLabelFootball = new JLabel("Football events");
        specificLabelFootball.setBounds(75, 240, 350, 50);
        specificLabelFootball.setFont(new Font("Segoe Print", Font.BOLD, 24));
        specificLabelFootball.setVisible(false);
        add(specificLabelFootball);

        // Football specific combobox
        specificFootball = new JComboBox(specificEventsFootball);
        specificFootball.setBounds(75, 290, 200, 40);
        specificFootball.setVisible(false);
        add(specificFootball);

        // Specific Basketball event label
        specificLabelBasketball = new JLabel("Basketball events");
        specificLabelBasketball.setBounds(75, 240, 350, 50);
        specificLabelBasketball.setFont(new Font("Segoe Print", Font.BOLD, 24));

        // Basketball specific combobox
        specificBasketball = new JComboBox(specificEventsBasketball);
        specificBasketball.setBounds(75, 290, 210, 40);

        // Specific Volunteer event label
        specificLabelVolunteer = new JLabel("Volunteer Events");
        specificLabelVolunteer.setBounds(75, 240, 350, 50);
        specificLabelVolunteer.setFont(new Font("Segoe Print", Font.BOLD, 24));

        // Volunteer specific combobox
        specificVolunteer = new JComboBox(specificEventsVolunteer);
        specificVolunteer.setBounds(75, 290, 210, 40);

        gameCodeLabel = new JLabel("Enter Game code");
        gameCodeLabel.setBounds(75, 360, 200, 50);
        gameCodeLabel.setFont(new Font("Segoe Print", Font.BOLD, 18));
        add(gameCodeLabel);

        gameCode = new JTextField();
        gameCode.setBounds(75, 400, 200, 35);
        add(gameCode);


        // Approval button
        approval = new JButton("Send for approval");
        approval.addActionListener(this);
        approval.setBounds(400, 460, 225, 33);
        approval.setFocusable(false);
        approval.setBackground(new Color(0, 180, 0));
        approval.setOpaque(true);
        add(approval);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == event) {
            JComboBox cb = (JComboBox)e.getSource();
            String value = (String)cb.getSelectedItem();

            switch(value) {
                case "Football game":
                    specificLabelFootball.setVisible(true);
                    specificFootball.setVisible(true);
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

    }
}
