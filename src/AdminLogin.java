import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin implements ActionListener {
    private JFrame frame;
    private ImageIcon backgroundImage;
    private JLabel background;
    private JLabel adminUserID;
    private JLabel adminPassword;
    private JTextField adminIDField;
    private JPasswordField adminPasswordField;
    private JButton adminLoginButton;
    private JPanel panel2;
   
    public AdminLogin(){
        backgroundImage = new ImageIcon(this.getClass().getResource("images/background.jpg"));
        background = new JLabel(backgroundImage);
        background.setBounds(300, 0, 1000, 600);
        background.setSize(1000, 600);

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
