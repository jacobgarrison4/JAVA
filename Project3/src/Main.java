import java.util.Random;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		int rectCount = 0;
		int boxCount = 0;
		int circleCount = 0;
		int sphereCount = 0;
		double randNum = 0;
		
		ArrayList<Measurable> sumList = new ArrayList<Measurable>(1000);
		for (int i = 1; i <= 1000; i++)
		{
			randNum = nextDouble();
			if (randNum <= .25)
			{
				Rectangle rect = new Rectangle(nextDouble(), nextDouble());
				sumList.add(rect);
				rectCount += 1;
			}	
			
			else if (randNum > .25 && randNum <= .50)
			{
				Box box = new Box(nextDouble(), nextDouble(), nextDouble());
				sumList.add(box);
				boxCount += 1;
			}
			
			else if (randNum > .50 && randNum <= .75)
			{
				Circle circ = new Circle(nextDouble());
				sumList.add(circ);
				circleCount += 1;
			}
			
			else
			{
				Sphere sph = new Sphere(nextDouble());
				sumList.add(sph);
				sphereCount += 1;
			}
		}
			
		System.out.printf("%s: %s %s: %s %s: %s %s: %s%n%s: %s", 
				"Rectangles", rectCount, "Boxes", boxCount, "Circles", circleCount, "Spheres", sphereCount, "Sum", calculateSum(sumList));
	}
	
	private static double nextDouble()
	{
		Random randNum = new Random();
		return randNum.nextDouble();
	}
	
	private static double calculateSum(ArrayList<Measurable> sumList)
	{
		double sum = 0;
		for (int i = 0; i < sumList.size(); i++)
			sum += sumList.get(i).getArea();
		return sum;
	}

}
