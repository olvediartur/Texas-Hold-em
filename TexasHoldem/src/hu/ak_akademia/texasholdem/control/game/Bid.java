/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bnagy
 *
 */
public class Bid {//licit
	private Player currentPlayer;
	private List<Player> playersInHand = new ArrayList<>();
	private Round round;
	
	public Bid(List<Player> players, Round round) {
		this.round = round;
		for(Player p : players) {
			if(p.isInHand()) {
				playersInHand.add(p);
			}
			if(round.equals(Round.PREFLOP)) {
				if(p.isBigBlind()) {
					currentPlayer = p.getNextPlayer();
				}
			} else {
				if(p.isDealer()) {
					currentPlayer = p.getNextPlayer();
				}
			}
		}
	}
	
	public void run() {
		// while(nincs vége a licitnek)
		// mit csinál az akt játékos
		// léptetni az aktuális játékost
		currentPlayer = stepTroughCurrentPlayer(currentPlayer);		
	}
	
	private Player stepTroughCurrentPlayer(Player currentPlayer) {
		Player act = currentPlayer;
		while(act.getNextPlayer().isFolded()) {
			act = currentPlayer.getNextPlayer();
		}
		return act.getNextPlayer();
	}
	
	
}
