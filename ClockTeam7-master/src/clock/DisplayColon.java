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
 * class to create all the colons
 */
public class DisplayColon implements Icon{
    
    /**
     * Constructor for colon
     * @param x placement in x direction
     * @param y placement in y direction
     */
    public DisplayColon(int x, int y){
        this.x = x;
        this.y = y;
        createSegments();
        
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

    /* We will create seven segments which will be colored in when relevant*/
    public void paintIcon(Component c, Graphics g, int x, int y) {
        for (int i = 0; i < SEGMENT_NUMBER; i++) {
            setSegmentState(g, segments[i], DEFAULT[i]);
        }
    }

    /**
     * Creating the two colons
     */
    public void createSegments() {
        segments = new Polygon[SEGMENT_NUMBER];

        segments[A] = new Polygon();
        segments[A].addPoint(x + WIDTH/10, y + HEIGHT/10);
        segments[A].addPoint(x + COLON_SIZE + WIDTH/10, y + HEIGHT/10);
        segments[A].addPoint(x + COLON_SIZE + WIDTH/10, y + COLON_SIZE + HEIGHT/10);
        segments[A].addPoint(x + WIDTH/10, y + COLON_SIZE + HEIGHT/10);
        
        segments[B] = new Polygon();
        segments[B].addPoint(x + WIDTH/10, y + COLON_GAP + HEIGHT/10);
        segments[B].addPoint(x + COLON_SIZE + WIDTH/10, y + COLON_GAP + HEIGHT/10);
        segments[B].addPoint(x + COLON_SIZE + WIDTH/10,
                y + COLON_SIZE + COLON_GAP + HEIGHT/10);
        segments[B].addPoint(x + WIDTH/10, y + COLON_SIZE + COLON_GAP + HEIGHT/10);

    }

    /**
     * Setting segment states
     * @param graphics that does coloring
     * @param segment current segment
     * @param state whether to turn on or off
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

    private static int x;
    private static int y;
    private final static int WIDTH = 20;
    private final static int HEIGHT = 180;

    private final static int COLON_SIZE = 15;
    private final static int COLON_GAP = 70;

    private Polygon[] segments;

    private final static int SEGMENT_NUMBER = 2;
    private final static int A = 0;
    private final static int B = 1;

    private final static int OFF = 0;
    private final static int ON = 1;
    
    private final static int DEFAULT[] = {ON, ON};

    private final static Color BACKGROUND_COLOR = Color.WHITE;
    private final static Color off = BACKGROUND_COLOR;
    private final static Color on = Color.PINK;
}

