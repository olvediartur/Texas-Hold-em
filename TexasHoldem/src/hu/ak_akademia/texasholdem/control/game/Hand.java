/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.control.InGameController;
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
	private InGameController igc;
	private List<Card> board = new ArrayList<>();
	private Bid currentBid;
	private boolean over = false;
	private int pot = 0;

	public Hand(InGameController igc) {
		super();
		this.igc = igc;
	}

	public Hand(CircularLinkedList<Player> players, InGameController igc) {
		this.players = players;
		this.igc = igc;
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
		for (Player p : players) {
			p.setInHand(true);
		}
	}

	/**
	 * 
	 */
	public void runHand() {
		deck.shuffle();
		deal();
		currentBid = new Bid(players, Round.PREFLOP, igc);
		currentBid.run();
		if (!isOver()) {
			dealOnStreet(Round.FLOP);
			currentBid = new Bid(players, Round.FLOP, igc);
			currentBid.run();
			if (!isOver()) {
				dealOnStreet(Round.TURN);
				currentBid = new Bid(players, Round.TURN, igc);
				currentBid.run();
				if (!isOver()) {
					dealOnStreet(Round.RIVER);
					currentBid = new Bid(players, Round.RIVER, igc);
					currentBid.run();
				}
			}
		}
		showDown();
	}

	public Bid getCurrentBid() {
		return currentBid;
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
