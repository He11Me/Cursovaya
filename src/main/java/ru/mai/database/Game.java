package ru.mai.database;

public class Game {

    private String winner;

    private int numberId;

    public Game(String winner, int numberId) {
        this.winner = winner;
        this.numberId = numberId;
    }

    public int getNumberId() {
        return numberId;
    }

    public String getWinner() {
        return winner;
    }
}
