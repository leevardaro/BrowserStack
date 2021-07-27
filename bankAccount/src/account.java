import java.text.NumberFormat;


public class Account {
	private long acctNum;
	private double balance;
	private String name;

	public Account (String iName,long acct, double startBal) {
		acctNum = acct;
		balance = startBal;
		name = iName;
	}
	public void deposit(double amount) {
		balance+= amount;
	}
	public void withdraw(double amount) {
		balance-=amount;
	}
	public double getBalance () {
		return balance;
	}
}
