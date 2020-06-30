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
public abstract class AbstractDao<E extends DbEntity> {
	
	public AbstractDao() {
	}
	
	String createSql = "";
	String readSql = "";
	String updateSql = "";
	
	PreparedStatement getStatement(String query) throws SQLException {
		return Connector.getInstance().getConnection().prepareStatement(query);
	}
	
	abstract String create(E e);
	abstract E read(int id);
	abstract String update(E e);
	abstract List<E> getAll();
}
