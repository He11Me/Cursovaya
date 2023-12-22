package ru.mai.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.then;

public class CardProcessing_CalculateCards_Test {

    @Test
    @DisplayName("CalculateCards test")
    public void checkAverage() {

        CardsProcessing cardsProcessing = new CardsProcessing();

        int[] arrOne = new int[] {0, 0};
        int[] arrTwo = new int[] {8, 3};
        List<int[]> Cards = List.of(arrOne, arrTwo);

        String str = cardsProcessing.calculateCards(Cards);

        then(str.equals("6 пики Т бубны "));
    }
}
