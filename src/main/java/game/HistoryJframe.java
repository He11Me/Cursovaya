package game;

import consts.Consts;

import javax.swing.*;
import java.awt.*;

public class HistoryJframe extends JFrame {

    private JPanel panel = new JPanel();

    public HistoryJframe() {
        this.setTitle("История игр");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Consts.THREE_HUNDRED, Consts.TWO_HUNDRED));
        this.setLocation(Consts.NINE_HUNDRED, Consts.FOUR_HUNDRED);
        JButton back = new JButton("Вернуться в главное меню");

        panel.setLayout(new FlowLayout());
        panel.add(back);

        this.add(panel, BorderLayout.CENTER);

        back.addActionListener(s -> {
            StartJframe startJframe = new StartJframe();
            startJframe.setVisible(true);
            startJframe.pack();
        });
    }
}