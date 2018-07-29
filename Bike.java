package tron;

import java.awt.Color;

public class Bike {

	//coordinate location
	private int x;
	private int y;
	private int dir; //direction bike is facing - 0 = up, 1 = left, 2 = down, 3 = right
	private final int VELOCITY = 20;
	private Color color;
	private Line trail;
	private boolean alive; //is the game over?
	private int[][] traveled = new int[1001][1001]; //stores pixels the bike has been at;
	//if the location is 1 then it's been traveled to, 0 if it hasn't
	
	public Bike()
	{
		this.x = 10;
		this.y = 10;
		this.dir = 0;
		this.color = Color.black;
		this.alive = true;
		for (int i = 0; i < 1001; i++) //initialize it to 0
		{
			for (int j = 0; j < 1001; j++)
			{
				this.traveled[i][j] = 0;
			}
		}
	}
	
	public Bike(int bx, int by, int bdir, Color bcolor)
	{
		this.x = bx;
		this.y = by;
		this.dir = bdir;
		this.color = bcolor;
		this.alive = true;
		for (int i = 0; i < 1001; i++) //initialize it to 0
		{
			for (int j = 0; j < 1001; j++)
			{
				this.traveled[i][j] = 0;
			}
		}
	}
	
	
	//Movement
	public void moveUp()
	{
		this.y-=5;
	}
	
	public void moveLeft()
	{
		this.x-=5;
	}
	
	public void moveDown()
	{
		this.y+=5;
	}
	
	public void moveRight()
	{
		this.x+=5;
	}
	
	
	//moves bike and updates trail
	public void update()
	{
		//move the bike
		switch(this.dir) 
		{
		case 0:
			y -= VELOCITY;
			break;
			
		case 1:
			x -= VELOCITY;
			break;
			
		case 2:
			y += VELOCITY;
			break;
			
		case 3:
			x += VELOCITY;
			break;
		}
		
		//if it goes off to the right or left
		if (this.x > 1000) //right
		{
			this.setX(0);
		}
		else if (this.x < 0) //left
		{
			this.setX(1000);
		}
		
		//if it goes off the top or bottom
		if (this.y > 1000) //top
		{
			this.setY(0);
		}
		else if (this.y < 0) //bottom
		{
			this.setY(1000);
		}
		
		if (this.traveled[this.getX()][this.getY()] == 1)
		{
			this.alive = false;
		}
		//log where it's been after checking to see if it's been
		//there before
		this.setTraveledEntry(this.getX(), this.getY()); 
		
		//updates trail
		this.calcTrail();
		System.out.println("X: " + this.getX());
		System.out.println("Y: " + this.getY());
	}
	
	//direction switchers
	
	public void vertSwitch()
	{
		if (this.getDir() == 0)
		{
			this.setDir(2);
		}
		else
		{
			this.setDir(0);
		}
	}
	
	public void horizSwitch()
	{
		if (this.getDir() == 1)
		{
			this.setDir(3);
		}
		else
		{
			this.setDir(1);
		}
	}
	
	//calculates the trail behind the current bike
	public void calcTrail()
	{
		switch(this.getDir())
		{
		//direction bike is facing - 0 = up, 1 = left, 2 = down, 3 = right
			case 0:
				this.trail = new Line(this.getX() + 10, getY() + 10, getX() + 10, getY() + 30);
				break;
			case 1:
				this.trail = new Line(getX() + 10, getY() + 10, getX() + 30, getY() + 10);
				break;
			case 2:
				this.trail = new Line(getX() + 10, getY() - 10, getX() + 10, getY() + 10);
				break;
			case 3:
				this.trail = new Line(getX() + 10, getY() + 10, getX() - 10, getY() + 10);
				break;
		}
	}
	
	//Getters and setters
	public int getX()
	{
		return this.x;
	}
	
	public void setX(int n)
	{
		this.x = n;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setY(int n)
	{
		this.y = n;
	}
	
	public int getDir()
	{
		return this.dir;
	}
	
	public void setDir(int d)
	{
		this.dir = d;
	}
	
	public int[][] getTraveled()
	{
		return this.traveled;
	}
	
	public void setTraveledEntry(int i, int j)
	{
		this.traveled[i][j] = 1;
	}
	
	public boolean getAlive()
	{
		return this.alive;
	}
	
	public Line getTrail()
	{
		return this.trail;
	}
	
	//returns the color of the bike
	public Color getColor()
	{
		return this.color;
	}
	
}
