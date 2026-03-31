import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("🎯 Number Guessing Game");
        boolean play = true;

        while (play) {
            int target = rand.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nGuess a number between 1 and 100");

            while (true) {
                System.out.print("Your guess: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Enter a valid number!");
                    sc.next();
                    continue;
                }
                int guess = sc.nextInt();
                attempts++;

                if (guess < target) System.out.println("Too low ⬇️");
                else if (guess > target) System.out.println("Too high ⬆️");
                else {
                    System.out.println("Correct! 🎉 Attempts: " + attempts);
                    break;
                }
            }

            System.out.print("Play again? (y/n): ");
            String ans = sc.next();
            play = ans.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing 👋");
        sc.close();
    }
}