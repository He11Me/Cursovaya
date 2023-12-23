package ru.mai.game;

import ru.mai.consts.Consts;
import ru.mai.database.GamePersistance;

import javax.swing.*;
import java.util.List;

public class CardsProcessing extends JLabel {

    CardsForming cardsForming = new CardsForming();
    GamePersistance gamePersistance = new GamePersistance();
    private static int score;
    private static int scorePc;
    private int countOfGames = 1;
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

    public void startCards(){
        cardsForming.setStartCards(CardsForming.CardsPc, CardsForming.Cards,
                cardsForming.createRandomCard());
        scoreCalc(CardsForming.Cards);
    }

    public void restartGame() {

        CardsForming.CardsPc.clear();
        CardsForming.Cards.clear();
        scoreCalcPc(CardsForming.CardsPc);
        scoreCalc(CardsForming.Cards);
        startCards();
        view();
    }

    public void getWinner() {
        if ((score > scorePc && score <= Consts.COUNT_FOR_WIN) ||
                (scorePc > Consts.COUNT_FOR_WIN && score <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + " Очки противника: " + scorePc + " Вы победили!" +
                    "\n Ваши карты: " + textCards + "Карты противника: " + textCardsPc);
            gamePersistance.createGame("Вы победили!", countOfGames);
            countOfGames++;
        } else if ((scorePc > score && scorePc <= Consts.COUNT_FOR_WIN) ||
                (score > Consts.COUNT_FOR_WIN && scorePc <= Consts.COUNT_FOR_WIN)) {
            setText("Ваши очки: " + score + " Очки противника: " + scorePc + " Вы проиграли!" +
                    "\n Ваши карты: " + textCards + "Карты противника: " + textCardsPc);
            gamePersistance.createGame("Вы проиграли!", countOfGames);
            countOfGames++;
        } else {
            setText("Ваши очки: " + score + " Очки противника: " + scorePc + " Ничья!" +
                    "\n Ваши карты: " + textCards + "Карты противника: " + textCardsPc);
            gamePersistance.createGame("Ничья!", countOfGames);
            countOfGames++;
        }
    }

    public String calculateCards(List<int[]> Cards) {
        
        String str = "";
        StringBuilder strBuilder = new StringBuilder(str);

        for (int[] card : Cards) {
            switch (card[0]) {
                case Consts.ZERO -> {
                    strBuilder.append("6 ");
                    switchCards(strBuilder, card);
                }
                case Consts.ONE -> {
                    strBuilder.append("7 ");
                    switchCards(strBuilder, card);
                }
                case Consts.TWO -> {
                    strBuilder.append("8 ");
                    switchCards(strBuilder, card);
                }
                case Consts.THREE -> {
                    strBuilder.append("9 ");
                    switchCards(strBuilder, card);
                }
                case Consts.FOUR -> {
                    strBuilder.append("10 ");
                    switchCards(strBuilder, card);
                }
                case Consts.FIVE -> {
                    strBuilder.append("В ");
                    switchCards(strBuilder, card);
                }
                case Consts.SIX -> {
                    strBuilder.append("Д ");
                    switchCards(strBuilder, card);
                }
                case Consts.SEVEN -> {
                    strBuilder.append("К ");
                    switchCards(strBuilder, card);
                }
                case Consts.EIGHT -> {
                    strBuilder.append("Т ");
                    switchCards(strBuilder, card);
                }
            }
        }
        str = strBuilder.toString();
        return str;
    }

    private void switchCards(StringBuilder strBuilder, int[] card) {
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

    public void view() {
        textCards = calculateCards(CardsForming.Cards);
        textCardsPc = calculateCards(CardsForming.CardsPc);
        setText("Ваши очки: " + score + "\n Ваши карты: " + textCards);
    }
}
