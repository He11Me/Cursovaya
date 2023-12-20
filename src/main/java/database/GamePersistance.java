package database;

import java.util.List;
import java.util.Map;

public class GamePersistance {

    private final DataBase db = DataBase.getInstance();

    private static final String TABLE_NAME = "ochko";
    private static final String ID_NUMBER = "numberId";
    private static final String GAME_WINNER = "gameWinner";

    public void createGame(String gameWinner, int numberId) {
        String sql = """
        insert into cursach.games
        (numberId, gameWinner)
        values
        ('%s', %d)
        """;
        db.execute(String.format(sql, gameWinner, numberId));
    }

    public void deleteAllGames() {
        String sql = """
                delete from cursach.games
                """;
        db.execute(String.format(sql));
    }

    public void updateTable() {
        String sql = """
                update cursach.games
                set numberId = numberId
                """;

        db.execute(String.format(sql));
    }

    public Game getByNumberId(String nameId) {
        Map<String, String> fromBd = db.selectByNumberId(
                nameId,
                TABLE_NAME,
                ID_NUMBER,
                GAME_WINNER
        );
        if (fromBd == null && fromBd.isEmpty()) {
            return null;
        }
        return convertGame(fromBd);
    }

    public List<Game> getAll() {
        List<Map<String, String>> fromDB = db.selectAll(
                TABLE_NAME,
                ID_NUMBER,
                GAME_WINNER
        );

        return fromDB.stream()
                .map(this::convertGame)
                .toList();
    }

    protected Game convertGame(Map<String, String> fromBd) {
        return new Game(
                fromBd.get(GAME_WINNER),
                Integer.parseInt(fromBd.get(ID_NUMBER))
        );
    }
}
