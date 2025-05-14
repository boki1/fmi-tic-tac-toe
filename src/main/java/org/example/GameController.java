package org.example;

import org.jpl7.*;

import java.util.Map;

public class GameController {
    private static GameController instance;

    private GameController() {
        Query load = new Query("consult('game.pl')");  // Adjust to actual Prolog file
        if (!load.hasSolution()) {
            throw new RuntimeException("Failed to load Prolog game file.");
        }
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public String makeMove(int bigRow, int bigCol, int smallRow, int smallCol) {
        String move = String.format("make_move(%d,%d,%d,%d,Player,NextBoard,Result)", bigRow, bigCol, smallRow, smallCol);
        Query query = new Query(move);

        if (query.hasSolution()) {
            Map<String, Term> result = query.oneSolution();
            String player = result.get("Player").toString();
            String nextBoard = result.get("NextBoard").toString();
            String resultStatus = result.get("Result").toString();

            System.out.printf("Prolog move: player=%s, nextBoard=%s, result=%s%n", player, nextBoard, resultStatus);
            return player;
        } else {
            System.out.println("Invalid move.");
            return null;
        }
    }
}
