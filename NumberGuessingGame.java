import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and 100.");

            while (!guessedCorrectly && attempts < 10) { // Limiting attempts to 10
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    score += 10 - attempts; // Score based on attempts
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
