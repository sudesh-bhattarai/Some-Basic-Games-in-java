import java.util.Random;
import java.util.Scanner;

public class CoinTossGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char again;

        do {
            System.out.println("\n=== Coin Toss Game ===");
            System.out.print("Guess (Heads/Tails): ");
            String guess = sc.next();

            String result = random.nextBoolean() ? "Heads" : "Tails";

            System.out.println("Coin landed on: " + result);

            if (guess.equalsIgnoreCase(result)) {
                System.out.println("Correct Guess!");
                score++;
            } 
            else {
                System.out.println("Wrong Guess!");
            }

            System.out.println("Score: " + score);

            System.out.print("Play again? (Y/N): ");
            again = sc.next().charAt(0);

        } while (again == 'Y' || again == 'y');

        System.out.println("Final Score: " + score);
        sc.close();
    }
}