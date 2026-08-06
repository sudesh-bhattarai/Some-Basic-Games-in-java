import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorGame {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();

            String[] choices = {"Rock", "Paper", "Scissors"};

            int playerScore = 0;
            int computerScore = 0;
            char playAgain = 'Y';

            do {
                System.out.println("\n=== Rock Paper Scissors ===");
                System.out.println("1. Rock");
                System.out.println("2. Paper");
                System.out.println("3. Scissors");
                System.out.print("Enter your choice: ");

                int playerChoice = sc.nextInt();

                if (playerChoice < 1 || playerChoice > 3) {
                    System.out.println("Invalid choice!");
                    continue;
                }

                int computerChoice = random.nextInt(3) + 1;

                System.out.println("You chose: " + choices[playerChoice - 1]);
                System.out.println("Computer chose: " + choices[computerChoice - 1]);

                if (playerChoice == computerChoice) {
                    System.out.println("It's a Draw!");
                } else if ((playerChoice == 1 && computerChoice == 3) ||
                           (playerChoice == 2 && computerChoice == 1) ||
                           (playerChoice == 3 && computerChoice == 2)) {
                    System.out.println("You Win!");
                    playerScore++;
                } else {
                    System.out.println("Computer Wins!");
                    computerScore++;
                }

                System.out.println("Score -> You: " + playerScore + " Computer: " + computerScore);

                System.out.print("Play again? (Y/N): ");
                playAgain = sc.next().charAt(0);

            } while (playAgain == 'Y' || playAgain == 'y');

            System.out.println("Thanks for playing!");
        }
    }
}
