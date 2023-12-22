package ru.mai.game;

import ru.mai.database.Game;
import ru.mai.database.GamePersistance;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryMaker extends JLabel {

    private GamePersistance gamePersistance = new GamePersistance();
    private List<Game> history = new ArrayList<>();

    private String historyOfWinners = "";

    public HistoryMaker() {
        view();
    }

    public void view() {
        history = gamePersistance.getAll();
        int i = 0;
        for (Game game: history) {
            historyOfWinners += Integer.toString(game.getNumberId());
            historyOfWinners += (" - " + game.getWinner() + " ");
        }
        setText(historyOfWinners);
    }
}
