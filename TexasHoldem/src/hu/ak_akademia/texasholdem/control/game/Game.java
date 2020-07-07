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
public class Game {
	private List<Player> players = new ArrayList<>();
	private int entry = 0;
	
	/**
	 * @param player
	 */
	public String addPlayer(Player player) {
		String feedbackMsg = "";
		if(!players.contains(player)) {
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
	public List<Player> getPlayers() {
		return players;
	}
	
	public int getEntry() {
		return entry;
	}

	public void setEntry(int entry) {
		this.entry = entry;
	}

	/**
	 * 
	 */
	public void start() {
		//TODO write methods of game object
		System.out.println("MEGY A JÁTÉK");
	}
	
}
