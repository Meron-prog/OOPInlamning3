import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClick implements ActionListener {
    private JButton[][] buttons;
    private GameBoard gameBoard;

    public ButtonClick(JButton[][] buttons, GameBoard gameBoard) {
        this.buttons = buttons;
        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (e.getSource() == buttons[row][column]) {
                    if (row > 0 && buttons[row-1][column] == null) {
                        buttons[row-1][column] = buttons[row][column];
                        buttons[row][column] = null;
                    } else if (row < 3 && buttons[row+1][column] == null) {
                        buttons[row+1][column] = buttons[row][column];
                        buttons[row][column] = null;
                    } else if (column > 0 && buttons[row][column-1] == null) {
                        buttons[row][column-1] = buttons[row][column];
                        buttons[row][column] = null;
                    } else if (column < 3 && buttons[row][column+1] == null) {
                        buttons[row][column+1] = buttons[row][column];
                        buttons[row][column] = null;
                    }
                    gameBoard.addButtonsToPanel();
                    MessageDisplay.checkIfCorrect(buttons);
                    return;
                }
            }
        }
    }
}
