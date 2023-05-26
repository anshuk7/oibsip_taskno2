import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 5;
        int totalRounds = 3;

        Random random = new Random();
        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            
            JOptionPane.showMessageDialog(null, "Round " + round + " of " + totalRounds + "\nGuess the number between " + minNumber + " and " + maxNumber);

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Enter your guess:");
                int userNumber = Integer.parseInt(input);
                attempts++;

                if (userNumber == randomNumber) {
                    int roundScore = maxAttempts - attempts + 1;
                    score += roundScore;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number in " + attempts + " attempts.\nRound Score: " + roundScore);
                    break;
                } else if (userNumber < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is lower than the generated number. Try again!");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is higher than the generated number. Try again!");
                }
            }
            
            if (attempts == maxAttempts) {
                JOptionPane.showMessageDialog(null, "Game Over! You ran out of attempts.\nThe correct number was: " + randomNumber);
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over!\nTotal Score: " + score);
    }
}
