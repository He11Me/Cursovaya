package game;

import game.CardsForming;

import javax.swing.*;
import java.util.List;

public class CardsProcessing extends JLabel {

    CardsForming cardsForming = new CardsForming();
    private static int score;
    private static int scorePc;
    private String textCards;
    private String textCardsPc;

    public CardsProcessing() {
        view();
    }

    public void scoreCalc(List<int[]> Cards) {

        score = 0;

        for (int[] card : Cards) {
            switch (card[0]) {
                case Consts.ZERO -> score += Consts.SIX;
                case Consts.ONE -> score += Consts.SEVEN;
                case Consts.TWO -> score += Consts.EIGHT;
                case Consts.THREE -> score += Consts.NINE;
                case Consts.FOUR -> score += Consts.TEN;
                case Consts.FIVE -> score += Consts.TWO;
                case Consts.SIX -> score += Consts.THREE;
                case Consts.SEVEN -> score += Consts.FOUR;
                case Consts.EIGHT -> score += Consts.ELEVEN;
            }
        }
    }

    public void scoreCalcPc(List<int[]> Cards) {

        scorePc = 0;

        for (int[] card : Cards) {
            switch (card[0]) {
                case Consts.ZERO -> scorePc += Consts.SIX;
                case Consts.ONE -> scorePc += Consts.SEVEN;
                case Consts.TWO -> scorePc += Consts.EIGHT;
                case Consts.THREE -> scorePc += Consts.NINE;
                case Consts.FOUR -> scorePc += Consts.TEN;
                case Consts.FIVE -> scorePc += Consts.TWO;
                case Consts.SIX -> scorePc += Consts.THREE;
                case Consts.SEVEN -> scorePc += Consts.FOUR;
                case Consts.EIGHT -> scorePc += Consts.ELEVEN;
            }
        }
    }

    public void cardsChecking() {
        cardsOfPlayer();
        cardsOfPc();
        view();
        if (score >= Consts.COUNT_FOR_WIN || scorePc >= Consts.COUNT_FOR_WIN) {
            getWinner();
        }
    }

    public void cardsOfPlayer() {
        cardsForming.checkCard(CardsForming.CardsPc, CardsForming.Cards,
                cardsForming.createRandomCard());
        scoreCalc(CardsForming.Cards);
    }

    public void cardsOfPc() {
        if (scorePc <= Consts.SIXTEEN) {
            cardsForming.checkCard(CardsForming.Cards, CardsForming.CardsPc,
                    cardsForming.createRandomCard());
            scoreCalcPc(CardsForming.CardsPc);
        }
    }

    public void scoreOfPlayers() {
        while (true) {
            if (scorePc <= Consts.SIXTEEN) {
                cardsOfPc();
            } else {
                break;
            }
        }
        view();
    }

    public void restartGame() {

        CardsForming.CardsPc.clear();
        CardsForming.Cards.clear();
        scoreCalcPc(CardsForming.CardsPc);
        scoreCalc(CardsForming.Cards);
        view();
    }

    public void getWinner() {
        if ((score > scorePc && score <= Consts.COUNT_FOR_WIN) ||
                (scorePc > Consts.COUNT_FOR_WIN && score <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + " Очки противника: " + scorePc + " Вы победили!" +
                    "\n Ваши карты: " + textCards + "Карты противника: " + textCardsPc);
        } else if ((scorePc > score && scorePc <= Consts.COUNT_FOR_WIN) ||
                (score > Consts.COUNT_FOR_WIN && scorePc <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + " Очки противника: " + scorePc + " Вы проиграли!" +
                    "\n Ваши карты: " + textCards + "Карты противника: " + textCardsPc);
        } else {
            setText("Ваши очки: " + score + " Очки противника: " + scorePc + " Ничья!" +
                    "\n Ваши карты: " + textCards + "Карты противника: " + textCardsPc);
        }
    }

    public String calculateCards(List<int[]> Cards) {
        
        String str = "";
        StringBuilder strBuilder = new StringBuilder(str);

        for (int[] card : Cards) {
            switch (card[0]) {
                case Consts.ZERO -> {
                    strBuilder.append("6 ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.ONE -> {
                    strBuilder.append("7 ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.TWO -> {
                    strBuilder.append("8 ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.THREE -> {
                    strBuilder.append("9 ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.FOUR -> {
                    strBuilder.append("10 ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.FIVE -> {
                    strBuilder.append("В ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.SIX -> {
                    strBuilder.append("Д ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.SEVEN -> {
                    strBuilder.append("К ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубна ");
                        }
                    }
                }
                case Consts.EIGHT -> {
                    strBuilder.append("Т ");
                    switch (card[Consts.ONE]) {
                        case Consts.ZERO -> {
                            strBuilder.append("пики ");
                        }
                        case Consts.ONE -> {
                            strBuilder.append("крести ");
                        }
                        case Consts.TWO -> {
                            strBuilder.append("черви ");
                        }
                        case Consts.THREE -> {
                            strBuilder.append("бубны ");
                        }
                    }
                }
            }
        }
        str = strBuilder.toString();
        return str;
    }

    public void view() {
        textCards = calculateCards(CardsForming.Cards);
        textCardsPc = calculateCards(CardsForming.CardsPc);
        setText("Ваши очки: " + score + "\n Ваши карты: " + textCards);
    }
}
