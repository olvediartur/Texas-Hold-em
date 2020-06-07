/**
 * 
 */
package hu.ak_akademia.texasholdem.model.db;

/**
 * @author KarateChopMonkey
 *
 */
public class HandEntity extends DbEntity {

	private int id;
	private int pokerUserId;
	private int gameId;
	private Card card1;
	private Card card2;
	private boolean isWon;

	/**
	 * @param id
	 * @param pokerUserId
	 * @param gameId
	 * @param card1
	 * @param card2
	 * @param isWon
	 */
	public HandEntity(int id, int pokerUserId, int gameId, Card card1, Card card2, boolean isWon) {
		super();
		this.id = id;
		this.pokerUserId = pokerUserId;
		this.gameId = gameId;
		this.card1 = card1;
		this.card2 = card2;
		this.isWon = isWon;
	}

	/**
	 * @param pokerUserId
	 * @param gameId
	 * @param card1
	 * @param card2
	 * @param isWon
	 */
	public HandEntity(int pokerUserId, int gameId, Card card1, Card card2, boolean isWon) {
		super();
		this.pokerUserId = pokerUserId;
		this.gameId = gameId;
		this.card1 = card1;
		this.card2 = card2;
		this.isWon = isWon;
	}

	/**
	 * 
	 */
	public HandEntity() {
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
	 * @return the card1
	 */
	public Card getCard1() {
		return card1;
	}

	/**
	 * @param card1 the card1 to set
	 */
	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	/**
	 * @return the card2
	 */
	public Card getCard2() {
		return card2;
	}

	/**
	 * @param card2 the card2 to set
	 */
	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	/**
	 * @return the isWon
	 */
	public boolean isWon() {
		return isWon;
	}

	/**
	 * @param isWon the isWon to set
	 */
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	@Override
	public String toString() {
		return "HandEntity [id=" + id + ", pokerUserId=" + pokerUserId + ", gameId=" + gameId + ", isWon=" + isWon
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + id;
		result = prime * result + (isWon ? 1231 : 1237);
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
		HandEntity other = (HandEntity) obj;
		if (gameId != other.gameId)
			return false;
		if (id != other.id)
			return false;
		if (isWon != other.isWon)
			return false;
		if (pokerUserId != other.pokerUserId)
			return false;
		return true;
	}

}
