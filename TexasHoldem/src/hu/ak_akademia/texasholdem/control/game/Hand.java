/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.model.deck.Deck;

/**
 * @author bnagy
 *
 */
public class Hand {
	private Deck deck = new Deck();
	private List<Player> players = new ArrayList<>();
	private int pot = 0;

	public Hand(List<Player> players) {
		this.players = players;
		boolean hasDealer = false;
		for (Player p : players) {
			if (p.isDealer()) {
				p.getNextPlayer().setDealer(true);
				hasDealer = true;
			}
		}
		if (!hasDealer) {
			for (Player p : players) {
				if (p.isOwner()) {
					p.setDealer(true);
				}
			}
		}
	}
	
	public void runHand() {
		dealing();
		new Bid(players, Round.PREFLOP);
	}

	/**
	 * 
	 */
	private void dealing() {
		for(Player p : players) {
			p.setCard1(deck.draw());
		}
		for(Player p : players) {
			p.setCard2(deck.draw());
		}		
	}

}
