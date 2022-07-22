import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginScreen implements ActionListener {
    private JFrame frame;
    private ImageIcon backgroundImage;
    private JLabel background;
    private JLabel title;
    private JLabel centerTitle;
    private ImageIcon logoImage;
    private JLabel logo;
    private JLabel userID;
    private JLabel password;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public LoginScreen(HashMap<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        // Background image
        backgroundImage = new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background = new JLabel(backgroundImage);
        background.setSize(840, 600);

        // Top Left title for logo
        title = new JLabel("Hillcrest Spirit");
        title.setBounds(20, 30, 180, 50);
        title.setFont(new Font("Serif", Font.BOLD, 18));
        title.setForeground(Color.BLACK);
        background.add(title);

        // Logo
        logoImage = new ImageIcon(this.getClass().getResource("images/podium.png"));
        logo = new JLabel(logoImage);
        logo.setSize(30, 30);
        logo.setBounds(110, 20, 100, 50);
        background.add(logo);


        // Main student login title
        centerTitle = new JLabel("Student Login");
        centerTitle.setBounds(275, 100, 350, 100);
        centerTitle.setFont(new Font("Segoe Print", Font.BOLD, 36));
        centerTitle.setForeground(Color.BLACK);
        background.add(centerTitle);

        // UserID text
        userID = new JLabel("Student ID");
        userID.setBounds(275, 200, 100, 50);
        userID.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(userID);

        // password text
        password = new JLabel("Password");
        password.setBounds(275, 300, 100, 50);
        password.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(password);

        // UserID Field
        userIDField = new JTextField();
        userIDField.setBounds(275, 240, 275, 33);
        background.add(userIDField);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(275, 340, 275, 33);
        background.add(passwordField);

        // Login Button
        loginButton = new JButton("Log In");
        loginButton.addActionListener(this);
        loginButton.setBounds(275, 440, 275, 33);
        loginButton.setFocusable(false);
        loginButton.setBackground(new java.awt.Color(0, 180, 0));
        loginButton.setOpaque(true);
        background.add(loginButton);

        // Message Label
        messageLabel = new JLabel();
        messageLabel.setBounds(275, 500, 200, 50);
        messageLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
        background.add(messageLabel);

        // Frame
        frame = new JFrame("Login Screen");
        frame.add(background);
        frame.setSize(840, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if(loginInfo.containsKey(userID)) {
                if(loginInfo.get(userID).equals(password)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    MainPage main = new MainPage(userID);
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                }
            } else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Student Not found");
            }

        }
    }
}
