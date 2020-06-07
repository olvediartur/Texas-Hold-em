/**
 * 
 */
package hu.ak_akademia.texasholdem.model.db;

/**
 * @author KarateChopMonkey
 *
 */
public class PlayerInGameEntity extends DbEntity {

	private int id;
	private int pokerUserId;
	private int gameId;
	private Card[] bestCombination;

	/**
	 * @param id
	 * @param pokerUserId
	 * @param gameId
	 * @param bestCombination
	 */
	public PlayerInGameEntity(int id, int pokerUserId, int gameId, Card[] bestCombination) {
		super();
		this.id = id;
		this.pokerUserId = pokerUserId;
		this.gameId = gameId;
		this.bestCombination = bestCombination;
	}

	/**
	 * @param pokerUserId
	 * @param gameId
	 * @param bestCombination
	 */
	public PlayerInGameEntity(int pokerUserId, int gameId, Card[] bestCombination) {
		super();
		this.pokerUserId = pokerUserId;
		this.gameId = gameId;
		this.bestCombination = bestCombination;
	}

	/**
	 * 
	 */
	public PlayerInGameEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pokerUserId
	 */
	public int getPokerUserId() {
		return pokerUserId;
	}

	/**
	 * @param pokerUserId the pokerUserId to set
	 */
	public void setPokerUserId(int pokerUserId) {
		this.pokerUserId = pokerUserId;
	}

	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the bestCombination
	 */
	public Card[] getBestCombination() {
		return bestCombination;
	}

	/**
	 * @param bestCombination the bestCombination to set
	 */
	public void setBestCombination(Card[] bestCombination) {
		this.bestCombination = bestCombination;
	}

	@Override
	public String toString() {
		return "PlayerInGameEntity [id=" + id + ", pokerUserId=" + pokerUserId + ", gameId=" + gameId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + id;
		result = prime * result + pokerUserId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerInGameEntity other = (PlayerInGameEntity) obj;
		if (gameId != other.gameId)
			return false;
		if (id != other.id)
			return false;
		if (pokerUserId != other.pokerUserId)
			return false;
		return true;
	}

}
