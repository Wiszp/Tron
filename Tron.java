/*
 * Jack English
 * Tron.java
 * Drives the program and handles painting/action listening type stuff
 */


package tron;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Tron extends JFrame {

	private Timer time;
	private Bike p1;
	private Bike p2;
	public ArrayList<Line> p1Lines = new ArrayList<Line>(); //stores where p1's lines have been
	public ArrayList<Line> p2Lines = new ArrayList<Line>(); //stores where p2's lines have been

	public Tron()
	{
		//initialize bikes
		p1 = new Bike(100, 100, 3, Color.green);
		p2 = new Bike(900, 100, 1, Color.blue);

		addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e) {}
			//Key Events
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_W)
				{
					p1.setDir(0); //up
				}
				else if (e.getKeyCode() == KeyEvent.VK_A)
				{
					p1.setDir(1); //left
				}
				else if (e.getKeyCode() == KeyEvent.VK_S)
				{
					p1.setDir(2); //down
				}
				else if (e.getKeyCode() == KeyEvent.VK_D)
				{
					p1.setDir(3); //right
				}

				if (e.getKeyCode() == KeyEvent.VK_UP)
				{
					p2.setDir(0); //up
				}
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					p2.setDir(1); //left
				}
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					p2.setDir(2); //down
				}
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					p2.setDir(3); //right
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}	
		});

		time = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
		});

		setSize(1000, 1000);
		setTitle("Tron");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 50);
		setVisible(true);
		time.start();
	}

	//paints the screen
	public void paint (Graphics g)
	{
		g.clearRect(0, 0, 1000, 1000); 

		//bike 1
		g.setColor(p1.getColor());
		g.fillRect(p1.getX(), p1.getY(), 20, 20);

		//bike 2
		g.setColor(p2.getColor());
		g.fillRect(p2.getX(), p2.getY(), 20, 20);

		//now draw!
		drawLines(g);

		//update it all
		p1.update();
		p2.update();	
		p1Lines.add(p1.getTrail());
		p2Lines.add(p2.getTrail());

		if (!p1.getAlive() || !p2.getAlive()) //if the game's over
		{
			this.gameOver();
			g.clearRect(0, 0, 1000, 1000);
			g.setColor(Color.white);
			g.drawRect(0, 0, 1000, 1000);
			g.setColor(Color.black);;
			if(!p1.getAlive())
			{
				g.drawString("Player Two wins!", 450, 500);
			}
			else if(!p2.getAlive())
			{
				g.drawString("Player One wins!", 450, 500);
			}
		}
	}

	//draws all of the trails behind a bike
	public void drawLines(Graphics g)
	{
		Color c = p1.getColor();
		g.setColor(c);
		for (int i = 0; i < p1Lines.size(); i++) //draw the lines for p1
		{
			Line l = p1Lines.get(i);
			Point start = l.getStartPoint();
			Point end = l.getEndPoint();
			g.drawLine(start.getPointX(), start.getPointY(), end.getPointX(), end.getPointY());
		}

		c = p2.getColor();
		g.setColor(c);
		for (int j = 0; j < p2Lines.size(); j++) //draw the lines for p2
		{
			Line l = p2Lines.get(j);
			Point start = l.getStartPoint();
			Point end = l.getEndPoint();
			g.drawLine(start.getPointX(), start.getPointY(), end.getPointX(), end.getPointY());
		}
	}

	//draws a line
	public void makeLine(Graphics g, Line l)
	{
		Point start = l.getStartPoint();
		Point end = l.getEndPoint();
		g.drawLine(start.getPointX(), start.getPointY(), end.getPointX(), end.getPointY());
	}

	//halts the timer
	public void gameOver()
	{
		time.stop();
	}

	public static void main(String[] args)
	{
		Tron tron = new Tron();
	}


}
