import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class board1 extends JPanel implements ActionListener
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
    private Craft craft; 
    private Plane plane;
    private Plane2 plane2;
    private Plane3 plane3;
    private Plane4 plane4;
    private flyAway flyy;

    public board1() 
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        plane = new Plane();
        plane2 = new Plane2();
        plane3 = new Plane3();
        plane4 = new Plane4();
        flyy = new flyAway();
        craft = new Craft();

        timer = new Timer(2, this);
        timer.start();  
    }

    public void paint(Graphics g) 
    {   	
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        Graphics2D word = (Graphics2D)g;
        Graphics2D word1 = (Graphics2D)g;
        Graphics2D word2 = (Graphics2D)g;
        Graphics2D word3 = (Graphics2D)g;
        Graphics2D terminal1 = (Graphics2D)g;
        Graphics2D terminal2 = (Graphics2D)g;
        Graphics2D terminal3 = (Graphics2D)g;
        Graphics2D terminal4 = (Graphics2D)g;
        
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        g2d.drawImage(plane.getImage(), plane.getX(), plane.getY(), this);
        g2d.drawImage(plane2.getImage(), plane2.getX(), plane2.getY(), this);
        g2d.drawImage(plane3.getImage(), plane3.getX(), plane3.getY(), this);
        g2d.drawImage(plane4.getImage(), plane4.getX(), plane4.getY(), this);
        g2d.drawImage(flyy.getImage(), flyy.getX(), flyy.getY(), this);
       
        // border for check in / airport sign / ticket booth
        g2d.drawRect(925, 0, 250, 50);
        g2d.drawRect(925, 635, 250, 60);
        g2d.drawRect(1300, 130, 50, 450);
        
        // security fence
        g2d.drawLine(740, 0, 740, 300);
        g2d.drawLine(760, 0, 760, 300);
        g2d.drawLine(740, 450, 740, 700);
        g2d.drawLine(760, 450, 760, 700);
        g2d.drawLine(760, 450, 740, 450);
        g2d.drawLine(760, 300, 740, 300);
        g2d.drawLine(740, 250, 650, 250);
        g2d.drawLine(740, 500, 650, 500);
        g2d.drawLine(650, 250, 650, 500);
        
        g2d.drawRect(0, 10, 130, 665);
        g2d.drawLine(0, 50, 130, 50);
        g2d.drawLine(0, 170, 130, 170);
        g2d.drawLine(0, 210, 130, 210);
        g2d.drawLine(0, 340, 130, 340);
        g2d.drawLine(0, 380, 130, 380);
        g2d.drawLine(0, 510, 130, 510);
        g2d.drawLine(0, 550, 130, 550);  
        
        // terminals light up when it is selected from ticket booth
        if (craft.getTerm() == 1)
        {
        	g2d.setColor(new Color(42, 179, 231));
        	g2d.fillRect(1, 11, 129, 39);
        }
        
        if (craft.getTerm() == 2)
        {
        	g2d.setColor(new Color(42, 179, 231));
        	g2d.fillRect(1, 171, 129, 39);
        }
        
        if (craft.getTerm() == 3)
        {
        	g2d.setColor(new Color(42, 179, 231));
        	g2d.fillRect(1, 341, 129, 39);
        }
        
        if (craft.getTerm() == 4)
        {
        	g2d.setColor(new Color(42, 179, 231));
        	g2d.fillRect(1, 511, 129, 39);
        }
        

        Font exFont = new Font("Times Roman", Font.PLAIN, 20);
        word.setFont(exFont);
        word.setColor(Color.BLACK);
        word1.setFont(exFont);
        word1.setColor(Color.BLACK);
        word2.setFont(exFont);
        word2.setColor(Color.BLACK);
        word3.setFont(exFont);
        word3.setColor(Color.BLACK);
        
        terminal1.setFont(exFont);
        terminal1.setColor(Color.BLACK);
        terminal2.setFont(exFont);
        terminal2.setColor(Color.BLACK);
        terminal3.setFont(exFont);
        terminal3.setColor(Color.BLACK);
        terminal4.setFont(exFont);
        terminal4.setColor(Color.BLACK);
        terminal1.drawString("Terminal 1", 20, 40);
        terminal2.drawString("Terminal 2", 20, 200);
        terminal3.drawString("Terminal 3", 20, 370);
        terminal4.drawString("Terminal 4", 20, 540);
        
        word2.drawString("Check-In/ Bag Dropoff", 950, 30);
        word3.drawString("Ticket Booth", 980, 670);
        word.rotate(3*(Math.PI/2));
        word.drawString("INTERNATIONAL AIRPORT", -480, 1330);
        word1.drawString("Customs/ Security", -450, 700);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e)
    {
    	craft.move();
    	if (craft.getX() <= 130 && (craft.getY() <= 170 && craft.getY() >= 50))
    		plane.leave();
    	else if (craft.getX() <= 130 && (craft.getY() >= 210 && craft.getY() <= 340))
    		plane2.leave();
    	else if (craft.getX() <= 130 && (craft.getY() <= 510 && craft.getY() >= 380))
    		plane3.leave();
    	else if (craft.getX() <= 130 && (craft.getY() <= 665 && craft.getY() >= 550))
    		plane4.leave();
    	if (plane.getX() <= 0 || plane2.getX() <= 0 || plane3.getX() <= 0 || plane4.getX() <= 0)
    		flyy.FLY();
    	if (flyy.getY() < -400 || craft.getY() < 0)
    	{
    		plane = new Plane();
            plane2 = new Plane2();
            plane3 = new Plane3();
            plane4 = new Plane4();
            craft = new Craft();
    		flyy = new flyAway();   		
    	}
    	
        repaint();  
    }

	private class TAdapter extends KeyAdapter 
    {
        public void keyReleased(KeyEvent e)
        {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) 
        {
        	if (craft.getX() > 750 && craft.getX() <= 760)
        		craft.doNotMove(e);
        	else 
        		craft.keyPressed(e);
        }
    }

}
