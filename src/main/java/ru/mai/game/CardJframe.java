package ru.mai.game;

import ru.mai.consts.Consts;
import ru.mai.database.GamePersistance;

import javax.swing.*;
import java.awt.*;

public class CardJframe extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelForText = new JPanel();
    GamePersistance gamePersistance = new GamePersistance();

    public CardJframe() {
        super("Карточная игра \"Очко\"");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(Consts.THOUSAND, Consts.SEVEN_HUNDRED));
        this.setLocation(Consts.FIVE_HUNDRED, Consts.TWO_HUNDRED);

        CardsProcessing cardsProcessing = new CardsProcessing();
        panelForText.setBackground(Color.GRAY);
        panel.setBackground(Color.GRAY);
        JButton bring = new JButton("Взять карту");
        JButton pass = new JButton("Пасс");
        JButton restart = new JButton("Начать заново");
        JButton close = new JButton("Закрыть игру");

        panel.setLayout(new FlowLayout());
        panel.add(bring);
        panel.add(pass);
        panel.add(restart);
        panel.add(close);
        panelForText.add(cardsProcessing);

        this.add(panel, BorderLayout.SOUTH);
        this.add(panelForText, BorderLayout.NORTH);

        bring.addActionListener(new ActionListenerForBring(cardsProcessing));
        pass.addActionListener(new ActionListenerForPass(cardsProcessing));
        restart.addActionListener(new ActionListenerForRestart(cardsProcessing));

        close.addActionListener(e -> {
            gamePersistance.deleteAllGames();
            System.exit(0);
        });
    }
}
