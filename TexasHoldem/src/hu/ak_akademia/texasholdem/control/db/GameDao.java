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
			boolean res = ps.execute();
			if (res) {
				feedbackMsg = "Game created";
			} else {
				feedbackMsg = "Game creating failed";
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return feedbackMsg;
	}

	@Override
	GameEntity read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String update(GameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setDate(1, new Date(game.getDateOfGame().toEpochDay()));
			ps.setInt(2, game.getPot());
			boolean res = ps.execute();
			if (res) {
				feedbackMsg = "Game updated";
			} else {
				feedbackMsg = "Game updating failed";
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return feedbackMsg;
	}

	@Override
	List<GameEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
