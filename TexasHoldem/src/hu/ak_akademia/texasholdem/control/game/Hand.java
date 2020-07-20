/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.control.bl.Game;
import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.model.db.GameEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.model.deck.Deck;

/**
 * @author bnagy
 *
 */
public class Hand extends Game {
	
	private Deck deck = new Deck();
	private CircularLinkedList<Player> players = new CircularLinkedList<>();
	private List<Card> board = new ArrayList<>();
	private Bid currentBid;

	/**
	 * @param players
	 */
	public Hand(CircularLinkedList<Player> players) {
		super(LocalDate.now());
		initPlayers(players);
	}

	public Hand(CircularLinkedList<Player> players, GameEntity entity) {
		super(entity);
		initPlayers(players);

	}

	public CircularLinkedList<Player> getPlayers() {
		return players;
	}

	public List<Card> getBoard() {
		return board;
	}

	public Bid getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Bid currentBid) {
		this.currentBid = currentBid;
	}

	public void addToPot(int chips) {
		setPot(getPot() +  chips);
	}

	/**
	 * 
	 */
	public void dealOnStreet(Round round) {
		deck.burn();
		for (int i = 0; i < round.getValue(); i++) {
			board.add(deck.draw());
		}
	}

	/**
	 * 
	 */
	public void deal() {
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
	public boolean isOver() {
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

	private void initPlayers(CircularLinkedList<Player> players) {
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
		for (Player p : players) {
			p.setInHand(true);
		}
	}
	public void shuffleDeck() {
		deck.shuffle();
	}

	public Bid newBid(Round round) {
		Bid bid = new Bid(players, round);
		currentBid = bid;
		return bid;
	}

}