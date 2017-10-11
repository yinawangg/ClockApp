/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ziwang
 */
public class DigitalClock extends JLabel implements ActionListener {

    /**
     * Constructor for clock
     * @param h hours
     * @param m minutes
     * @param s seconds
     */
    public DigitalClock(int h, int m, int s) {

        AlarmPopUp alarmPop = new AlarmPopUp();
        JFrame frame = new JFrame("Digital Clock");
        travers = new Clock(h, m, s);
        yina = new TimeSegments();
        yina.setAllTime(travers.getHour(), travers.getMinute(), travers.getSeconds());
        wfang = new Integer[3];
        wfang[0] = -10;
        wfang[1] = -10;
        wfang[2] = -10;

        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new GridLayout(1, 3));

        //making buttons for the frame!!
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        JButton lock = new JButton("Lock");
        JButton hour = new JButton("Hour");
        JButton min = new JButton("Minute");
        JButton setTime = new JButton("Set Time");
        JButton alarm = new JButton("Alarm");
        //JLabel currentTime = new JLabel(travers.toString(), SwingConstants.CENTER);

        //coloring the buttons' background
        up.setBackground(BACKGROUND);
        down.setBackground(BACKGROUND);
        lock.setBackground(BACKGROUND);
        hour.setBackground(BACKGROUND);
        min.setBackground(BACKGROUND);
        setTime.setBackground(BACKGROUND);
        alarm.setBackground(BACKGROUND);

        // setting the forecolor
        up.setForeground(FOREGROUND);
        down.setForeground(FOREGROUND);
        lock.setForeground(FOREGROUND);
        hour.setForeground(FOREGROUND);
        min.setForeground(FOREGROUND);
        setTime.setForeground(FOREGROUND);
        alarm.setForeground(FOREGROUND);
        
         JFrame alarmFrame = new JFrame("Set your Alarm");
        alarmFrame.setLayout(new BorderLayout());
        JLabel myLabel = new JLabel("Hour: ");
        JTextField myTextField = new JTextField("Enter Hour");
        JLabel myLabel2 = new JLabel("Minutes: ");
        JTextField myTextField2 = new JTextField("Enter Minutes");
        JLabel myLabel3 = new JLabel("Seconds: ");
        JTextField myTextField3 = new JTextField("Enter Seconds");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(myLabel);
        panel.add(myTextField);
        panel.add(myLabel2);
        panel.add(myTextField2);
        panel.add(myLabel3);
        panel.add(myTextField3);
        JPanel submit = new JPanel(new FlowLayout());
        JButton submitButton = new JButton("SUBMIT");
        submit.add(submitButton);

        alarmFrame.add(panel, BorderLayout.CENTER);
        alarmFrame.add(submit, BorderLayout.SOUTH);
        alarmFrame.setVisible(false);
        alarmFrame.setSize(300, 420);


        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (travers.getShouldTick()) {
                    travers.addSecond();
                }
                
                 if(travers.getHour() == wfang[0] && 
                        travers.getMinute() == wfang[1] &&
                        travers.getSeconds() == wfang[2]) {
                    alarmPop.setVisible();
                }
            

            }
        };

        ActionListener paintListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                yina.setAllTime(travers.getHour(), travers.getMinute(), travers.getSeconds());
                yina.repaint();

            }
        };

        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (travers.getState() == Clock.States.HOURS) {
                    travers.addHour();
                }
                if (travers.getState() == Clock.States.MINUTES) {
                    travers.addMinute();
                }
            }
        });

        down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (travers.getState() == Clock.States.HOURS) {
                    travers.subtractHour();
                }
                if (travers.getState() == Clock.States.MINUTES) {
                    travers.subtractMinute();
                }
            }
        });

        lock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                travers.setToTick();
                up.setEnabled(false);
                down.setEnabled(false);
                hour.setEnabled(false);
                min.setEnabled(false);

            }
        });
        hour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                travers.setState(Clock.States.HOURS);
                up.setEnabled(true);
                down.setEnabled(true);
            }
        });
        min.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                travers.setState(Clock.States.MINUTES);
                up.setEnabled(true);
                down.setEnabled(true);
            }
        });
        setTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                travers.setNoTick();
                hour.setEnabled(true);
                min.setEnabled(true);

            }
        });
        
        alarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alarmFrame.setVisible(true);
                myTextField.setText("");
                myTextField2.setText("");
                myTextField3.setText("");
            }
        });
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hours = myTextField.getText();
                String mins = myTextField2.getText();
                String secs = myTextField3.getText();
                
                try {
                    int hour = Integer.parseInt(hours);
                    int min = Integer.parseInt(mins);
                    int sec = Integer.parseInt(secs);
                    wfang[0] = hour;
                    wfang[1] = min;
                    wfang[2] = sec;
                    alarmFrame.dispose();
                    
                } catch (NumberFormatException w) {
                    myTextField.setText("Invalid Input");
                    myTextField2.setText("Invalid Input");
                    myTextField3.setText("Invalid Input");
                }
                
            }
        });
        
        //only can press these buttons when set time is pressed
        up.setEnabled(false);
        down.setEnabled(false);
        hour.setEnabled(false);
        min.setEnabled(false);

        // adding buttons to panels
        panel1.add(up);
        panel1.add(down);
        panel2.add(hour, BorderLayout.WEST);
        panel2.add(min, BorderLayout.EAST);
        //panel2.add(currentTime, BorderLayout.CENTER);
        panel2.add(yina.getJp1(), BorderLayout.CENTER);
        panel3.add(lock);
        panel3.add(setTime);
        panel3.add(alarm);

        //adding panels to frame
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        Timer t = new Timer(DELAY, listener);
        t.start();

        Timer paintTimer = new Timer(PAINT, paintListener);
        paintTimer.start();

    }
    
    /**
     * Allows us to use actionPerformed without worry of error
     * @param e event that is not supported
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected Clock travers;
    protected Integer[] wfang;
    protected TimeSegments yina;
    private final static int DELAY = 1000;
    private final static int PAINT = 100;
    private final Color BACKGROUND = Color.PINK;
    private final Color FOREGROUND = Color.WHITE;
}
