import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarPanel extends JPanel {

        DefaultTableModel model;
        Calendar cal = new GregorianCalendar();
        JLabel label;

        CalendarPanel() {

            this.setSize(300,200);
            this.setLayout(new BorderLayout());
            this.setBackground(new Color(0, 120, 74));
            this.setVisible(true);



            label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);


            JButton b1 = new JButton("Previous");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cal.add(Calendar.MONTH, -1);
                    updateMonth();
                }
            });

            JButton b2 = new JButton("Next");
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cal.add(Calendar.MONTH, +1);
                    updateMonth();
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(b1,BorderLayout.WEST);
            label.setBounds(20, 20, 20, 20);
            panel.add(label);
            panel.add(b2,BorderLayout.EAST);



            String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
            model = new DefaultTableModel(null,columns);
            JTable table = new JTable(model);
            JScrollPane pane = new JScrollPane(table);

            add(panel,BorderLayout.NORTH);
            add(pane,BorderLayout.CENTER);

            this.updateMonth();

        }

        void updateMonth() {
            cal.set(Calendar.DAY_OF_MONTH, 1);

            String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
            int year = cal.get(Calendar.YEAR);
            label.setText(month + " " + year);

            int startDay = cal.get(Calendar.DAY_OF_WEEK);
            int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

            model.setRowCount(0);
            model.setRowCount(weeks);

            int i = startDay-1;
            for(int day=1;day<=numberOfDays;day++){
                model.setValueAt(day, i/7 , i%7 );
                i = i + 1;
            }

        }

        public static void main(String[] arguments) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            CalendarPanel sc = new CalendarPanel();
        }

    }


