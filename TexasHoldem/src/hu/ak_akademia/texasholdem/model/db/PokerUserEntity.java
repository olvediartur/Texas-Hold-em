/**
 * 
 */
package hu.ak_akademia.texasholdem.model.db;

/**
 * @author KarateChopMonkey
 *
 */
public class PokerUserEntity extends DbEntity{
	
	private int id;
	private String name;
	private String password;
	private int credits;
	private boolean is_deleted;
	
	public PokerUserEntity(int id, String name, String password, int credits, boolean is_deleted) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.credits = credits;
		this.is_deleted = is_deleted;
	}
	/**
	 * @param id
	 * @param name
	 * @param credits
	 * @param is_deleted
	 */
	public PokerUserEntity(int id, String name, int credits, boolean is_deleted) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.is_deleted = is_deleted;
	}
	/**
	 * @param name
	 * @param credits
	 * @param is_deleted
	 */
	public PokerUserEntity(String name, int credits, boolean is_deleted) {
		super();
		this.name = name;
		this.credits = credits;
		this.is_deleted = is_deleted;
	}
	/**
	 * 
	 */
	public PokerUserEntity() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + id;
		result = prime * result + (is_deleted ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PokerUserEntity other = (PokerUserEntity) obj;
		if (credits != other.credits) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (is_deleted != other.is_deleted) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "PokerUserEntity [id=" + id + ", name=" + name + ", credits=" + credits + ", is_deleted=" + is_deleted
				+ "]";
	}

}
