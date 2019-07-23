import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {

        // Loop over the Scanner
        Scanner scanner = new Scanner(System.in);
        BST<Integer> bst = new BST<Integer>();
        // Split each line into the task and the corresponding number (if one exists)
        // Depending on what the input task was, preform the corresponding function
        //      (ie) insert, delete, find, inoder, preorder, or postorder
        // Hint: Use a switch-case statement
        int numProblems = scanner.nextInt();
        while (scanner.hasNextLine()){
        	String input = scanner.nextLine();
        	String[] phrases = input.split(" ");
        	String cmd = phrases[0];
        
        	switch (cmd) {
        		case "insert":
        			int inum = Integer.parseInt(phrases[1]);
        			bst.insert(inum);
        			break;

        		case "delete":
        			int dnum = Integer.parseInt(phrases[1]);
        			bst.delete(dnum);
        			break;

        		case "preorder":
        			bst.traverse(cmd, bst.getRoot());
        			System.out.print("\n");
        			break;

        		case "postorder":
        			bst.traverse(cmd, bst.getRoot());
        			System.out.print("\n");
        			break;

        		case "inorder":
        			bst.traverse(cmd, bst.getRoot());
        			System.out.print("\n");
        			break;

        		case "find":
        			int fnum = Integer.parseInt(phrases[1]);
        			bst.find(fnum);
        			break;
        
        	}
        }
        // Don't forget to close your Scanner!
        scanner.close();
}
}