package org.example;

import javax.swing.*;
import java.awt.*;

public class SmallBoardPanel extends JPanel {

    public SmallBoardPanel(int boardRow, int boardCol) {
        setLayout(new GridLayout(3, 3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                CellButton[][] cells = new CellButton[3][3];
                cells[i][j] = new CellButton(boardRow, boardCol, i, j);
                add(cells[i][j]);
            }
        }
    }
}
