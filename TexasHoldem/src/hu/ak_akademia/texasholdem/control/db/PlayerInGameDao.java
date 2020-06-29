/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.texasholdem.control.bl.BestFive;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;

/**
 * @author KarateChopMonkey
 *
 */
public class PlayerInGameDao extends AbstractDao<PlayerInGameEntity> {

	String createSql = "INSERT INTO  player_in_game (best_combination, poker_user_id, game_id) VALUES (?, ?, ?)";
	String readSql = "SELECT * FROM player_in_game WHERE game_id AND poker_user_id = ?";
	String updateSql = "UPDATE player_in_game SET best_combination = ? WHERE game_id = ? AND poker_user_id = ?";

	@Override
	String create(PlayerInGameEntity playerInGame) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, playerInGame.getPokerUserId());
			ps.setInt(2, playerInGame.getGameId());
			ps.setString(3, playerInGame.getBestCombination().toString());
			boolean res = ps.execute();
			if (res) {
				feedbackMsg = "Player in game created";
			} else {
				feedbackMsg = "Player in game creation failed";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	PlayerInGameEntity read(int id) {
		String query = readSql + id;
		PlayerInGameEntity playerInGame = new PlayerInGameEntity();
		PreparedStatement ps;
		try {
			ps = getStatement(query);
			ResultSet rs = ps.executeQuery();
			playerInGame.setPokerUserId(rs.getInt(1));
			playerInGame.setGameId(rs.getInt(2));
			playerInGame.setBestCombination(BestFive.getBestFive(rs.getString(3)));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			boolean res = ps.execute();
			if (res) {
				feedbackMsg = "Player in game updated";
			} else {
				feedbackMsg = "Player in game update failed";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	List<PlayerInGameEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
