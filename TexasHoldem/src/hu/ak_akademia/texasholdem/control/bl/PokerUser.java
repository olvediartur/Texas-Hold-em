/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class PokerUser {
	
	private int id;
	private String name;
	
	public PokerUser(PokerUserEntity entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
