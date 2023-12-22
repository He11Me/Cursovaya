package ru.mai.game;

import ru.mai.consts.Consts;

import javax.swing.*;
import java.awt.*;

public class HistoryJframe extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelForHistory = new JPanel();
    HistoryMaker historyMaker = new HistoryMaker();

    public HistoryJframe() {
        this.setTitle("История игр");
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Consts.THREE_HUNDRED, Consts.TWO_HUNDRED));
        this.setLocation(Consts.TWO_HUNDRED, Consts.TWO_HUNDRED);
        JButton back = new JButton("Вернуться в главное меню");

        panel.setLayout(new FlowLayout());
        panel.add(back);
        panelForHistory.add(historyMaker);

        this.add(panel, BorderLayout.NORTH);
        this.add(panelForHistory, BorderLayout.SOUTH);

        back.addActionListener(s -> {
            StartJframe startJframe = new StartJframe();
            startJframe.setVisible(true);
            startJframe.pack();
        });
    }
}