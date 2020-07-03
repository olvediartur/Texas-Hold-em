/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class Player {
	
	final int id;
	final String name;
	int credits;
	
	final boolean owner;
	boolean dealer;
	int creditsInGame;
	Player nextPlayer;
	Player prevPlayer;
	
	public Player(PokerUserEntity entity, boolean isOwner) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.credits = entity.getCredits();
		this.owner = isOwner;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public boolean isDealer() {
		return dealer;
	}

	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}

	public int getCreditsInGame() {
		return creditsInGame;
	}

	public void setCreditsInGame(int creditsInGame) {
		this.creditsInGame = creditsInGame;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	public Player getPrevPlayer() {
		return prevPlayer;
	}

	public void setPrevPlayer(Player prevPlayer) {
		this.prevPlayer = prevPlayer;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isOwner() {
		return owner;
	}
		
}
