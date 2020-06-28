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
	
	String createSql = " INSERT INTO poker_user (poker_user_id, name, password, credits, is_deleted) VALUES (POKER_USER_SEQ.nextval,?,?,?,?) ";
	String readSql = " SELECT * FROM poker_user WHERE poker_user_id = ";
	String updateSql = " UPDATE poker_user SET name = ?, password = ?, credits = ?, is_deleted = ? WHERE poker_user_id = ? ";
	
	
	@Override
	String create(PokerUserEntity pokerUser) {
		String feedbackMsg = "";
		try {
			PreparedStatement ps = getStatement(createSql);
			ps.setString(1, pokerUser.getName());
			ps.setString(2, pokerUser.getPassword());
			ps.setInt(3, pokerUser.getCredits());
			ps.setInt(4, pokerUser.isIs_deleted() ? 1 : 0);
			boolean res = ps.execute();
			if(res) {
				feedbackMsg = "Poker user created";
			} else {
				feedbackMsg = "User creating failed";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackMsg;
	}

	@Override
	PokerUserEntity read(int id) {
		String query = readSql + id;
		PokerUserEntity pokerUser = new PokerUserEntity();
		PreparedStatement ps;
		try {
			ps = getStatement(query);
			ResultSet rs = ps.executeQuery();
			
			pokerUser.setId(rs.getInt(1));
			pokerUser.setName(rs.getString(2));
			pokerUser.setPassword(rs.getNString(3));
			pokerUser.setCredits(rs.getInt(4));
			pokerUser.setIs_deleted(rs.getInt(5) == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			boolean res = ps.execute();
			if(res) {
				feedbackMsg = "Poker user updated";
			} else {
				feedbackMsg = "User updating failed";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackMsg;
	}

	@Override
	List<PokerUserEntity> getAll() {
		List<PokerUserEntity> result = new ArrayList<>();
		try {
			PreparedStatement ps = getStatement(updateSql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PokerUserEntity pokerUser = new PokerUserEntity();
				pokerUser.setId(rs.getInt(1));
				pokerUser.setName(rs.getString(2));
				pokerUser.setPassword(rs.getNString(3));
				pokerUser.setCredits(rs.getInt(4));
				pokerUser.setIs_deleted(rs.getInt(5) == 1);
				result.add(pokerUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
