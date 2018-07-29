package tron;

//Class for the sake of storing starting and ending points
// of all of the lines I'm going to need for redrawing cleanly

public class Line {

	private Point startPoint;
	private Point endPoint;
	private int[] coordinates = new int[4]; //[start x, start y, end x, end y]
	
	public Line()
	{
		this.startPoint = new Point(0, 0);
		this.endPoint = new Point(10, 10);
		this.setCoordinates();
	}
	
	//give two points and create a line
	public Line(Point p1, Point p2)
	{
		this.startPoint = p1;
		this.startPoint = p2;
		this.setCoordinates();
	}
	
	//give four coords and create a line
	public Line(int x1, int y1, int x2, int y2)
	{
		this.startPoint = new Point(x1, y1);
		this.endPoint = new Point(x2, y2);
		this.setCoordinates();
	}
	
	//fills the array with the coordinates
	public void setCoordinates()
	{
		coordinates[0] = startPoint.getPointX();
		coordinates[1] = startPoint.getPointY();
		coordinates[2] = endPoint.getPointX();
		coordinates[3] = endPoint.getPointY();
	}
	
	//Getters and setters
	public Point getStartPoint()
	{
		return this.startPoint;
	}
	
	public void setStartPoint(Point p)
	{
		this.startPoint = p;
	}
	
	public Point getEndPoint()
	{
		return this.endPoint;
	}
	
	public void setEndPoint(Point p)
	{
		this.endPoint = p;
	}
	
	public int[] getCoordinates()
	{
		return this.coordinates;
	}
	
	public String toString()
	{
		return "Start Point: " + startPoint + "\t End Point: " + endPoint;
	}
	
}
