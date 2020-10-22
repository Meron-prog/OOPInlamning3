import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    JPanel panel= new JPanel();
    JButton[][] buttons= new JButton[4][4];


    public GameBoard(){
        panel.setLayout(new GridLayout(4,4));
        add(panel);

        int nummer=0;
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                nummer++;
                buttons[a][b]= new JButton(Integer.toString(nummer));
                buttons[a][b].setSize(50,50);
                panel.add(buttons[a][b]);
            }
        }
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
