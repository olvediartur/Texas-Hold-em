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
	private boolean wasBet = false;

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
	 * 
	 */
	public Bid() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Akkor van vége egy licitkörnek amikor az utolsó hand-ben lévő játékos
	 * után az emelő következne ÉS az utolsó játékos nem emel vissza(vagyis csak
	 * megad vagy dob).
	 * Vagy akkor, ha csak egy játékos marad.
	 * @param raisingPlayer
	 * @param actualPlayer
	 * @return boolean
	 */
	public boolean isEndOfBid(Player raisingPlayer, Player actualPlayer) {
		if (playersInHand.getNext(actualPlayer) == raisingPlayer
				&& actualPlayer.getLastAction() != InGameAction.RAISE) {
			return true;
		}
		int numOfActivePlayers = 0;
		for(Player p : playersInHand) {
			if(p.isInHand()) {
				numOfActivePlayers++;
			}
		}
		if(numOfActivePlayers == 1) {
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

	public boolean wasBet() {
		return wasBet;
	}

	public void setWasBet(boolean wasBet) {
		this.wasBet = wasBet;
	}

}
