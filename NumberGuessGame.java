import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class NumberGuessGame extends JFrame implements ActionListener {

    Random random = new Random();
    int targetNumber;
    int attempts = 0;

    JTextField inputField;
    JLabel messageLabel, attemptLabel;
    JButton guessButton, restartButton;

    NumberGuessGame() {
        setTitle("Guess the Number");
        setSize(350, 300);
        setLayout(new GridLayout(7, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        targetNumber = random.nextInt(100) + 1;

        JLabel instruction = new JLabel("Guess a number between 1 and 100", JLabel.CENTER);

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);

        guessButton = new JButton("Guess");
        restartButton = new JButton("Restart");

        messageLabel = new JLabel(" ", JLabel.CENTER);
        attemptLabel = new JLabel("Attempts: 0", JLabel.CENTER);

        guessButton.addActionListener(this);
        restartButton.addActionListener(this);

        add(instruction);
        add(inputField);
        add(guessButton);
        add(messageLabel);
        add(attemptLabel);
        add(restartButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == restartButton) {
            resetGame();
            return;
        }

        try {
            int guess = Integer.parseInt(inputField.getText());
            attempts++;
            attemptLabel.setText("Attempts: " + attempts);

            if (guess > targetNumber) {
                messageLabel.setText("Too High");
            } else if (guess < targetNumber) {
                messageLabel.setText("Too Low");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Correct! You guessed in " + attempts + " attempts");
                resetGame();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }

        inputField.setText("");
    }

    void resetGame() {
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;
        messageLabel.setText(" ");
        attemptLabel.setText("Attempts: 0");
        inputField.setText("");
    }

    public static void main(String[] args) {
        new NumberGuessGame();
    }
}

