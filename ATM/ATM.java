import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int correctPin = 1234;
        int pin;
        int attempts = 0;
        int balance = 5000;
        int choice;
        int amount;

        String[] history = new String[100];
        int count = 0;

        // Login system
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            pin = input.nextInt();

            if (pin == correctPin) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN. Try again.");
            }
        }

        if (attempts == 3) {
            System.out.println("Maximum attempts reached. Account locked.");
        } else {

            // Main menu
            while (true) {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                choice = input.nextInt();

                if (choice == 1) {

                    System.out.println("Your balance is: " + balance);

                } else if (choice == 2) {

                    System.out.print("Enter amount to deposit: ");
                    amount = input.nextInt();

                    if (amount > 0) {
                        balance = balance + amount;

                        history[count] = "Deposited: " + amount;
                        count++;

                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid amount.");
                    }

                } else if (choice == 3) {

                    System.out.print("Enter amount to withdraw: ");
                    amount = input.nextInt();

                    if (amount > 0 && amount <= balance) {
                        balance = balance - amount;

                        history[count] = "Withdrawn: " + amount;
                        count++;

                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }

                } else if (choice == 4) {

                    System.out.println("Transaction History:");

                    for (int i = 0; i < count; i++) {
                        System.out.println(history[i]);
                    }

                    if (count == 0) {
                        System.out.println("No transactions yet.");
                    }

                } else if (choice == 5) {

                    System.out.println("Thank you for using our ATM!");
                    break;

                } else {

                    System.out.println("Invalid choice. Try again.");
                }
            }
        }

    }
}