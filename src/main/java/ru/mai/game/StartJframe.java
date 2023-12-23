package ru.mai.game;

import ru.mai.consts.Consts;
import ru.mai.database.GamePersistance;

import javax.swing.*;
import java.awt.*;

public class StartJframe extends JFrame {

    private JPanel panel = new JPanel();
    GamePersistance gamePersistance = new GamePersistance();
    CardsProcessing cardsProcessing = new CardsProcessing();

    public StartJframe() {
        this.setTitle("Главное меню");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Consts.THREE_HUNDRED, Consts.TWO_HUNDRED));
        this.setLocation(Consts.NINE_HUNDRED, Consts.FOUR_HUNDRED);
        JButton start = new JButton("Начать игру");
        JButton history = new JButton("История игр");
        JButton close = new JButton("Закрыть игру");

        panel.setLayout(new FlowLayout());
        panel.add(start);
        panel.add(history);
        panel.add(close);

        this.add(panel, BorderLayout.CENTER);

        start.addActionListener(s -> {
            cardsProcessing.startCards();
            CardJframe cardJframe = new CardJframe();
            cardJframe.setVisible(true);
            cardJframe.pack();
        });

        history.addActionListener(s -> {
            HistoryJframe historyJframe = new HistoryJframe();
            historyJframe.setVisible(true);
            historyJframe.pack();
        });

        close.addActionListener(e -> {
            gamePersistance.deleteAllGames();
            System.exit(0);
        });
    }
}