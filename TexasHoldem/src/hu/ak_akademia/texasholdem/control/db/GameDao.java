/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.GameEntity;

/**
 * @author szebe
 *
 */
public class GameDao extends AbstractDao<GameEntity> {

	public GameDao() {
		createSql = " INSERT INTO game (game_id, date_of_game, pot) VALUES (GAME_SEQ.nextval, ?, ?) ";
		readSql = " SELECT * FROM game WHERE game_id = ";
		updateSql = " UPDATE game SET date_of_game = ?, pot = ? WHERE game_id = ? ";
	}

	@Override
	String create(GameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setDate(1, Date.valueOf(game.getDateOfGame()));
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
		String query = readSql + id;
		GameEntity gameEntity = new GameEntity();
		PreparedStatement ps;
		ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.next();
		gameEntity.setId(rs.getInt(1));
		Date xxx = rs.getDate(2);
		gameEntity.setDateOfGame(xxx.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		gameEntity.setPot(rs.getInt(3));
		return gameEntity;
	}

	@Override
	String update(GameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setDate(1, Date.valueOf(game.getDateOfGame()));
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
		List<GameEntity> result = new ArrayList<>();
		String query = " SELECT * FROM game ";
		PreparedStatement ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			GameEntity gameEntity = new GameEntity();
			gameEntity.setId(rs.getInt(1));
			Date xxx = rs.getDate(2);
			LocalDate curr = xxx.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			gameEntity.setDateOfGame(curr);
			gameEntity.setPot(rs.getInt(3));
			result.add(gameEntity);
		}
		return result;
	}

	@Override
	protected GameEntity getLast() throws SQLException {
		String query = " SELECT * FROM game WHERE game_id = (SELECT MAX(game_id) FROM game) "; 
		GameEntity gameEntity = new GameEntity();
		PreparedStatement ps;
		ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		rs.next();
		gameEntity.setId(rs.getInt(1));
		Date xxx = rs.getDate(2);
		gameEntity.setDateOfGame(LocalDate.of(xxx.getYear(), xxx.getMonth(), xxx.getDay()));
		gameEntity.setPot(rs.getInt(3));
		return gameEntity;
	}

}
