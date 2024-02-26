import java.util.Scanner;

// Bank Account class to represent user's account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit amount into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw amount from the account
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; // Insufficient balance
        }
        balance -= amount;
        return true;
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class representing ATM machine
public class ATM {
    private BankAccount account;

    // Constructor to connect with the user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display ATM options
    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle ATM operations based on user input
    public void operateATM() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayOptions();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + account.checkBalance());
                    } else {
                        System.out.println("Insufficient balance. Withdrawal failed.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Updated balance: " + account.checkBalance());
                    break;
                case 3:
                    System.out.println("Your current balance: " + account.checkBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting ATM. Thank you for using our services!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initialize user's account with initial balance
        ATM atm = new ATM(userAccount); // Connect ATM with user's account
        atm.operateATM(); // Start ATM operations
    }
}
