/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    JPanel panel= new JPanel();
    JButton[][] buttons= new JButton[4][4];
    JButton newGameButton= new JButton("New game");

    public GameBoard(){
        panel.setLayout(new GridLayout(4,4));
        add(panel, BorderLayout.CENTER);

        createButtonsArray();
        addButtonsToPanel();

        setSize(500,500);
        panel.setBackground(Color.white);
        //panel.add(newGameButton);
        add(newGameButton, BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addButtonsToPanel() {
        panel.removeAll();
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                if(buttons[a][b] == null) {
                    panel.add(new JPanel());
                } else {
                    panel.add(buttons[a][b]);
                }
            }
        }
        panel.validate();
    }

    private void createButtonsArray() {
        int nummer=0;
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                if(a==3 && b==3) {
                } else {
                    nummer++;
                    buttons[a][b] = new JButton(Integer.toString(nummer));
                    buttons[a][b].setSize(50, 50);
                    buttons[a][b].setBackground(Color.pink);
                }
            }
        }
    }


}
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoard extends JFrame  {
    JPanel panel= new JPanel();
    JButton[][] buttons= new JButton[4][4];
    JButton newGameButton= new JButton("New game");

    public GameBoard(){
        panel.setLayout(new GridLayout(4,4,2,2));
        add(panel, BorderLayout.CENTER);

        createButtonsArray();
        addButtonsToPanel();





        setSize(500,500);
        panel.setBackground(Color.white);
        //panel.add(newGameButton);
        add(newGameButton, BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addButtonsToPanel() {
        panel.removeAll();
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                if(buttons[a][b] == null) {
                    panel.add(new JPanel());

                } else {
                    panel.add(buttons[a][b]);

                }
            }
        }
        panel.validate();
    }
    public void scramble(GameBoard gameBoard) {
        boolean[] used = new boolean[16];
        JButton[][] buttons = new JButton[4][4];
        Random random = new Random();
        JButton num;


        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                int val = (int) (16 * Math.random());

                while (used[val]) {
                    val=(int)(16*Math.random());
                }
                used[val]=true;
                if (val!=0)
                    buttons[a][b].setText(""+val);
                else {
                    buttons[a][b].setBackground(Color.black);
                }



            }
        }
    }

    private void createButtonsArray() {
        int nummer=0;
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                if(a==3 && b==3) {
                } else {
                    nummer++;
                    buttons[a][b] = new JButton(Integer.toString(nummer));
                    buttons[a][b].setSize(50, 50);
                    buttons[a][b].setBackground(Color.pink);
                    buttons[a][b].addActionListener(new ButtonClick(buttons,this));
                }
            }
        }
    }



}
