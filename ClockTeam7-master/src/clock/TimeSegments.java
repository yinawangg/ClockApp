/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author trparsonsgrayson
 */
public class TimeSegments {

    /**
     * Constructor for Time Segments
     */
    public TimeSegments() {
        jp1 = new JPanel();
        jp1.setSize(1000,1000);
        jp1.setLayout(new FlowLayout());
        
        a = new Display(0, 150, 0);
        b = new Display(0, 150, 0);
        DisplayColon col1 = new DisplayColon(0, 0);
        c = new Display(0, 150, 0);
        d = new Display(0, 150, 0);
        DisplayColon col2 = new DisplayColon(0, 0);
        e = new Display(0, 150, 0);
        f = new Display(0, 150, 0);
        displayer = new JLabel(a);
        displayer2 = new JLabel(b);
        JLabel colonDisplayer = new JLabel(col1);
        displayer3 = new JLabel(c);
        displayer4 = new JLabel(d);
        JLabel colonDisplayer2 = new JLabel(col2);
        displayer5 = new JLabel(e);
        displayer6 = new JLabel(f);
        
        jp1.add(displayer);
        jp1.add(displayer2);
        jp1.add(colonDisplayer);
        jp1.add(displayer3);
        jp1.add(displayer4);
        jp1.add(colonDisplayer2);
        jp1.add(displayer5);
        jp1.add(displayer6);
    }
    
    /**
     * Repaints all the numbers
     */
    public void repaint() {
        displayer.repaint();
        displayer2.repaint();
        displayer3.repaint();
        displayer4.repaint();
        displayer5.repaint();
        displayer6.repaint();
    }
    
    /**
     * Setting the displayed hour
     * @param h, the hour       
     */
    public void setDisplayHour(int h) {
        if (h < 10) {
            a.setNumber(0);
            b.setNumber(h);
        }
        else {
            a.setNumber(h / 10);
            b.setNumber(h % 10);        
        }
        

    }
    
    /**
     * Setting the displayed minutes
     * @param m, the minutes
     */
    public void setDisplayMin(int m) {
        if (m < 10) {
            c.setNumber(0);
            d.setNumber(m);
        }
        else {
            c.setNumber(m / 10);
            d.setNumber(m % 10);        
        }

    }
    
    /**
     * Setting the displayed seconds
     * @param s, the seconds
     */
    public void setDisplaySec(int s) {
        if (s < 10) {
            e.setNumber(0);
            f.setNumber(s);
        }
        else {
            e.setNumber(s / 10);
            f.setNumber(s % 10);        
        }
    }
    
    /**
     * Setting all the time variables
     * @param h, the hour value
     * @param m, the minute value
     * @param s, the second value
     */
    public void setAllTime(int h, int m, int s) {
        setDisplayHour(h);
        setDisplayMin(m);
        setDisplaySec(s);
    }
    
    /**
     * Returns the panel
     * @return jp1 panel
     */
    public JPanel getJp1() {
        return jp1;
    }

    private JPanel jp1;
    private JLabel displayer;
    private JLabel displayer2;
    private JLabel displayer3;
    private JLabel displayer4;
    private JLabel displayer5;
    private JLabel displayer6;
    private Display a;
    private Display b;
    private Display c;
    private Display d;
    private Display e;
    private Display f;
    

}
