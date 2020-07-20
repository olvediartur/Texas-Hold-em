/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.CircularLinkedList;

/**
 * @author bnagy
 * @author Artúr Ölvedi
 */
public class Session {
	
	private CircularLinkedList<Player> players = new CircularLinkedList<Player>();
	private Hand currentHand;
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

	/**
	 * @return
	 */
	public int getBuyIn() {
		return buyIn;
	}

	/**
	 * @return
	 */
	public Hand getCurrentHand() {
		return currentHand;
	}

	public void setCurrentHand(Hand currentHand) {
		this.currentHand = currentHand;
	}

	/**
	 * @return CircularLinkedList<Player>
	 */
	public CircularLinkedList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param buyIn
	 * Set field buyIn to param.
	 */
	public void setBuyIn(int buyIn) {
		this.buyIn = buyIn;
	}

	/**
	 * Create new Hand Object.
	 * Set field currentHand to this object.
	 * @return Hand
	 */
	public Hand newHand() {
		currentHand = new Hand(players);
		return currentHand;
	}
	
	/**
	 * Session is over when the players number
	 * is one or less.
	 * @return boolean
	 */
	public boolean isOver() {
		return getPlayers().getListOfPlayers().size() <= 1;
	}
	
	@Override
	public String toString() {
		// TODO Iza
		return "";
	}

	private void shuffleUpAndDeal() {
		System.out.println("the_game_is_starting");
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
		System.out.println("shuffle_up_and_deal");
	}
	private void wait(int mSecond) {
		try {
			Thread.sleep(mSecond);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}
