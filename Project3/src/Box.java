
public class Box extends Rectangle
{
	private double height;
	
	//Constructor
	public Box(double length, double width, double height)
	{
		super(length, width);
		
		if (height < 0.0) //Validate height
			throw new IllegalArgumentException("Height must be >= 0");
		
		this.height = height;
	}
	
	public double getArea() //Calculate surface area
	{
		double sArea = (2 * (height * width)) + (2 * (height * length)) + (2 * (length * width));
		return sArea;
	}
}
