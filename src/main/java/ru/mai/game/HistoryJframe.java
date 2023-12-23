package ru.mai.game;

import ru.mai.consts.Consts;
import ru.mai.database.Game;
import ru.mai.database.GamePersistance;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryJframe extends JFrame {

    GamePersistance gamePersistance = new GamePersistance();

    private JPanel panel = new JPanel();
    private JPanel panelForHistory = new JPanel();
    private String string;
    private List<Game> history = new ArrayList<>();

    public HistoryJframe() {
        this.setTitle("История игр");
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Consts.FIVE_HUNDRED, Consts.FOUR_HUNDRED));
        this.setLocation(Consts.TWO_HUNDRED, Consts.TWO_HUNDRED);

        DefaultListModel dlm = new DefaultListModel();
        JList historyList = new JList(dlm);
        JScrollPane paneHistory = new JScrollPane(historyList);
        paneHistory.setPreferredSize(new Dimension(Consts.TWO_HUNDRED, Consts.TWO_HUNDRED));
        historyList.setLayoutOrientation(JList.VERTICAL);
        JButton back = new JButton("Вернуться в главное меню");

        history = gamePersistance.getAll();
        for (Game game: history) {
            string = Integer.toString(game.getNumberId());
            string += ("-я игра -- " + game.getWinner());
            dlm.addElement(string);
            string = "";
        }

        panel.setLayout(new FlowLayout());
        panel.add(back);
        panelForHistory.add(paneHistory);

        this.add(panel, BorderLayout.NORTH);
        this.add(panelForHistory, BorderLayout.CENTER);

        back.addActionListener(s -> {
            StartJframe startJframe = new StartJframe();
            startJframe.setVisible(true);
            startJframe.pack();
        });
    }
}