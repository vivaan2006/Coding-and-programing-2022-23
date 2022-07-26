import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginScreenAdmin implements ActionListener {
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
    private JPanel panel;

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public LoginScreenAdmin(HashMap<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        // Background image
        backgroundImage = new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background = new JLabel(backgroundImage);
        background.setBounds(300, 0, 640, 600);
        background.setSize(640, 600);

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

        // Logo Description
        logo = new JLabel("Show your Husky Pride");
        logo.setBounds(40, 340, 240, 100);
        logo.setFont(new Font("Segoe Print", Font.BOLD, 18));
        logo.setForeground(Color.WHITE);
        panel.add(logo);


        // Main student login title
        centerTitle = new JLabel("Administrator Login");
        centerTitle.setBounds(140, 100, 350, 100);
        centerTitle.setFont(new Font("Segoe Print", Font.BOLD, 36));
        centerTitle.setForeground(Color.BLACK);
        background.add(centerTitle);

        // UserID text
        userID = new JLabel("Administrator ID");
        userID.setBounds(140, 200, 250, 50);
        userID.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(userID);

        // password text
        password = new JLabel("Password");
        password.setBounds(140, 300, 100, 50);
        password.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(password);

        // UserID Field
        userIDField = new JTextField();
        userIDField.setBounds(140, 240, 275, 33);
        background.add(userIDField);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(140, 340, 275, 33);
        background.add(passwordField);

        // Login Button
        loginButton = new JButton("Log In");
        loginButton.addActionListener(this);
        loginButton.setBounds(140, 440, 275, 33);
        loginButton.setFocusable(false);
        loginButton.setBackground(new java.awt.Color(0, 180, 0));
        loginButton.setOpaque(true);
        background.add(loginButton);

        // Message Label
        messageLabel = new JLabel();
        messageLabel.setBounds(140, 500, 200, 50);
        messageLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
        background.add(messageLabel);

        // Frame
        frame = new JFrame("Login Screen");
        frame.add(background);
        frame.add(panel);
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
