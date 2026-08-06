import java.util.*;

public class WordScrambleGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] words = {
                "computer",
                "java",
                "keyboard",
                "monitor",
                "internet",
                "software",
                "database",
                "compiler",
                "algorithm",
                "network"
        };

        String word = words[random.nextInt(words.length)];

        List<Character> letters = new ArrayList<>();

        for (char c : word.toCharArray()) {
            letters.add(c);
        }

        Collections.shuffle(letters);

        StringBuilder scrambled = new StringBuilder();

        for (char c : letters) {
            scrambled.append(c);
        }

        System.out.println("=== Word Scramble Game ===");
        System.out.println("Unscramble this word:");
        System.out.println(scrambled);

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Your Guess: ");
            String guess = sc.next();

            if (guess.equalsIgnoreCase(word)) {
                System.out.println("Congratulations! Correct Answer.");
                sc.close();
                return;
            } else {
                attempts--;
                if (attempts > 0)
                    System.out.println("Wrong! Attempts Left: " + attempts);
            }
        }

        System.out.println("Game Over!");
        System.out.println("Correct Word: " + word);

        sc.close();
    }
}