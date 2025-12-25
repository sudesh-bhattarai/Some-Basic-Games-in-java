import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    JButton[] buttons = new JButton[9];
    boolean playerX = true; // true = X, false = O

    TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) {
            return; // already clicked
        }

        if (playerX) {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }

        playerX = !playerX;

        checkWinner();
    }

    void checkWinner() {
        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] pos : winPositions) {
            String b1 = buttons[pos[0]].getText();
            String b2 = buttons[pos[1]].getText();
            String b3 = buttons[pos[2]].getText();

            if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                JOptionPane.showMessageDialog(this, "Player " + b1 + " Wins!");
                resetGame();
                return;
            }
        }

        boolean draw = true;
        for (JButton b : buttons) {
            if (b.getText().equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            JOptionPane.showMessageDialog(this, "It's a Draw!");
            resetGame();
        }
    }

    void resetGame() {
        for (JButton b : buttons) {
            b.setText("");
        }
        playerX = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
