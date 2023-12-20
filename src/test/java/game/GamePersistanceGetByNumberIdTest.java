package game;

import database.Game;
import database.GamePersistance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6BDDAssertions.then;

public class GamePersistanceGetByNumberIdTest {

    private  final GamePersistance gamePersistance = new GamePersistance();

    @Test
    @DisplayName("when game exists in DB then return null")
    public void whenGameExistsInDbThenReturnNull() {
        Game game = gamePersistance.getByNumberId("1");

        then(game).isNotNull();
        then(game.getNumberId()).isEqualTo(1);
        then(game.getWinner()).isEqualTo("Вы выиграли!");
    }

}
