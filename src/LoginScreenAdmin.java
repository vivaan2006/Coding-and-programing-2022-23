import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginScreenAdmin implements ActionListener {

    private JFrame frame;
    private ImageIcon backgroundImage;
    private JLabel background;

    private JPanel panel;
    private ImageIcon logoImage;
    private JLabel title;

    private JLabel adminCenterTitle;
    private JLabel adminUserID;
    private JLabel adminPassword;
    private JTextField adminIDField;
    private JPasswordField adminPasswordField;
    private JButton adminLoginButton;

    private JLabel messageLabel;

    public LoginScreenAdmin() {

        // Background image
        backgroundImage = new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background = new JLabel(backgroundImage);
        background.setBounds(300, 0, 1000, 600);
        background.setSize(1000, 600);

        // Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(0, 120, 74));
        panel.setBounds(0, 0, 300, 600);
        panel.setSize(300, 600);


        // Logo Image
        logoImage = new ImageIcon(this.getClass().getResource("images/logo.png"));
        title = new JLabel(logoImage);
        title.setBounds(20, 150, 250, 170);
        panel.add(title);

        // Admin title
        adminCenterTitle = new JLabel("Admin Login");
        adminCenterTitle.setBounds(150, 65, 350, 100);
        adminCenterTitle.setFont(new Font("Segoe Print", Font.BOLD, 32));
        adminCenterTitle.setForeground(Color.BLACK);
        background.add(adminCenterTitle);

        // Admin UserID text
        adminUserID = new JLabel("Admin ID");
        adminUserID.setBounds(150, 175, 100, 50);
        adminUserID.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(adminUserID);

        // Admin password text
        adminPassword = new JLabel("Password");
        adminPassword.setBounds(150, 275, 100, 50);
        adminPassword.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(adminPassword);

        // Admin UserID Field
        adminIDField = new JTextField();
        adminIDField.setBounds(150, 215, 225, 33);
        background.add(adminIDField);

        // Admin Password Field
        adminPasswordField = new JPasswordField();
        adminPasswordField.setBounds(150, 315, 225, 33);
        background.add(adminPasswordField);

        // Admin Login Button
        adminLoginButton = new JButton("Log In");
        adminLoginButton.addActionListener(this);
        adminLoginButton.setBounds(150, 415, 225, 33);
        adminLoginButton.setFocusable(false);
        adminLoginButton.setBackground(new java.awt.Color(0, 180, 0));
        adminLoginButton.setOpaque(true);
        background.add(adminLoginButton);

        messageLabel = new JLabel();
        messageLabel.setBounds(140, 500, 400, 50);
        messageLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
        background.add(messageLabel);

        frame = new JFrame("Login Screen");
        frame.add(background);
        frame.add(panel);
        frame.setSize(800, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        LoginScreenAdmin loginScreenAdmin = new LoginScreenAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adminLoginButton) {
            String adminUserID = adminIDField.getText();
            String adminPassword = String.valueOf(adminPasswordField.getPassword());

            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from login_info_admin");

                while(resultSet.next()) {
                    if(resultSet.getString("admin_id").equals(adminUserID) && resultSet.getString("password").equals(adminPassword)) {
                        messageLabel.setForeground(Color.GREEN);
                        messageLabel.setText("Login Successful");
                        frame.dispose();
                        MainFrame frame = new MainFrame(resultSet.getString("name"));
                    }
                    else {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Wrong Username or password");
                    }
                }
            } catch(SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }
    }
}
