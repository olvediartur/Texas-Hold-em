/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import java.time.LocalDate;

import hu.ak_akademia.texasholdem.model.db.GameEntity;

/**
 * @author bnagy
 *
 */
public class Game {
	
	private int id;
	private LocalDate dateOfGame;
	private int pot;
	
	public Game(GameEntity entity) {
		id = entity.getId();
		dateOfGame = entity.getDateOfGame();
		pot = entity.getPot();
	}

	public int getId() {
		return id;
	}

	public LocalDate getDateOfGame() {
		return dateOfGame;
	}

	public int getPot() {
		return pot;
	}
	
}
