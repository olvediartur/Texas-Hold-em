/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.GameEntity;

/**
 * @author szebe
 *
 */
public class GameDao extends AbstractDao<GameEntity> {

	String createSql = "INSERT INTO game (game_id, date_of_game, pot) VALUES (GAME_SEQ.nextval, ?, ?)";
	String readSql = " SELECT * FROM game WHERE game_id = ";
	String updateSql = " UPDATE game SET date_of_game = ?, pot = ? WHERE game_id = ? ";

	@Override
	String create(GameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setDate(1, new Date(game.getDateOfGame().toEpochDay()));
			ps.setInt(2, game.getPot());
			ps.execute();
			feedbackMsg = "Game created";
		} catch (SQLException e) {
			feedbackMsg = "Game creating failed";
			System.err.println("Cause: " + e.getMessage());

		}

		return feedbackMsg;
	}

	@Override
	GameEntity read(int id) throws SQLException {
		// TODO getGameEntity by id
		return null;
	}

	@Override
	String update(GameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setDate(1, new Date(game.getDateOfGame().toEpochDay()));
			ps.setInt(2, game.getPot());
			ps.execute();
			feedbackMsg = "game_updated";
		} catch (SQLException e) {
			feedbackMsg = "game_updating_failed";
			System.err.println("Cause: " + e.getMessage());
		}

		return feedbackMsg;
	}

	@Override
	List<GameEntity> getAll() throws SQLException {
		// TODO getAll GameEntity
		return null;
	}

}
