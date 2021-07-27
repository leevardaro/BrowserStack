package coinToss;
import java.util.Scanner;

public class coinToss{
	private int coin = 0;
	
	public int toss() {
	coin = (int)(Math.random() * 2) + 1;
	return coin;
}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int b;
		coinToss a;
		a = new coinToss();
		b = a.toss();
		
		int choice;
		System.out.println("Please enter your choice: 1 for Heads, 2 for Tails:");
		choice = scan.nextInt();
		System.out.println("Coin is " + b);
		if (choice == b)
			System.out.println("You chose correctly");
		else {
			System.out.println("You didn't chose correctly");
		}
	}}

