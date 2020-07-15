/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.model.deck.Deck;

/**
 * @author bnagy
 *
 */
public class Hand {
	private Deck deck = new Deck();
	private CircularLinkedList<Player> players = new CircularLinkedList<>();
	private int pot = 0;

	public Hand(CircularLinkedList<Player> players) {
		this.players = players;
		boolean hasDealer = false;
		for (Player p : players) {
			if (p.isDealer()) {
				players.getNext(p).setDealer(true);
				p.setDealer(false);
				hasDealer = true;
				break;
			}
		}
		
		if (!hasDealer) {
			for (Player p : players) {
				if (p.isOwner()) {
					p.setDealer(true);
					break;
				}
			}
		}
	}
	
	public void runHand() {
		System.out.println("shuffle deck ...");
		deck.shuffle();
		System.out.println("dealing ...");
		dealing();
		System.out.println("preflop bid ...");
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
