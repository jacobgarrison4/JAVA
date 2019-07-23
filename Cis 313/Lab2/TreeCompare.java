import java.util.Scanner;

public class TreeCompare{
	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		BST tree1 = new BST<>();
		BST tree2 = new BST<>();
		int numLines = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < numLines; ++i){

			String input = scanner.nextLine();
			String[] phrase = input.split(" ");
			String cmd = phrase[0];

			switch(cmd){
				case "insert":
				int ival = Integer.parseInt(phrase[1]);
				tree1.insert(ival);
				break;

				case "delete":
				int dval = Integer.parseInt(phrase[1]);
				tree1.delete(dval);
				break;
			}
		}

		numLines = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < numLines; ++i){

			String input = scanner.nextLine();
			String[] phrase = input.split(" ");
			String cmd = phrase[0];

			switch(cmd){
				case "insert":
				int ival = Integer.parseInt(phrase[1]);
				tree1.insert(ival);
				break;

				case "delete":
				int dval = Integer.parseInt(phrase[1]);
				tree1.delete(dval);
				break;
			}
		}

		boolean sameTree = tree1.compare(tree1.getRoot(), tree2.getRoot());

		if (sameTree == true){
			System.out.print("The trees have the same shape. \n");
		}

		else {
			System.out.print("The trees do not have the same shape. \n");
		}

		scanner.close();
	}
}