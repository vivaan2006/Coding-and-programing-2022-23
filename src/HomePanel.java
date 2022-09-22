import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomePanel extends JPanel implements ActionListener {

    private JPanel anotherPanel;

    private JLabel upcomingEvents;


    private JButton tableViewer;
    private JTable table;
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    private JScrollPane scrollPane;
    private Object[] columns = {"Week", "Event", "Location"};
    private Object[][] data = {{"09/19 - 09/24", "Football vs Payson", "Hillcrest"},
            {"09/19 - 09/24", "Volleyball vs Cottonwood", "Cottonwood"},
            {"09/19 - 09/24", "Burning of the H", "Hillcrest"}
    };


    public HomePanel() {
        setLayout(null);
        setBackground(new Color(0, 120, 74));

        anotherPanel = new JPanel();
        anotherPanel.setLayout(null);
        anotherPanel.setBounds(30, 150, 350, 300);
        anotherPanel.setSize(350, 300);
        anotherPanel.setBackground(new Color(0, 120, 74));
        anotherPanel.setVisible(false);
        add(anotherPanel);

        upcomingEvents = new JLabel("Upcoming Events");
        upcomingEvents.setBounds(60, 20, 200, 60);
        upcomingEvents.setFont(new Font("Calibri", Font.BOLD, 20));
        upcomingEvents.setForeground(Color.BLACK);
        add(upcomingEvents);


        tableViewer = new JButton("View Events");
        tableViewer.addActionListener(this);
        tableViewer.setBounds(50, 80, 225, 33);
        tableViewer.setFocusable(false);
        tableViewer.setBackground(new java.awt.Color(119, 4, 134));
        tableViewer.setOpaque(true);
        add(tableViewer);

        table = new JTable(data, columns);
        table.setBackground(Color.BLUE);
        table.setForeground(Color.WHITE);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.setBounds(20, 60, 350, 300);
        table.setFillsViewportHeight(true);
        anotherPanel.add(table);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableViewer) {
            anotherPanel.setVisible(true);
        }
    }
}