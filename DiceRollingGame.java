import java.util.Random;
import java.util.Scanner;

public class DiceRollingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char again;

        do {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;

            System.out.println("\n=== Dice Rolling Game ===");
            System.out.println("Dice 1: " + dice1);
            System.out.println("Dice 2: " + dice2);
            System.out.println("Total: " + (dice1 + dice2));

            System.out.print("Roll again? (Y/N): ");
            again = sc.next().charAt(0);

        } while (again == 'Y' || again == 'y');

        System.out.println("Game Over!");
        sc.close();
    }
}