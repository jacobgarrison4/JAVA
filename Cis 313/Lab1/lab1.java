import java.util.Scanner;

public class lab1 {
	public static void main(String[] args){
	
		// Create a Scanner that reads system input
		Scanner scanner = new Scanner(System.in);

		// Loop over the scanner's input
		// For each line of the input, send it to isPalindrome()
		// If isPalindrome returns true, print "This is a Palindrome." 
		// Otherwise print "Not a Palindrome."
		int numProblems = scanner.nextInt();
		for (int i = 0; i < numProblems; ++i){
			String s = scanner.nextLine();
			if (isPalindrome(s))
				System.out.println("This is a Palindrome.");
			else
				System.out.println("Not a Palindrome.");
		}
		// Close the Scanner
		scanner.close();		

	}
	
	public static boolean isPalindrome(String s){
	
		// Create a stack and a Queue of chars that represents the passed in string
		// Hint: While you loop through the given string, push the same char onto your stack
		//		 that you enqueue into your Queue. This way you can use dequeue to get 
		//       the string from left to right, but you pop the string from right to left
		
		// Compare your Queue and Stack to see if the input String was a Palindrome or not	
		Stack<Integer> S = new Stack<Integer>();
		Queue<Integer> Q = new Queue<Integer>();
		for (int i = 0; i < s.length(); ++i){
			int x = Character.getNumericValue(s.charAt(i));
			S.push(x);
			Q.enqueue(x);
		}

		while (Q.isEmpty() == false && S.isEmpty() == false){
			if (Q.dequeue().getData() != S.pop().getData()){
				return false;
			}
		}

		return true;
	}
	
	public static boolean isPalindromeEC(String s){
	
		// Implement if you wish to do the extra credit.
		return false;
	}
}
