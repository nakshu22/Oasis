import java.util.*;

class Account {
    String accNo;
    String pin;
    double balance;

    Account(String accNo, String pin, double balance) {
        this.accNo = accNo;
        this.pin = pin;
        this.balance = balance;
    }
}

public class ATMInterface {
    static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample accounts
        accounts.put("1001", new Account("1001", "1234", 5000));
        accounts.put("1002", new Account("1002", "4321", 2500));

        System.out.println("🏧 ATM Interface");

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine().trim();

        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found ❌");
            sc.close();
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine().trim();

        if (!acc.pin.equals(pin)) {
            System.out.println("Invalid PIN ❌");
            sc.close();
            return;
        }

        System.out.println("✅ Login successful!");

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            String ch = sc.nextLine().trim();

            switch (ch) {
                case "1":
                    System.out.printf("Balance: ₹%.2f%n", acc.balance);
                    break;
                case "2":
                    System.out.print("Enter deposit amount: ");
                    double d = readDouble(sc);
                    if (d <= 0) System.out.println("Invalid amount.");
                    else {
                        acc.balance += d;
                        System.out.println("✅ Deposited successfully.");
                    }
                    break;
                case "3":
                    System.out.print("Enter withdraw amount: ");
                    double w = readDouble(sc);
                    if (w <= 0) System.out.println("Invalid amount.");
                    else if (w > acc.balance) System.out.println("Insufficient funds ❌");
                    else {
                        acc.balance -= w;
                        System.out.println("✅ Withdraw successful. Collect cash 💵");
                    }
                    break;
                case "4":
                    System.out.println("Thank you! 👋");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static double readDouble(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try { return Double.parseDouble(s); }
            catch (Exception e) { System.out.print("Enter a valid amount: "); }
        }
    }
}