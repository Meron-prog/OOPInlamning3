import javax.swing.*;

public class MessageDisplay {

    public static void checkIfCorrect(JButton[][] buttons) {
        int number = 0;
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if(buttons[a][b] == null && (a != 3 || b != 3)) {
                    return;
                } else if(buttons[a][b] == null && a == 3 && b == 3) {
                    JOptionPane.showMessageDialog(null, "Congratulation you win!");
                    return;
                }
                number++;
                if (!buttons[a][b].getText().equals(Integer.toString(number))) {
                    return;
                }
            }

        }
    }
}