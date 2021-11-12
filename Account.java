import java.util.Scanner;

public class Account {
	//declaring variables
	int balance;
	int previousTransaction;
	String customerName;
	String bankAccountNumber;
	
	Account(String cname, String ban){
		customerName = cname;
		bankAccountNumber = ban;
	}
	//deposit function
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	//withdrawal function
	void withdrawal(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	
		
	}
	//previous transaction function
	void getPreviousTransaction () {
		if (previousTransaction > 0) {
			System.out.println("Deposit: $" + previousTransaction);
		}
		else if (previousTransaction < 0) {
			System.out.println("Withdrawal: $" + previousTransaction);
		}
		else {
			System.out.println("There have been no transaction.");
		}
	}	
	//menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your account number is: " + bankAccountNumber);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A: Check your balance");
		System.out.println("B: Make a deposit");
		System.out.println("C: Make a withdrawal");
		System.out.println("D: Exit");
		
		do {
			System.out.println("");
			System.out.println("Please choose an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			
			case 'A':
				System.out.println("Your balance is: $" + balance);
				break;
			
			case 'B':
				System.out.println("Please enter the amount you would like to deposit: $");
				int deposit = scanner.nextInt();
				balance = balance + deposit;
				System.out.println("You have succesfully deposited $" + deposit + " into your bank account.");
				break;
				
			case 'C':
				System.out.println("Please enter the amount you would like to withdrawal: $");
				int withdrawal = scanner.nextInt();
				if (balance < withdrawal) {
					System.out.println("You have insufficient funds.  Please check your balance.");
				} else {
					balance = balance - withdrawal;
					System.out.println("You have succesfully withdrew $" + withdrawal + " from your bank account");
				}
				break;
				
			case 'D':
				System.out.println("");
				break;
				
			default:
				System.out.println("You have entered an invlalid option. Please enter A, B, C, or D.");
				break;
				
				} 
						
		}while (option != 'D');
			System.out.println("Thank you for banking with us!");
	}
}
