import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private int lowerBound;
    private int upperBound;
    private int secretNumber;
    private int numberOfTries;
    private boolean hasGuessedCorrectly;

    public GuessTheNumberGame(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.secretNumber = generateRandomNumber(lowerBound, upperBound);
        this.numberOfTries = 0;
        this.hasGuessedCorrectly = false;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Can you guess what it is?");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfTries++;

            if (userGuess == secretNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + numberOfTries + " tries.");
            } else if (userGuess < secretNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame(1, 100);
        game.play();
    }
}
