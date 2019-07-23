import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0; // Initializes sum to 0
		Scanner input = new Scanner(System.in); // Used to scan user's input
		boolean running = true; // Keeps prompting until user quits
		while (running) {
		
			System.out.print("Enter a positive integer (-3 for current sum, -2 to reset, -1 to quit):\n"); // Prompt

			int num = input.nextInt(); // Scans user's input
		
			if (num == -1) {
				System.out.println("Sum: " + sum); // Prints current sum
				running = false; // Quits program
			}
			else if (num == -2) {
				sum = 0; // Resets sum to 0
			}
			else if (num == -3) {
				System.out.println("Sum: " + sum); // Prints current sum
			}
			else if (num > 0){
				sum += num; // Adds user's input to current sum if input is not 0 or negative
			}
		}
		
	}

}
