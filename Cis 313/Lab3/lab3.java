import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {
    
    	// Loop over the Scanner
        // Split each line into the task and the corresponding number (if one exists)
        // Depending on what the input task was, preform the corresponding function
        //      (ie) insert, maximum, extractMax, isEmpty, or print
        // Hint: Use a switch-case statement
		// Don't forget to close your Scanner!
		Scanner scanner = new Scanner(System.in);
		int numLines = scanner.nextInt();
		pQueue<Integer> pQ = new pQueue<Integer>(numLines);
		scanner.nextLine();

		for (int i = 0; i < numLines; i++){
			String input = scanner.nextLine();
			String[] phrase = input.split(" ");
			String cmd = phrase[0];

			switch(cmd){
				case "insert":
					pQ.insert(Integer.parseInt(phrase[1]));
					break;

				case "maximum":
					System.out.println(pQ.maximum());
					break;

				case "extractMax":
					System.out.println(pQ.extractMax());
					break;

				case "isEmpty":
					if (pQ.isEmpty()){
						System.out.print("Empty\n");
					}
					else{
						System.out.print("Not Empty\n");
					}

					break;

				case "print":
					pQ.print();
					break;

				case "build":
					String [] array = phrase[1].split(",");
					Integer[] intArray = new Integer[array.length + 1];
					for (int j = 1; j < intArray.length; j++){
						intArray[j] = Integer.parseInt(array[j - 1]);
					}

					pQ.build(intArray);
					break;
			}
		}
    }
}
