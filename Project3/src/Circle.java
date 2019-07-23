
public class Circle implements Measurable
{
	protected double radius;
	
	//Constructor
	public Circle(double radius)
	{
		if (radius < 0.0) //Validate radius
			throw new IllegalArgumentException("Radius must be > 0.0");
		
		this.radius = radius;
	}
	
	public void setRadius(double radius)
	{
		if (radius < 0.0) //Validate radius
			throw new IllegalArgumentException("Radius must be > 0.0");
		
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public double getArea() //Calculate area of circle
	{
		return Math.PI * (radius * radius);
	}
}
