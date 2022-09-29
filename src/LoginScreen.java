import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class LoginScreen implements ActionListener, MouseListener {
    private JFrame frame;
    private ImageIcon backgroundImage;
    private JLabel background;
    private JLabel studentCenterTitle;
    private JLabel adminCenterTitle;

    private JLabel userID;
    private JLabel password;
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JButton studentLoginButton;
    private JLabel studentForgotPassword;
    private JLabel messageLabel;

    private JLabel adminUserID;
    private JLabel adminPassword;
    private JTextField adminIDField;
    private JPasswordField adminPasswordField;
    private JButton adminLoginButton;

    private JPanel panel;
    private ImageIcon logoImage;
    private JLabel title;


    public LoginScreen() {
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


        // Main student login title
        studentCenterTitle = new JLabel("Student Login");
        studentCenterTitle.setBounds(90, 100, 350, 100);
        studentCenterTitle.setFont(new Font("Segoe Print", Font.BOLD, 32));
        studentCenterTitle.setForeground(Color.BLACK);
        background.add(studentCenterTitle);

        // Student UserID text
        userID = new JLabel("User Name");
        userID.setBounds(90, 200, 100, 50);
        userID.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(userID);

        // Student password text
        password = new JLabel("Password");
        password.setBounds(90, 300, 100, 50);
        password.setFont(new Font("Segoe Print", Font.BOLD, 16));
        background.add(password);

        // Student UserID Field
        userIDField = new JTextField();
        userIDField.setBounds(90, 240, 225, 33);
        background.add(userIDField);

        // Student Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(90, 340, 225, 33);
        background.add(passwordField);

        // Student Login Button
        studentLoginButton = new JButton("Log In");
        studentLoginButton.addActionListener(this);
        studentLoginButton.setBounds(90, 440, 225, 33);
        studentLoginButton.setFocusable(false);
        studentLoginButton.setBackground(new java.awt.Color(0, 180, 0));
        studentLoginButton.setOpaque(true);
        background.add(studentLoginButton);

        studentForgotPassword = new JLabel("Forgot your password?");
        studentForgotPassword.addMouseListener(this);
        studentForgotPassword.setBounds(90, 360, 150, 40);
        studentForgotPassword.setSize(200, 50);
        studentForgotPassword.setForeground(Color.WHITE);
        background.add(studentForgotPassword);

        // Message Label
        messageLabel = new JLabel();
        messageLabel.setBounds(140, 500, 400, 50);
        messageLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
        background.add(messageLabel);

        // Frame
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
        LoginScreen loginScreen = new LoginScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == studentLoginButton) {
            String studentUserID = userIDField.getText();
            String studentPassword = String.valueOf(passwordField.getPassword());


            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginstudent", "root", "FBLA2023");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from login_info_student");



                while(resultSet.next()) {
                    if(resultSet.getString("userName").equals(studentUserID) && resultSet.getString("password").equals(studentPassword)) {
                        messageLabel.setForeground(Color.GREEN);
                        messageLabel.setText("Login Successful");
                        frame.dispose();
                        MainFrame frame = new MainFrame(resultSet.getString("name"));
                    }
                    else {
                        messageLabel.setForeground(Color.RED);
                        messageLabel.setText("Wrong Username or Password");
                    }
                }

            } catch(SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == studentForgotPassword) {
            frame.dispose();
            ChangePasswordStudent changePasswordStudent = new ChangePasswordStudent();

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        studentForgotPassword.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        studentForgotPassword.setForeground(Color.WHITE);

    }
}
