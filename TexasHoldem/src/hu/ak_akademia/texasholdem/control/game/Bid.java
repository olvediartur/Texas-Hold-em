/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.control.InGameController;
import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.view.UI;

/**
 * @author bnagy
 *
 */
public class Bid {// licit
	private Player currentPlayer;
	private Player lastRaiser;
	private CircularLinkedList<Player> playersInHand = new CircularLinkedList<>();
	private Round round;
	private InGameController igc;

	public Bid(CircularLinkedList<Player> players, Round round, InGameController igc) {
		this(players, round);
		this.igc = igc;
	}

	/**
	 * @param players
	 * @param preflop
	 */
	public Bid(CircularLinkedList<Player> players, Round round) {
		this.round = round;
		for (Player p : players) {
			if (p.isInHand()) {
				playersInHand.add(p);
			}
		}
	}

	public void run() {
		lastRaiser = getBigBlind();
		//Megnézi, ha preflop vagyunk akkor a nagyvak utáni cselekszik elsőnek, 
		//különben a dealer utáni.
		if (round.getValue() == 0) {
			currentPlayer=playersInHand.getNext(lastRaiser);
		} else {
			currentPlayer=playersInHand.getNext(getDealer());
		}
		//
		while (!isEndOfBid(currentPlayer, lastRaiser)) {
			igc.useMenu(igc.menu);
			/*
			 * while(nincs vége a licitnek)
			 * mit csinál az akt játékos
			 * léptetni az aktuális játékost
			 * 
			 * addig tart, amíg players.getNext() vissza nem ér a lastRaiser-hez.
			 */
			currentPlayer = stepTroughCurrentPlayer(currentPlayer);	
		}
		
	}
	//Akkor van vége egy licitkörnek amikor az utolsó hand-ben lévő játékos
	//után az emelő következne ÉS az utolsó játékos nem emel vissza(vagyis csak megad vagy dob).
	public boolean isEndOfBid(Player raisingPlayer, Player actualPlayer) {
		if (playersInHand.getNext(actualPlayer) == raisingPlayer && actualPlayer.getLastAction() != InGameAction.RAISE) {
			return true;
		}
		return false;
	}

	private Player stepTroughCurrentPlayer(Player currentPlayer) {
		Player nextPlayer = playersInHand.getNext(currentPlayer);
		igc.ui.print(nextPlayer.getName());
		igc.ui.showMessage("is_your_turn");
		/*
		 * Player act = currentPlayer; while(act.getNextPlayer().isFolded()) { act =
		 * currentPlayer.getNextPlayer(); } return act.getNextPlayer();
		 */
		return nextPlayer;
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
