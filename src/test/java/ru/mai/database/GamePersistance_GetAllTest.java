package ru.mai.database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;


public class GamePersistance_GetAllTest {

    private  final GamePersistance gamePersistance = new GamePersistance();

    @Test
    @DisplayName("GetAll test")
    public void whenGameExistsInDbThenReturnNull() {
        gamePersistance.createGame("Вы выиграли!", 1);

        List<Game> history = gamePersistance.getAll();

        for (Game game: history) {
            then(game).isNotNull();
            then(game.getNumberId()).isEqualTo(1);
            then(game.getWinner()).isEqualTo("Вы выиграли!");
        }
        gamePersistance.deleteAllGames();
    }

}
