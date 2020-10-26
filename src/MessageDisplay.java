import javax.swing.*;

public class MessageDisplay {

    public static void checkIfCorrect(JButton[][] buttons) {
        int number = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if(buttons[row][column] == null && (row != 3 || column != 3)) {
                    return;
                } else if(buttons[row][column] == null && row == 3 && column == 3) {
                    JOptionPane.showMessageDialog(null, "Congratulation you win!");
                    return;
                }
                number++;
                if (!buttons[row][column].getText().equals(Integer.toString(number))) {
                    return;
                }
            }

        }
    }
}