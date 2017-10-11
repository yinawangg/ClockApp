/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.Icon;

/**
 *
 * @author wezhou
 */
public class Display implements Icon{
    
    /**
     * Constructor for display
     */
    public Display() {
        createSegments();
        this.x = 0;
        this.y = 0;
        setNumber(0);
    }
    
    /**
     * Constructor for display
     */
    public Display(int x, int y, int n){
        this.x = x;
        this.y = y;
        createSegments();
        setNumber(n);
    }
    
     /**
     * get icon width
     *
     * @return the width
     */
    public int getIconWidth() {
        return WIDTH;
    }

    /**
     * get icon height
     *
     * @return the height
     */
    public int getIconHeight() {
        return HEIGHT;
    }

    /**
     * Function that allows icon to be seen
     * @param c component
     * @param g graphics to add colors and other similar things
     * @param x placement (x)
     * @param y placement (y)
     */
    public void paintIcon(Component c, Graphics g, int x, int y) {
        for (int i = 0; i < SEGMENT_NUMBER; i++) {
            setSegmentState(g, segments[i], number[i]);
        }
    }



    /**
     *
     * @param n number to display
     * Setting the number to display
     */

    public void setNumber(int n) {
        switch (n) {
            case 0:
                number = zero;
                break;
            case 1:
                number = one;
                break;
            case 2:
                number = two;
                break;
            case 3:
                number = three;
                break;
            case 4:
                number = four;
                break;
            case 5:
                number = five;
                break;
            case 6:
                number = six;
                break;
            case 7:
                number = seven;
                break;
            case 8:
                number = eight;
                break;
            case 9:
                number = nine;
                break;
        }
    }

    /**
     * Creating the seven segments of a seven-segment display
     */
    public void createSegments() {
        segments = new Polygon[SEGMENT_NUMBER];

        segments[A] = new Polygon();
        segments[A].addPoint(x, y);
        segments[A].addPoint(x + SEGMENT_LENGTH + SEGMENT_WIDTH * 2, y);
        segments[A].addPoint(x + SEGMENT_LENGTH + SEGMENT_WIDTH,
                y + SEGMENT_WIDTH);
        segments[A].addPoint(x + SEGMENT_WIDTH, y + SEGMENT_WIDTH);

        segments[B] = new Polygon();
        segments[B].addPoint(x + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH, y);
        segments[B].addPoint(x + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH);
        segments[B].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH + SEGMENT_LENGTH);
        segments[B].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH);
        
        segments[C] = new Polygon();
        segments[C].addPoint(x + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH);
        segments[C].addPoint(x + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 4 + SEGMENT_LENGTH * 2);
        segments[C].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 3 + SEGMENT_LENGTH * 2);
        segments[C].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 3 + SEGMENT_LENGTH);

        segments[D] = new Polygon();
        segments[D].addPoint(x, y + SEGMENT_LENGTH * 2 + SEGMENT_WIDTH * 4);
        segments[D].addPoint(x + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 4 + SEGMENT_LENGTH * 2);
        segments[D].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 3 + SEGMENT_LENGTH * 2);
        segments[D].addPoint(x + SEGMENT_WIDTH,
                y + SEGMENT_LENGTH * 2 + SEGMENT_WIDTH * 3);

        segments[E] = new Polygon();
        segments[E].addPoint(x, y + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH);
        segments[E].addPoint(x + SEGMENT_WIDTH,
                y + SEGMENT_WIDTH * 3 + SEGMENT_LENGTH);
        segments[E].addPoint(x + SEGMENT_WIDTH,
                y + SEGMENT_LENGTH * 2 + SEGMENT_WIDTH * 3);
        segments[E].addPoint(x, y + SEGMENT_WIDTH * 4 + SEGMENT_LENGTH * 2);

        segments[F] = new Polygon();
        segments[F].addPoint(x, y);
        segments[F].addPoint(x + SEGMENT_WIDTH, y + SEGMENT_WIDTH);
        segments[F].addPoint(x + SEGMENT_WIDTH,
                y + SEGMENT_LENGTH + SEGMENT_WIDTH);
        segments[F].addPoint(x, y + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH);

        segments[G] = new Polygon();
        segments[G].addPoint(x + SEGMENT_WIDTH,
                y + SEGMENT_WIDTH + SEGMENT_LENGTH);
        segments[G].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH + SEGMENT_LENGTH);
        segments[G].addPoint(x + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH);
        segments[G].addPoint(x + SEGMENT_WIDTH + SEGMENT_LENGTH,
                y + SEGMENT_WIDTH * 3 + SEGMENT_LENGTH);
        segments[G].addPoint(x + SEGMENT_WIDTH,
                y + SEGMENT_WIDTH * 3 + SEGMENT_LENGTH);
        segments[G].addPoint(x, y + SEGMENT_WIDTH * 2 + SEGMENT_LENGTH);

    }

 
    /**
     * Setting the state of each segment depending on the number we are
     * attempting to display
     * @param graphics, graphics
     * @param segment, the segment in question
     * @param state, ON or OFF 
     */
    private void setSegmentState(Graphics graphics, Polygon segment, int state) {
        if (state == OFF) {
            graphics.setColor(off);
        } else {
            graphics.setColor(on);
        }

        graphics.fillPolygon(segment);
        graphics.drawPolygon(segment);
    }

    // Setting dimensions 
    
    private static int x;
    private static int y;
    private final static int WIDTH = 60;
    private final static int HEIGHT = 500;

    // Setting segment sizes
    private final static int SEGMENT_LENGTH = 32;
    private final static int SEGMENT_WIDTH = 14;

    private Polygon[] segments;
    private int[] number;

    private final static int SEGMENT_NUMBER = 7;
    private final static int A = 0;
    private final static int B = 1;
    private final static int C = 2;
    private final static int D = 3;
    private final static int E = 4;
    private final static int F = 5;
    private final static int G = 6;

    private final static int OFF = 0;
    private final static int ON = 1;

    
    //Int array for the states of every segment, for numbers 0-9
    
    private final static int zero[] = {ON, ON, ON, ON, ON, ON, OFF};
    private final static int one[] = {OFF, ON, ON, OFF, OFF, OFF, OFF};
    private final static int two[] = {ON, ON, OFF, ON, ON, OFF, ON};
    private final static int three[] = {ON, ON, ON, ON, OFF, OFF, ON};
    private final static int four[] = {OFF, ON, ON, OFF, OFF, ON, ON};
    private final static int five[] = {ON, OFF, ON, ON, OFF, ON, ON};
    private final static int six[] = {ON, OFF, ON, ON, ON, ON, ON};
    private final static int seven[] = {ON, ON, ON, OFF, OFF, OFF, OFF};
    private final static int eight[] = {ON, ON, ON, ON, ON, ON, ON};
    private final static int nine[] = {ON, ON, ON, ON, OFF, ON, ON};
    private final static int test[] = {ON, ON, ON, ON, ON, ON, ON};

    // Setting colors
    
    private final static Color BACKGROUND_COLOR = Color.WHITE;
    private final static Color off = BACKGROUND_COLOR;
    private final static Color on = Color.PINK;
    
 //   public static int[] currentNum;
}
