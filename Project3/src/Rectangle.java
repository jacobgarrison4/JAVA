
public class Rectangle implements Measurable
{
	protected double width;
	protected double length;
	
	//Constructor
	public Rectangle(double length, double width)
	{
		if (length < 0.0) //Validate length
			throw new IllegalArgumentException("Length must be >= 0");
		
		if (width < 0.0) //Validate width
			throw new IllegalArgumentException("Width must be >= 0");
		
		this.length = length;
		this.width = width;
	}
	
	public void setWidth(double width)
	{
		if (width < 0.0) //Validate width
			throw new IllegalArgumentException("Width must be >= 0");
		
		this.width = width;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setLength(double length)
	{
		if (length < 0.0) //Validate length
			throw new IllegalArgumentException("Length must be >= 0");
		
		this.length = length;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getArea() //Calculate area of rectangle
	{
		return (length * width);
	}
}
