package ru.mai.database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mai.database.Game;
import ru.mai.database.GamePersistance;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

public class GamePersistence_ConvertGameTest {

    private static final GamePersistance gamePersistance = new GamePersistance();
    @Test
    @DisplayName("Convert test")
    public void checkCreation() {
        Map<String, String> input = Map.of(
                "numberId", "1",
                "gameWinner", "Вы выиграли"
        );

        Game game = gamePersistance.convertGame(input);

        then(game.getNumberId()).isEqualTo(1);
        then(game.getWinner()).isEqualTo("Вы выиграли");
        gamePersistance.deleteAllGames();
    }
}
