
public class Sphere extends Circle
{
	//Constructor
	public Sphere(double radius)
	{
		super(radius);
	}
	
	public double getArea() //Calculate surface area
	{
		double sArea = 4 * super.getArea();
		return sArea;
	}
}
