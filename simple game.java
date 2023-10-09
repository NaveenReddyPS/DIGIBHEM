import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        int randomNumber = (int) (Math.random() * 100) + 1;

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialize the number of guesses
        int numberOfGuesses = 0;

        // Number of guessess
        int maxGuesses = 10;
         
        // Some information about this game 
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Try to guess it.");
        System.out.println("You have " + maxGuesses + " chances to guess the number.");

        // Start the game loop
        while (numberOfGuesses < 10) {

            // Prompt the user to enter a guess
            System.out.println("Enter your guess: ");

            // Try to read the guess as an integer
            try {
                int guess = scanner.nextInt();

                // Check if the guess is within the valid range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number from 1 to 100 only.");
                    continue;
                }

                // Check if the guess is correct
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number!" +"You Win");
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            } catch (InputMismatchException e) {
                // If the user did not enter an integer, print an error message
                System.out.println("Please enter a valid integer.");
            }

            // Increment the number of guesses
            numberOfGuesses++;
        }

        // If the user ran out of guesses
        if (numberOfGuesses == 10) {
            System.out.println("Sorry, you ran out of guesses. The correct number was " + randomNumber + ".");
        }
         // Calculate and display the user's score
        int score = maxGuesses - numberOfGuesses;
        System.out.println("Your score is: " + score);

        // Close the Scanner object
        scanner.close();
    }
}