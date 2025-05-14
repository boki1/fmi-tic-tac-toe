package org.example;

import javax.swing.*;
import java.awt.*;

public class UltimateTicTacToeUI extends JFrame {

    public UltimateTicTacToeUI() {
        setTitle("Ultimate Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(new GridLayout(3, 3, 5, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SmallBoardPanel[][] boards = new SmallBoardPanel[3][3];
                boards[i][j] = new SmallBoardPanel(i, j);
                add(boards[i][j]);
            }
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UltimateTicTacToeUI::new);
    }
}
