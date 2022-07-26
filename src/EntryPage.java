import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryPage implements ActionListener {
    private JFrame frame;
    private ImageIcon backgroundImage;
    private JLabel background;
    private JLabel title1;
    private JLabel title2;
    private JLabel description;
    private JLabel boxDescription;
    private String[] optionsToChoose = {"Choose Login", "Student Login", "Administrator Login"};
    private JComboBox options;

    IDandPasswordsStudent ids = new IDandPasswordsStudent();
    IDandPasswordsAdmin idsAdmin = new IDandPasswordsAdmin();

    public EntryPage() {

        // Background Image
        backgroundImage = new ImageIcon(this.getClass().getResource("images/entryBackground.jpg"));
        background = new JLabel(backgroundImage);
        background.setSize(640, 500);

        // Title - Part 1
        title1 = new JLabel("Welcome to");
        title1.setBounds(207, 125, 300, 50);
        title1.setFont(new Font("Segoe Print", Font.BOLD, 39));
        title1.setForeground(Color.WHITE);
        background.add(title1);

        // Title - Part 2
        title2 = new JLabel("Hillcrest Spirit");
        title2.setBounds(175, 185, 400, 50);
        title2.setFont(new Font("Segoe Print", Font.BOLD, 39));
        title2.setForeground(Color.WHITE);
        background.add(title2);

        // Description
        description = new JLabel("Come Support Your Huskies");
        description.setBounds(175, 250, 300, 50);
        description.setFont(new Font("Segoe Print", Font.BOLD, 20));
        description.setForeground(Color.WHITE);
        background.add(description);

        //Box description
        boxDescription = new JLabel("Choose your login Style");
        boxDescription.setBounds(215, 340, 220, 30);
        boxDescription.setFont(new Font("Segoe Print", Font.BOLD, 18));
        boxDescription.setForeground(Color.WHITE);
        background.add(boxDescription);

        // Combo Box
        options = new JComboBox(optionsToChoose);
        options.setBounds(225, 400, 180, 30);
        options.setSelectedIndex(0);
        options.addActionListener(this);

        background.add(options);

        frame = new JFrame("Entry Screen");
        frame.add(background);
        frame.setSize(640, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == options) {
            JComboBox cb = (JComboBox)e.getSource();
            String message = (String)cb.getSelectedItem();
            switch (message) {
                case "Student Login":
                    LoginScreenStudent login = new LoginScreenStudent(ids.getLoginInfo());
                    frame.dispose();
                    break;

                case "Administrator Login":
                    LoginScreenAdmin login1 = new LoginScreenAdmin(idsAdmin.getLoginInfo());
                    frame.dispose();
                    break;
            }
        }

    }
}
