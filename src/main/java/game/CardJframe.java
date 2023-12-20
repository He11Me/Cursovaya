package game;

import game.ActionListenerForBring;
import game.ActionListenerForPass;
import game.ActionListenerForRestart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardJframe extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelForText = new JPanel();

    public CardJframe() {
        super("Карточная игра \"Очко\"");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        close.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
