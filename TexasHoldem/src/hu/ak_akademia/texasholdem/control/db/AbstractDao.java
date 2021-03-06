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
	
	protected String createSql = "";
	protected String readSql = "";
	protected String updateSql = "";
	
	PreparedStatement getStatement(String query) throws SQLException {
		return Connector.getInstance().getConnection().prepareStatement(query);
	}
	
	abstract String create(E e);
	abstract E read(int id) throws SQLException;
	abstract String update(E e);
	abstract List<E> getAll() throws SQLException;

	/**
	 * @return
	 */
	protected abstract E getLast() throws SQLException ;
}
