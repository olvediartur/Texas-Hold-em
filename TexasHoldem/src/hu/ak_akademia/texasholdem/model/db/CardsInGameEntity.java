/**
 * 
 */
package hu.ak_akademia.texasholdem.model.db;

/**
 * @author KarateChopMonkey
 *
 */
public class CardsInGameEntity extends DbEntity {

	private int id;
	private int gameId;
	private Card flop1;
	private Card flop2;
	private Card flop3;
	private Card tum;
	private Card river;

	/**
	 * @param id
	 * @param gameId
	 * @param flop1
	 * @param flop2
	 * @param flop3
	 * @param tum
	 * @param river
	 */
	public CardsInGameEntity(int id, int gameId, Card flop1, Card flop2, Card flop3, Card tum, Card river) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.flop1 = flop1;
		this.flop2 = flop2;
		this.flop3 = flop3;
		this.tum = tum;
		this.river = river;
	}

	/**
	 * @param gameId
	 * @param flop1
	 * @param flop2
	 * @param flop3
	 * @param tum
	 * @param river
	 */
	public CardsInGameEntity(int gameId, Card flop1, Card flop2, Card flop3, Card tum, Card river) {
		super();
		this.gameId = gameId;
		this.flop1 = flop1;
		this.flop2 = flop2;
		this.flop3 = flop3;
		this.tum = tum;
		this.river = river;
	}

	/**
	 * 
	 */
	public CardsInGameEntity() {
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
	 * @return the flop1
	 */
	public Card getFlop1() {
		return flop1;
	}

	/**
	 * @param flop1 the flop1 to set
	 */
	public void setFlop1(Card flop1) {
		this.flop1 = flop1;
	}

	/**
	 * @return the flop2
	 */
	public Card getFlop2() {
		return flop2;
	}

	/**
	 * @param flop2 the flop2 to set
	 */
	public void setFlop2(Card flop2) {
		this.flop2 = flop2;
	}

	/**
	 * @return the flop3
	 */
	public Card getFlop3() {
		return flop3;
	}

	/**
	 * @param flop3 the flop3 to set
	 */
	public void setFlop3(Card flop3) {
		this.flop3 = flop3;
	}

	/**
	 * @return the tum
	 */
	public Card getTum() {
		return tum;
	}

	/**
	 * @param tum the tum to set
	 */
	public void setTum(Card tum) {
		this.tum = tum;
	}

	/**
	 * @return the river
	 */
	public Card getRiver() {
		return river;
	}

	/**
	 * @param river the river to set
	 */
	public void setRiver(Card river) {
		this.river = river;
	}

	@Override
	public String toString() {
		return "CardsInGameEntity [id=" + id + ", gameId=" + gameId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + id;
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
		CardsInGameEntity other = (CardsInGameEntity) obj;
		if (gameId != other.gameId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
