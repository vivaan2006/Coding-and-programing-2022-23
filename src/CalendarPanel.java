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


            label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);

            JButton b1 = new JButton("<-");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cal.add(Calendar.MONTH, -1);
                    updateMonth();
                }
            });

            JButton b2 = new JButton("->");
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    cal.add(Calendar.MONTH, +1);
                    updateMonth();
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(b1,BorderLayout.WEST);
            panel.add(label,BorderLayout.CENTER);
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


/*
 setLayout(null);
        setBackground(new Color(38, 78, 54));
        // this is the title
        var tQuestions = new JLabel("Top Questions");
        tQuestions.setFont(new Font("Arial", Font.BOLD, 20));
        tQuestions.setForeground(Color.WHITE);
        tQuestions.setBounds(90,20,140,25);
        add(tQuestions);

        // i used constructor with a position becuase i'm using it inside dashboard .... because dashboard had null layout
        int positionY = 0;


        // this is the title
        var tLessons = new JLabel("Top Lessons");
        tLessons.setFont(new Font("Arial", Font.BOLD, 20));
        tLessons.setForeground(Color.WHITE);
        tLessons.setBounds(420,20,140,25);
        add(tLessons);

        // i used constructor with a position becuase i'm using it inside dashboard .... because dashboard had null layout
        positionY = 0;


        // this is the title
        var tSubjects = new JLabel("Top Subjects");
        tSubjects.setFont(new Font("Arial", Font.BOLD, 20));
        tSubjects.setForeground(Color.WHITE);
        tSubjects.setBounds(740,20,140,25);
        add(tSubjects);

        // i used constructor with a position becuase i'm using it inside dashboard .... because dashboard had null layout
        positionY = 0;
 */