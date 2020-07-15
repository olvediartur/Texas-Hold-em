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
	private String password;
	private boolean deleted;
	private int credits;
	
	public PokerUser(PokerUserEntity entity) {
		id = entity.getId();
		name = entity.getName();
		password = entity.getPassword();
		deleted = entity.isIs_deleted();
		credits = entity.getCredits();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getPassword() {
		return password;
	}

	public boolean isDeleted() {
		return deleted;
	}
	
}
