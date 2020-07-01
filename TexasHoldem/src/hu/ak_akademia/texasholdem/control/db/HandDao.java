/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.HandEntity;

/**
 * @author
 *
 */
public class HandDao extends AbstractDao<HandEntity> {

	@Override
	String create(HandEntity e) {
		// TODO create hand entity
		return null;
	}

	@Override
	HandEntity read(int id) throws SQLException {
		// TODO get hand entity
		return null;
	}

	@Override
	String update(HandEntity e) {
		// TODO update hand entity
		return null;
	}

	@Override
	List<HandEntity> getAll() throws SQLException {
		// TODO get all hand entity
		return null;
	}

}
