/**
 * 
 */
package hu.ak_akademia.texasholdem.model.db;

import java.util.Arrays;

import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author KarateChopMonkey
 *
 */
public class PlayerInGameEntity extends DbEntity {

	private int pokerUserId;
	private int gameId;
	private Card[] bestCombination;

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
	 * @param bestCombination
	 */
	public PlayerInGameEntity(Card[] bestCombination) {
		super();
		this.bestCombination = bestCombination;
	}

	/**
	 * 
	 */
	public PlayerInGameEntity() {
		super();
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
		return "PlayerInGameEntity [pokerUserId=" + pokerUserId + ", gameId=" + gameId + ", bestCombination="
				+ Arrays.toString(bestCombination) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bestCombination);
		result = prime * result + gameId;
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
		if (!Arrays.equals(bestCombination, other.bestCombination))
			return false;
		if (gameId != other.gameId)
			return false;
		if (pokerUserId != other.pokerUserId)
			return false;
		return true;
	}

}
