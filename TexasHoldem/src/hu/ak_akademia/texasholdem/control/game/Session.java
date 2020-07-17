/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.control.InGameController;
import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.model.deck.Deck;
import hu.ak_akademia.texasholdem.view.UI;

/**
 * @author bnagy
 * @author Artúr Ölvedi
 */
public class Session {
	private CircularLinkedList<Player> players = new CircularLinkedList<Player>();
	private Deck deck = new Deck();
	private Hand currentHand;
	
	UI ui = UI.getUi();
	private int buyIn = 0;

	/**
	 * @param player
	 */
	public String addPlayer(Player player) {
		String feedbackMsg = "";
		if (!players.contains(player)) {
			players.add(player);
			feedbackMsg = "newgame_player_addedtogame";
		} else {
			feedbackMsg = "newgame_player_alreadyingame";
		}
		return feedbackMsg;
	}

	public int getBuyIn() {
		return buyIn;
	}

	public Hand getCurrentHand() {
		return currentHand;
	}

	public CircularLinkedList<Player> getPlayers() {
		return players;
	}

	public void setBuyIn(int entry) {
		this.buyIn = entry;
	}

	/**
	 * 
	 */
	public void start(InGameController igc) {
		
		  while(players.getListOfPlayers().size() > 1) {
		      Hand hand = new Hand(players,igc);
		      currentHand = hand;
		      hand.runHand(); }
		 
		
		
		/*
		 * shuffleUpAndDeal(); deck.shuffle(); System.out.println();
		 * System.out.print("A játék elindult a következő játékosokkal: "); for (int i =
		 * 0; i < players.getListOfPlayers().size(); i++) {
		 * System.out.print(players.getListOfPlayers().get(i).getName() + ":");
		 * players.getListOfPlayers().get(i).setCard1(deck.draw()); deck.burn();
		 * players.getListOfPlayers().get(i).setCard2(deck.draw()); deck.burn();
		 * System.out.print(players.getListOfPlayers().get(i).getCard1());
		 * System.out.print(players.getListOfPlayers().get(i).getCard2() + " "); }
		 * System.out.println();
		 */

	}
	public Hand newHand() {
		currentHand = new Hand(players);
		return currentHand;
	}
	@Override
	public String toString() {
		// TODO Iza
		return "";
	}

	private void shuffleUpAndDeal() {
		ui.showMessage("the_game_is_starting");
		for (int i = 3; i > 0; i--) {
			wait(333);
			System.out.print(i);
			wait(333);
			System.out.print(".");
			wait(333);
			System.out.print(".");
			wait(333);
			System.out.print(".");
		}
		ui.showMessage("shuffle_up_and_deal");
	}

	private void wait(int mSecond) {
		try {
			Thread.sleep(mSecond);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
