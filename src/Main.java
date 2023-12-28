import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int smallestnumber = 1;
        int largestnumber = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Computer  have selected a number between 1 to 100. Try to guess it.");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(largestnumber - smallestnumber + 1) + smallestnumber;
            int numberOfTries = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("New round!");

            while (numberOfTries < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Guess the computer number: ");
                int userGuess = scanner.nextInt();
                numberOfTries++;

                if (userGuess < smallestnumber || userGuess > largestnumber) {
                    System.out.println("Please enter a number between " + smallestnumber + " and " + largestnumber + ".");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                    score += calculateScore(numberOfTries, maxAttempts);
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int calculateScore(int numberOfTries, int maxAttempts) {
        // Adjust the scoring logic as needed
        return (maxAttempts - numberOfTries + 1) * 10;
    }
}
