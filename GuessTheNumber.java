import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int secretNumber;
        int attempts;
        int round = 0;
        int totalAttempts = 0;
        
        System.out.println("Welcome to the Guess the Number game!");
        
        do {
            round++;
            secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            attempts = 0;
            
            System.out.println("Round " + round);
            System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");
            
            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess should be between " + minRange + " and " + maxRange + ". Try again.");
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);
        
        System.out.println("Thanks for playing! Your total score is based on the total number of attempts: " + totalAttempts);
        scanner.close();
    }
}
