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
	private Deck deck = new Deck();
	private List<Player> players = new ArrayList<>();
	
	/**
	 * @param player
	 */
	public void addPlayer(Player player) {
		if(!players.contains(player)) {
			players.add(player);
		}
	}
	
	/**
	 * @return
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * 
	 */
	public void start() {
		//TODO write methods of game object
		System.out.println("MEGY A JÁTÉK");
	}
	
}
