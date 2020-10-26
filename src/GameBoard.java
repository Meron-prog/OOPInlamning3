import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoard extends JFrame {
    private JPanel panel = new JPanel();
    private JButton[][] buttons = new JButton[4][4];
    private JButton newGameButton = new JButton("New game");

    public GameBoard() {
        panel.setLayout(new GridLayout(4, 4, 2, 2));
        panel.setBackground(Color.white);
        createButtonsArray();
        scramble();
        addButtonsToPanel();

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons = new JButton[4][4];
                createButtonsArray();
                scramble();
                addButtonsToPanel();
            }
        });

        add(panel, BorderLayout.CENTER);
        add(newGameButton, BorderLayout.PAGE_END);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createButtonsArray() {
        int nummer = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (row == 3 && column == 3) {
                } else {
                    nummer++;
                    buttons[row][column] = new JButton(Integer.toString(nummer));
                    buttons[row][column].setSize(50, 50);
                    buttons[row][column].setBackground(Color.pink);
                    buttons[row][column].addActionListener(new ButtonClick(buttons, this));
                }
            }
        }
    }

    public void scramble() {
        boolean[] usedNumber = new boolean[16];
        Random random = new Random();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (buttons[row][column] != null) {
                    int randomNumber = random.nextInt(15) + 1;
                    while (usedNumber[randomNumber]) {
                        randomNumber = random.nextInt(15) + 1;
                    }
                    usedNumber[randomNumber] = true;
                    buttons[row][column].setText("" + randomNumber);
                }
            }
        }
    }

    public void addButtonsToPanel() {
        panel.removeAll();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (buttons[row][column] == null) {
                    panel.add(new JPanel());
                } else {
                    panel.add(buttons[row][column]);
                }
            }
        }
        panel.validate();
    }
}
