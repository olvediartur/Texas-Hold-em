/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.CardsInGameEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author Lidia
 *
 */
public class CardsInGameDao extends AbstractDao<CardsInGameEntity> {

	String createSql = "INSERT INTO cards_in_game (cards_id, game_id, flop1, flop2, flop3, turn, river) VALUES (CARDS_IN_GAME_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	String readSql = "SELECT * FROM cards_in_game WHERE cards_id =";
	String updateSql = " UPDATE cards_in_game SET game_id = ?, flop1 = ?, flop2 = ?, flop3 = ?, turn = ?, river = ? WHERE cards_id =?";

	@Override
	String create(CardsInGameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, game.getGameId());
			ps.setObject(2, game.getFlop1());
			ps.setObject(3, game.getFlop2());
			ps.setObject(4, game.getFlop3());
			ps.setObject(5, game.getTurn());
			ps.setObject(6, game.getRiver());
			boolean res = ps.execute();
			if (res) {
				feedbackMsg = "Cards in game created";
			} else {
				feedbackMsg = "Game creating failed";
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return feedbackMsg;
	}

	@Override
	CardsInGameEntity read(int id) {
		String query = readSql + id;
		CardsInGameEntity cardsInGame = new CardsInGameEntity();
		PreparedStatement ps;
		try {
			ps = getStatement(query);
			ResultSet rs = ps.executeQuery();

			cardsInGame.setId(rs.getInt(1));
			cardsInGame.setGameId(rs.getInt(2));
			cardsInGame.setFlop1(new Card(rs.getString(3)));
			cardsInGame.setFlop2(new Card(rs.getString(4)));
			cardsInGame.setFlop3(new Card(rs.getString(5)));
			cardsInGame.setTurn(new Card(rs.getString(6)));
			cardsInGame.setRiver(new Card(rs.getString(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cardsInGame;

	}

	@Override
	String update(CardsInGameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, game.getGameId());
			ps.setObject(2, game.getFlop1());
			ps.setObject(3, game.getFlop2());
			ps.setObject(4, game.getFlop3());
			ps.setObject(5, game.getTurn());
			ps.setObject(6, game.getRiver());
			boolean res = ps.execute();
			if (res) {
				feedbackMsg = "Cards in game created";
			} else {
				feedbackMsg = "Game creating failed";
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return feedbackMsg;

	}

	@Override
	List<CardsInGameEntity> getAll() {
		List<CardsInGameEntity> result = new ArrayList<>();
		try {
			PreparedStatement ps = getStatement(updateSql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CardsInGameEntity cardsInGame = new CardsInGameEntity();
				cardsInGame.setId(rs.getInt(1));
				cardsInGame.setGameId(rs.getInt(2));
				cardsInGame.setFlop1(new Card(rs.getString(3)));
				cardsInGame.setFlop2(new Card(rs.getString(4)));
				cardsInGame.setFlop3(new Card(rs.getString(5)));
				cardsInGame.setTurn(new Card(rs.getString(6)));
				cardsInGame.setRiver(new Card(rs.getString(7)));
				result.add(cardsInGame);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
