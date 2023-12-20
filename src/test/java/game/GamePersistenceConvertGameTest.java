package game;

import database.Game;
import database.GamePersistance;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.mockito.BDDMockito.then;

public class GamePersistenceConvertGameTest {

    private static final GamePersistance gamePersistence = new GamePersistance();
    @Test
    public void checkCreation() {
        Map<String, String> input = Map.of(
                "numberId", "1",
                "gameWinner", "Вы выиграли"
        );

        Game game = gamePersistence.convertGame(input);

        then(game.getNumberId()).equals(1);
        then(game.getWinner()).equals("Вы выиграли");
    }
}
