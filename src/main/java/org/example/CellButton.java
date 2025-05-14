package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellButton extends JButton {
    private final int bigRow;
    private final int bigCol;
    private final int cellRow;
    private final int cellCol;

    public CellButton(int bigRow, int bigCol, int cellRow, int cellCol) {
        this.bigRow = bigRow;
        this.bigCol = bigCol;
        this.cellRow = cellRow;
        this.cellCol = cellCol;
        setFont(getFont().deriveFont(24f));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleMove();
            }
        });
    }

    private void handleMove() {
        String move = String.format("move(%d,%d,%d,%d)", bigRow, bigCol, cellRow, cellCol);
        System.out.println("Sending move to Prolog: " + move);
        String result = GameController.getInstance().makeMove(bigRow, bigCol, cellRow, cellCol);
        if (result != null) {
            setText(result);  // Sets "X" or "O" depending on who moved
            setEnabled(false);
        }
    }
}
