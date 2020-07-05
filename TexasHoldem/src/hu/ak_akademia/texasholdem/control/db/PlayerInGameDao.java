/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.control.bl.BestFive;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;

/**
 * @author KarateChopMonkey
 *
 */
public class PlayerInGameDao extends AbstractDao<PlayerInGameEntity> {

	public PlayerInGameDao() {
		createSql = " INSERT INTO  player_in_game (best_combination, poker_user_id, game_id) VALUES (?, ?, ?) ";
		readSql = " SELECT * FROM player_in_game WHERE game_id AND poker_user_id = ?";
		updateSql = " UPDATE player_in_game SET best_combination = ? WHERE game_id = ? AND poker_user_id = ? ";
	}

	@Override
	String create(PlayerInGameEntity playerInGame) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, playerInGame.getPokerUserId());
			ps.setInt(2, playerInGame.getGameId());
			ps.setString(3, playerInGame.getBestCombination().toString());
			ps.execute();
			feedbackMsg = "playeringame_created";
		} catch (SQLException e) {
			feedbackMsg = "playeringame_creating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	PlayerInGameEntity read(int id) throws SQLException {
		String query = readSql + id;
		PlayerInGameEntity playerInGame = new PlayerInGameEntity();
		PreparedStatement ps;
		ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		playerInGame.setPokerUserId(rs.getInt(1));
		playerInGame.setGameId(rs.getInt(2));
		playerInGame.setBestCombination(BestFive.getBestFive(rs.getString(3)));
		return playerInGame;
	}

	@Override
	String update(PlayerInGameEntity playerInGame) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(updateSql);
			ps.setInt(1, playerInGame.getPokerUserId());
			ps.setInt(2, playerInGame.getGameId());
			ps.setString(3, playerInGame.getBestCombination().toString());
			ps.execute();
			feedbackMsg = "playeringame_updated";
		} catch (SQLException e) {
			feedbackMsg = "playeringame_updating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	List<PlayerInGameEntity> getAll() throws SQLException {
		List<PlayerInGameEntity> result = new ArrayList<>();
		PreparedStatement ps = getStatement(updateSql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			PlayerInGameEntity playerInGame = new PlayerInGameEntity();
			playerInGame.setPokerUserId(rs.getInt(1));
			playerInGame.setGameId(rs.getInt(2));
			playerInGame.setBestCombination(BestFive.getBestFive(rs.getString(3)));
			result.add(playerInGame);
		}
		return result;
	}

}
