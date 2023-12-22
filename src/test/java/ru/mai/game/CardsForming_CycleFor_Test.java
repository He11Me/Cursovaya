package ru.mai.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.then;

public class CardsForming_CycleFor_Test {

    @Test
    @DisplayName("CycleFor test")
    public void checkAverage() {

        CardsForming cardsForming = new CardsForming();

        int[] arrOne = new int[] {2, 1};
        int[] arrTwo = new int[] {2, 2};
        int[] arrForCheck = new int[]{2, 2};
        List<int[]> Cards = List.of(arrOne, arrTwo);

        boolean flag = cardsForming.cycleFor(Cards, arrForCheck);

        then(!flag);
    }
}
