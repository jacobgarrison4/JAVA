import java.util.Scanner;

public class lab0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int numProblems = scanner.nextInt();
		
		for(int i = 0; i < numProblems; ++i) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				int g = gcd(a,b);
				int l = lcm(a,b);
				
				System.out.println(g + " " + l);
		}
		
		scanner.close();
	}
	
	public static int gcd(int a, int b) {
		if(a == 0){return b;};
		if(b == 0){return a;};
		int q = a / b;
		int r = a - b * q;
		return gcd(b, r);
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
