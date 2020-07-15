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
		if (!isOver()) {
			dealOnStreet(Round.FLOP);
			new Bid(players, Round.FLOP);
			if (!isOver()) {
				dealOnStreet(Round.TURN);
				new Bid(players, Round.TURN);
				if (!isOver()) {
					dealOnStreet(Round.RIVER);
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
	private void dealOnStreet(Round round) {
		deck.burn();
		for (int i = 0; i < round.getValue(); i++) {
			board.add(deck.draw());
		}
	}

	/**
	 * 
	 */
	private void deal() {
		for (Player p : players) {
			p.setCard1(deck.draw());
		}
		for (Player p : players) {
			p.setCard2(deck.draw());
		}
	}

	/**
	 * @return
	 */
	private boolean isOver() {
		if (getNumberOfPlayersInHand() > 1) {
			return false;
		}
		return true;
	}

	/**
	 * @return
	 */
	private int getNumberOfPlayersInHand() {
		int ans = 0;
		for (Player p : players) {
			if (p.isInHand()) {
				ans++;
			}
		}
		return ans;
	}

}
