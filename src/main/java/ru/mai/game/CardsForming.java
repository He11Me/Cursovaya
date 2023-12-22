package ru.mai.game;

import ru.mai.consts.Consts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsForming {

    Random random = new Random();
    public static List<int[]> Cards = new ArrayList<int[]>();
    public static List<int[]> CardsPc = new ArrayList<int[]>();

    public int[] createRandomCard() {

        int[] arr = new int[Consts.COUNT_OF_PARAM];
        arr[0] = random.nextInt(0, Consts.COUNT_OF_CARS);
        arr[1] = random.nextInt(0, Consts.COUNT_OF_SUITS);
        return arr;
    }

    public void checkCard(List<int[]> Cards, List<int[]> CardsNew, int[] arr) {

        if (Cards.isEmpty()) {
            Cards.add(new int[]{arr[0], arr[1]});
            checkCard(Cards, CardsNew, createRandomCard());
            return;
        }

        if (CardsNew.isEmpty()) {
            CardsNew.add(new int[]{arr[0], arr[1]});
            checkCard(Cards, CardsNew, createRandomCard());
            return;
        }

        if (Cards.size() == Consts.ONE) {
            if (cycleFor(Cards, arr)) {
                if (cycleFor(CardsNew, arr)) {
                    Cards.add(new int[]{arr[0], arr[1]});
                }
            }
            checkCard(Cards, CardsNew, createRandomCard());
            return;
        }

        if (CardsNew.size() == Consts.ONE) {
            if (cycleFor(Cards, arr)) {
                if (cycleFor(CardsNew, arr)) {
                    CardsNew.add(new int[]{arr[0], arr[1]});
                }
            }
            checkCard(Cards, CardsNew, createRandomCard());
            return;
        }

        if (cycleFor(Cards, arr)) {
            if (cycleFor(CardsNew, arr)) {
                CardsNew.add(new int[]{arr[0], arr[1]});
                return;
            } else {
                checkCard(Cards, CardsNew, createRandomCard());
                return;
            }
        } else {
            checkCard(Cards, CardsNew, createRandomCard());
            return;
        }
    }

    public boolean cycleFor(List<int[]> Cards, int[] arr) {
        for (int[] card : Cards) {
            if (card[0] == arr[0] && card[1] == arr[1]) {
                return false;
            }
        }
        return true;
    }
}
















