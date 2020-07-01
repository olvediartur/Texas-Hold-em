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

	public CardsInGameDao() {
		createSql = " INSERT INTO cards_in_game (cards_id, game_id, flop1, flop2, flop3, turn, river) VALUES (CARDS_IN_GAME_SEQ.nextval, ?, ?, ?, ?, ?, ?) ";
		readSql = " SELECT * FROM cards_in_game WHERE cards_id = ";
		updateSql = " UPDATE cards_in_game SET game_id = ?, flop1 = ?, flop2 = ?, flop3 = ?, turn = ?, river = ? WHERE cards_id =? ";
	}

	@Override
	String create(CardsInGameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, game.getGameId());
			ps.setNString(2, game.getFlop1().toString());
			ps.setNString(3, game.getFlop2().toString());
			ps.setNString(4, game.getFlop3().toString());
			ps.setNString(5, game.getTurn().toString());
			ps.setNString(6, game.getRiver().toString());
			ps.execute();
			feedbackMsg = "cardsingame_created";
		} catch (SQLException e) {
			feedbackMsg = "cardsingame_creating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	CardsInGameEntity read(int id) throws SQLException {
		String query = readSql + id;
		CardsInGameEntity cardsInGame = new CardsInGameEntity();
		PreparedStatement ps;
		ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		cardsInGame.setId(rs.getInt(1));
		cardsInGame.setGameId(rs.getInt(2));
		cardsInGame.setFlop1(new Card(rs.getString(3)));
		cardsInGame.setFlop2(new Card(rs.getString(4)));
		cardsInGame.setFlop3(new Card(rs.getString(5)));
		cardsInGame.setTurn(new Card(rs.getString(6)));
		cardsInGame.setRiver(new Card(rs.getString(7)));
		return cardsInGame;

	}

	@Override
	String update(CardsInGameEntity game) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setInt(1, game.getGameId());
			ps.setNString(2, game.getFlop1().toString());
			ps.setNString(3, game.getFlop2().toString());
			ps.setNString(4, game.getFlop3().toString());
			ps.setNString(5, game.getTurn().toString());
			ps.setNString(6, game.getRiver().toString());
			ps.execute();
			feedbackMsg = "cardsingame_updated";
		} catch (SQLException e) {
			feedbackMsg = "cardsingame_updating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;

	}

	@Override
	List<CardsInGameEntity> getAll() throws SQLException {
		List<CardsInGameEntity> result = new ArrayList<>();
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
		return result;
	}

}
