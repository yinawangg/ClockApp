/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author ziwang
 */
public class AlarmPopUp {
    
    /**
     * Constructor for alarm popup
     */
    public AlarmPopUp() {
        frame = new JFrame("RISE AND SHINE");
        
        JPanel panel1 = new JPanel(new BorderLayout());
        
        JTextField alarm = new JTextField(100);
        alarm.setFont(new Font("ComicSans", Font.BOLD, 25));
        alarm.setText("      THIS IS YOUR ALARM");
        alarm.setBackground(Color.PINK);
        alarm.setForeground(Color.WHITE);
        panel1.add(alarm);
        
        frame.add(panel1);
        frame.setVisible(false);
        frame.setSize(420, 420);
        
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(counter % 2 == 0) {
                    alarm.setForeground(Color.WHITE);
                } else {
                    alarm.setForeground(Color.PINK);
                }
                counter++;
            }
        };
        
        
        Timer t = new Timer(DELAY, listener);
        t.start();
     
         
    }
    
    /**
     * allows the frames to be visible
     */
    public void setVisible() {
        frame.setVisible(true);
    }
    
   private JFrame frame;
   private int counter = 0;
   private final int DELAY = 500;
    
}