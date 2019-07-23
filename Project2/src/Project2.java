import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Project2 {
	
	static int array_length = 0;
	static double density = 0;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean running = true;
		while(running) {
			try {
				System.out.print("Enter array length: ");
				array_length = input.nextInt();
				
				System.out.print("Enter density: ");
				density = input.nextDouble();
			}
			catch (InputMismatchException e) {
				System.out.print("Invalid array length or density.");
			}
			if (array_length > 0) {
				if (density >= 0.0 && density < 1.0) {
					running = false;
				}
			}
		}

	       int[] dArray = CreateDense(array_length, density);
	       ConvertToSparse(dArray);
	       ArrayList<int[]> sArray = CreateSparse(array_length, density);
	       ConvertToDense(sArray, array_length);
	       FindMaxD(dArray);
	       FindMaxS(sArray);
	}
	public static int[] CreateDense(
				int array_length,
				double density) {
		long start = System.nanoTime();
		int dArray[] = new int[array_length];
		Random randNum = new Random();
		
		for (int i = 0; i < array_length; i++) {
			if (randNum.nextDouble() < density) {
				dArray[i] = randNum.nextInt(10000000) + 1;
			}
			else {
				dArray[i] = 0;
			}
		}
		
		long end = System.nanoTime();
		double time = (end - start) / 1000000.0;
		System.out.println("Create dense length: " + array_length + " time: " + time);
		return dArray;
	}
	
	public static ArrayList<int[]> CreateSparse(
			int array_length,
			double density) {
		long start = System.nanoTime();
		double randNum;
		Random num = new Random();
		ArrayList<int[]> sArray = new ArrayList<int[]>(array_length);
		for (int i = 0; i < array_length; i++) {
			randNum = num.nextDouble();
			if (randNum < density) {
				int[] list = new int[2];
				list[0] = i;
				list[1] = num.nextInt(10000000) + 1;
				sArray.add(list);
			}
		}
		
		long end = System.nanoTime();
		double time = (end - start) / 1000000.0;
		System.out.println("Create sparse length: " + sArray.size() + " time: " + time);
		return sArray;
		}
	public static ArrayList<int[]> ConvertToSparse(
			int[] dArray) {
		long start = System.nanoTime();
		ArrayList<int[]> sArray = new ArrayList<int[]>(dArray.length);
		for (int i = 0; i < dArray.length; i++) {
			if (dArray[i] != 0) {
				int[] array = new int[2];
				array[0] = i;
				array[1] = dArray[i];
				sArray.add(array);
			}
		}
		long end = System.nanoTime();
		double time = (end - start) / 1000000.0;
		System.out.println("Convert to sparse length: " + sArray.size() + " time: " + time);
		return sArray;
	}
	public static int[] ConvertToDense(
				ArrayList<int[]> sArray,
				int aarray_length) {
		long start = System.nanoTime();
		if (sArray == null) {
			long end = System.nanoTime();
	        double duration = (end - start) / 1000000.0;
	        System.out.println("convert to dense length: " + null + " time: " + duration);
		}
		int array_length = sArray.size();
	    int[] index = sArray.get(array_length-1);
	    int[] dArray = new int[index[0]+1];
	    for(int i = 0; i < array_length ; i++){
	        int [] check = sArray.get(i);
	        int newIndex = check[0];
	        int app = check[1];
	        dArray[newIndex] = app;
	    }
		long end = System.nanoTime();
		double time = (end - start) / 1000000.0;
		System.out.println("Convert to dense length: " + dArray.length + " time: " + time);
		return dArray;
	}
	public static void FindMaxD(
				int[] dArray) {
		long start = System.nanoTime();
		int max = 0;
		int index = 0;
		for (int i = 0; i < dArray.length; i++) {
			if (dArray[i] > max) {
				max = dArray[i];
				index = i;
			}
		}
		System.out.println("Find max (dense): " + max + " at: " + index);
		long end = System.nanoTime();
		double time = (end - start) / 1000000.0;
		System.out.println("Dense find time: " + time);
	}
	
	public static void FindMaxS(ArrayList<int[]> sArray){
	    long start = System.nanoTime();
	    int max = 0;
	    int counter = 0;

	    for(int i=0; i < sArray.size(); i++){
	        int[] current = sArray.get(i);
	        if(current[1] > max){
	            max = current[1];
	            counter = current[0];
	        }
	    }

	    System.out.println("find max (sparse): " + max + " at: " + counter );
	    long end = System.nanoTime();
	    double time = (end - start) / 1000000.0;
	    System.out.println("sparse find time: " + time);
	   }
	}
