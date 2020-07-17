/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.CircularLinkedList;

/**
 * @author bnagy
 *
 */
public class Bid {
	
	private Player currentPlayer;
	private Player lastRaiser;
	private CircularLinkedList<Player> playersInHand = new CircularLinkedList<>();
	private Round round;

	/**
	 * @param players
	 * @param round
	 */
	public Bid(CircularLinkedList<Player> players, Round round) {
		this.round = round;
		for (Player p : players) {
			if (p.isInHand()) {
				playersInHand.add(p);
			}
		}
	}

	/**
	 * Akkor van vége egy licitkörnek amikor az utolsó hand-ben lévő játékos
	 * után az emelő következne ÉS az utolsó játékos nem emel vissza(vagyis csak
	 * megad vagy dob).
	 * @param raisingPlayer
	 * @param actualPlayer
	 * @return boolean
	 */
	public boolean isEndOfBid(Player raisingPlayer, Player actualPlayer) {
		if (playersInHand.getNext(actualPlayer) == raisingPlayer
				&& actualPlayer.getLastAction() != InGameAction.RAISE) {
			return true;
		}
		return false;
	}

	public Player getDealer() {
		for (Player p : playersInHand) {
			if (p.isDealer()) {
				return p;
			}
		}
		return null;// Ilyen nem lehet.
	}

	public Player getSmallBlind() {
		return playersInHand.getNext(getDealer());
	}

	public Player getBigBlind() {
		return playersInHand.getNext(getSmallBlind());
	}

	public Round getRound() {
		return round;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getLastRaiser() {
		return lastRaiser;
	}

	public void setLastRaiser(Player lastRaiser) {
		this.lastRaiser = lastRaiser;
	}

	public CircularLinkedList<Player> getPlayersInHand() {
		return playersInHand;
	}

}
