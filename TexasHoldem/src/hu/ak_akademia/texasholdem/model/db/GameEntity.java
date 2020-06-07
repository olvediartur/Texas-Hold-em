/**
 * 
 */
package hu.ak_akademia.texasholdem.model.db;

import java.time.LocalDate;

/**
 * @author KarateChopMonkey
 *
 */
public class GameEntity extends DbEntity {

	private int id;
	private LocalDate DateOfGame;
	private int pot;

	/**
	 * @param id
	 * @param dateOfGame
	 * @param pot
	 */
	public GameEntity(int id, LocalDate dateOfGame, int pot) {
		super();
		this.id = id;
		DateOfGame = dateOfGame;
		this.pot = pot;
	}

	/**
	 * @param dateOfGame
	 * @param pot
	 */
	public GameEntity(LocalDate dateOfGame, int pot) {
		super();
		DateOfGame = dateOfGame;
		this.pot = pot;
	}

	/**
	 * 
	 */
	public GameEntity() {
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
	 * @return the dateOfGame
	 */
	public LocalDate getDateOfGame() {
		return DateOfGame;
	}

	/**
	 * @param dateOfGame the dateOfGame to set
	 */
	public void setDateOfGame(LocalDate dateOfGame) {
		DateOfGame = dateOfGame;
	}

	/**
	 * @return the pot
	 */
	public int getPot() {
		return pot;
	}

	/**
	 * @param pot the pot to set
	 */
	public void setPot(int pot) {
		this.pot = pot;
	}

	@Override
	public String toString() {
		return "GameEntity [id=" + id + ", DateOfGame=" + DateOfGame + ", pot=" + pot + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateOfGame == null) ? 0 : DateOfGame.hashCode());
		result = prime * result + id;
		result = prime * result + pot;
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
		GameEntity other = (GameEntity) obj;
		if (DateOfGame == null) {
			if (other.DateOfGame != null)
				return false;
		} else if (!DateOfGame.equals(other.DateOfGame))
			return false;
		if (id != other.id)
			return false;
		if (pot != other.pot)
			return false;
		return true;
	}

}
