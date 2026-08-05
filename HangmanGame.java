import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) {

        String[] words = {
                "java", "computer", "programming", "keyboard",
                "network", "internet", "database", "compiler",
                "software", "algorithm"
        };

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] guessedWord = new char[secretWord.length()];

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner sc = new Scanner(System.in);

        int attemptsLeft = 6;
        boolean guessed = false;

        System.out.println("=================================");
        System.out.println("        HANGMAN GAME");
        System.out.println("=================================");

        while (attemptsLeft > 0 && !guessed) {

            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Attempts Left: " + attemptsLeft);

            System.out.print("Enter a letter: ");
            char letter = Character.toLowerCase(sc.next().charAt(0));

            boolean found = false;

            for (int i = 0; i < secretWord.length(); i++) {

                if (secretWord.charAt(i) == letter) {
                    guessedWord[i] = letter;
                    found = true;
                }
            }

            if (!found) {
                attemptsLeft--;
                System.out.println("Wrong Guess!");
            } else {
                System.out.println("Correct Guess!");
            }

            guessed = true;

            for (char c : guessedWord) {
                if (c == '_') {
                    guessed = false;
                    break;
                }
            }
        }

        System.out.println();

        if (guessed) {
            System.out.println("Congratulations! You guessed the word.");
            System.out.println("Word: " + secretWord);
        } else {
            System.out.println("Game Over!");
            System.out.println("The correct word was: " + secretWord);
        }

        sc.close();
    }
}