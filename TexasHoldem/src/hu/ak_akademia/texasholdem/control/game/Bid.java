/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.CircularLinkedList;

/**
 * @author bnagy
 *
 */
public class Bid {//licit
	private Player currentPlayer;
	CircularLinkedList<Player> playersInHand = new CircularLinkedList<>();
	private Round round;
	
	public Bid(CircularLinkedList<Player> players, Round round) {
		this.round = round;
		for(Player p : players) {
			if(p.isInHand()) {
				playersInHand.add(p);
			}
			/*
			 * if(round.equals(Round.PREFLOP)) { if(p.isBigBlind()) { currentPlayer =
			 * p.getNextPlayer(); } } else { if(p.isDealer()) { currentPlayer =
			 * p.getNextPlayer(); } }
			 */
		}
	}
	
	public void run() {
		Player lastRaiser = 
		// while(nincs vége a licitnek)
		// mit csinál az akt játékos
		// léptetni az aktuális játékost
		
		currentPlayer = stepTroughCurrentPlayer(currentPlayer);	
		
	}
	
	private Player stepTroughCurrentPlayer(Player currentPlayer) {
		/*
		 * Player act = currentPlayer; while(act.getNextPlayer().isFolded()) { act =
		 * currentPlayer.getNextPlayer(); } return act.getNextPlayer();
		 */
		return null;
	}
	
	private Player getDealer() {
		for(Player p : playersInHand) {
			if(p.isDealer()) {
				return p;
			}
		}
		return null;//Ilyen nem lehet.
	}
	
	
}
