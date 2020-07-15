/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.model.deck.Deck;

/**
 * @author bnagy
 *
 */
public class Hand {
	private Deck deck = new Deck();
	private CircularLinkedList<Player> players = new CircularLinkedList<>();
	private List<Card> board = new ArrayList<>();
	private boolean over = false;
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
	
	/**
	 * 
	 */
	public void runHand() {
		System.out.println("shuffle deck ...");
		deck.shuffle();
		System.out.println("dealing ...");
		deal();
		System.out.println("preflop bid ...");
		new Bid(players, Round.PREFLOP);
		if(!isOver()) {
			dealFlop();
			new Bid(players, Round.FLOP);
			if(!isOver()) {
				dealTurn();
				new Bid(players, Round.TURN);
				if(!isOver()) {
					dealRiver();
					new Bid(players, Round.RIVER);
				}
			}
		}
		showDown();
	}

	/**
	 * 
	 */
	private void showDown() {
		// TODO
		// Győztes meghatározása
		// Adatok leküldése a db-be
	}

	/**
	 * 
	 */
	private void dealRiver() {
		// TODO
		// Eléget egy lapot
		// egy kártya megy a boardra (-ba)
	}

	/**
	 * 
	 */
	private void dealTurn() {
		// TODO
		// Eléget egy lapot
		// egy kártya megy a boardra (-ba)
		
	}

	/**
	 * 
	 */
	private void dealFlop() {
		// TODO
		// Elégetünk egy lapot
		// boardra (-ba) teszünk hármat
		
	}

	/**
	 * 
	 */
	private void deal() {
		for(Player p : players) {
			p.setCard1(deck.draw());
		}
		for(Player p : players) {
			p.setCard2(deck.draw());
		}		
	}
	
	/**
	 * @return
	 */
	private boolean isOver() {
		if(getNumberOfPlayersInHand() > 1) {
			return false;
		}
		return true;
	}

	/**
	 * @return
	 */
	private int getNumberOfPlayersInHand() {
		int ans = 0;
		for(Player p : players) {
			if(p.isInHand()) {
				ans++;
			}
		}
		return ans;
	}

}
