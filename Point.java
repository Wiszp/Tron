package tron;

public class Point {

	//instance variables
	private int x;
	private int y;
	
	//constructors
	public Point()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Point (int px, int py)
	{
		this.x = px;
		this.y = py;
	}
	
	//returns the x coordinate
	public int getPointX()
	{
		return this.x;
	}

	//returns the y coordinate
	int getPointY()
	{
		return this.y;
	}
	
	//sets the point to a new location
	public void setPoint(int nx, int ny)
	{
		this.x = nx;
		this.y = ny;
	}
	
	public Point getPoint()
	{
		return this;
	}
	
	public String toString()
	{
		return "X Coordinate: " + this.getPointX() + "\t Y Coordinate: " + this.getPointY();
	}
}
