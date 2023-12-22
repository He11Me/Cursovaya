package ru.mai.game;

import ru.mai.consts.Consts;

import javax.swing.*;
import java.awt.*;

public class StartJframe extends JFrame {

    private JPanel panel = new JPanel();

    public StartJframe() {
        this.setTitle("Главное меню");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Consts.THREE_HUNDRED, Consts.TWO_HUNDRED));
        this.setLocation(Consts.NINE_HUNDRED, Consts.FOUR_HUNDRED);
        JButton start = new JButton("Начать игру");
        JButton history = new JButton("История игр");

        panel.setLayout(new FlowLayout());
        panel.add(start);
        panel.add(history);

        this.add(panel, BorderLayout.CENTER);

        start.addActionListener(s -> {
            CardJframe cardJframe = new CardJframe();
            cardJframe.setVisible(true);
            cardJframe.pack();
        });

        history.addActionListener(s -> {
            HistoryJframe historyJframe = new HistoryJframe();
            historyJframe.setVisible(true);
            historyJframe.pack();
        });
    }
}