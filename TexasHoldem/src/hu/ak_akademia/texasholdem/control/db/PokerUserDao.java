package hu.ak_akademia.texasholdem.control.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class PokerUserDao extends AbstractDao<PokerUserEntity> {

	public PokerUserDao() {
		createSql = " INSERT INTO poker_user (poker_user_id, name, password, credits, is_deleted) VALUES (POKER_USER_SEQ.nextval,?,?,?,?) ";
		readSql = " SELECT * FROM poker_user WHERE poker_user_id = ";
		updateSql = " UPDATE poker_user SET name = ?, password = ?, credits = ?, is_deleted = ? WHERE poker_user_id = ? ";
	}

	@Override
	String create(PokerUserEntity pokerUser) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setString(1, pokerUser.getName());
			ps.setString(2, pokerUser.getPassword());
			ps.setInt(3, pokerUser.getCredits());
			ps.setInt(4, pokerUser.isIs_deleted() ? 1 : 0);
			ps.execute();
			feedbackMsg = "poker_user_created";
		} catch (SQLException e) {
			feedbackMsg = "user_creating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	PokerUserEntity read(int id) throws SQLException {
		String query = readSql + id;
		PokerUserEntity pokerUser = new PokerUserEntity();
		PreparedStatement ps;
		ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		pokerUser.setId(rs.getInt(1));
		pokerUser.setName(rs.getString(2));
		pokerUser.setPassword(rs.getNString(3));
		pokerUser.setCredits(rs.getInt(4));
		pokerUser.setIs_deleted(rs.getInt(5) == 1);
		return pokerUser;
	}

	@Override
	String update(PokerUserEntity pokerUser) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(updateSql);
			ps.setString(1, pokerUser.getName());
			ps.setString(2, pokerUser.getPassword());
			ps.setInt(3, pokerUser.getCredits());
			ps.setInt(4, pokerUser.isIs_deleted() ? 1 : 0);
			ps.setInt(5, pokerUser.getId());
			ps.execute();
			feedbackMsg = "poker_user_updated";
		} catch (SQLException e) {
			feedbackMsg = "user_updating_failed";
			System.err.println("Cause:" + e.getMessage());
		}
		return feedbackMsg;
	}

	@Override
	List<PokerUserEntity> getAll() throws SQLException {
		List<PokerUserEntity> result = new ArrayList<>();
		String query = " SELECT * FROM poker_user ";
		PreparedStatement ps = getStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			PokerUserEntity pokerUser = new PokerUserEntity();
			pokerUser.setId(rs.getInt(1));
			pokerUser.setName(rs.getString(2));
			pokerUser.setPassword(rs.getNString(3));
			pokerUser.setCredits(rs.getInt(4));
			pokerUser.setIs_deleted(rs.getInt(5) == 1);
			result.add(pokerUser);
		}
		return result;
	}

}
