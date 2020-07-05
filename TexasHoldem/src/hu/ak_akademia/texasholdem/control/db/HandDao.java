/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import hu.ak_akademia.texasholdem.model.db.HandEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author Iza
 *
 */
public class HandDao extends AbstractDao<HandEntity> {

	HandDao() {
		super();
		createSql = "INSERT INTO hand (hand_id, poker_user_id, game_id, card1, card2, is_won ) VALUES (HAND_SEQ.nextval,?,?,?,?,?)";
		readSql = "SELECT * FROM hand WHERE hand_id = ";
		updateSql = " UPDATE hand SET poker_user_id = ?, game_id = ?, card1 = ?, card2 = ?, is_won = ? WHERE hand_id = ? ";
	}

	
	String create(HandEntity hand) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, hand.getPokerUserId());
			ps.setInt(2, hand.getGameId());
			ps.setNString(3, hand.getCard1().toString());
			ps.setNString(4, hand.getCard2().toString());
			ps.setInt(5, hand.isWon() ? 1 : 0);
			ps.execute();
			feedbackMsg = "hand_created";
		} catch (SQLException e) {
			feedbackMsg = "hand_creating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	HandEntity read(int id) throws SQLException {
		String query = readSql + id;
		HandEntity hand = new HandEntity();
		PreparedStatement ps;
		ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		hand.setPokerUserId(rs.getInt(1));
		hand.setGameId(rs.getInt(2));
		hand.setCard1(new Card(rs.getString(3)));
		hand.setCard2(new Card(rs.getString(4)));
		hand.setWon(rs.getInt(5) == 1);
		return hand;
	}

	@Override
	String update(HandEntity hand) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(updateSql);
			ps.setInt(1, hand.getPokerUserId());
			ps.setInt(2, hand.getGameId());
			ps.setObject(3, hand.getCard1());
			ps.setObject(4, hand.getCard2());
			ps.setInt(5, hand.isWon() ? 1 : 0);
			ps.execute();
			feedbackMsg = "hand_updated";
		} catch (SQLException e) {
				feedbackMsg = "hand_updating_failed";
				System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	List<HandEntity> getAll() throws SQLException {
		List<HandEntity> result = new ArrayList<>();
		String query = " SELECT * FROM hand ";
		PreparedStatement ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			HandEntity hand = new HandEntity();
			hand.setPokerUserId(rs.getInt(1));
			hand.setGameId(rs.getInt(2));
			hand.setCard1(new Card(rs.getString(3)));
			hand.setCard2(new Card(rs.getString(4)));
			hand.setWon(rs.getInt(5) == 1);
			result.add(hand);
		}
		return result;
	}

}
