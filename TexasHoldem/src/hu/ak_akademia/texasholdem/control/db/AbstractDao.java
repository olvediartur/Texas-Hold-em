/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.DbEntity;

/**
 * @author bnagy
 *
 */
public abstract class AbstractDao<T extends DbEntity> {
	
	String createSql = "";
	String readSql = "";
	String updateSql = "";
	
	PreparedStatement getStatement(String query) throws SQLException {
		return Connector.getInstance().getConnection().prepareStatement(query);
	}
	
	abstract String create(T e);
	abstract T read(int id);
	abstract String update(T e);
	abstract List<T> getAll();
}
