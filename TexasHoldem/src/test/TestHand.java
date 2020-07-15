/**
 * 
 */
package test;

import hu.ak_akademia.texasholdem.control.game.Hand;
import hu.ak_akademia.texasholdem.control.game.Player;
import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class TestHand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList<Player> players = new CircularLinkedList<>();
		PokerUserEntity pu1 = new PokerUserEntity("egy",1,false);
		players.add(new Player(pu1,true));
		PokerUserEntity pu2 = new PokerUserEntity("kett",1,false);
		players.add(new Player(pu2,false));
		PokerUserEntity pu3 = new PokerUserEntity("haro",1,false);
		players.add(new Player(pu3,false));
		//players.getListOfPlayers().get(0).setDealer(true);
		Hand hand1 = new Hand(players);
		//System.out.println("dealer: " + players.getDealer().getData().getName());
		
		System.out.println("players:");
		for(Player p : players) {
			System.out.println(p.getName() + (p.isDealer() ? " is " : " isn't ") + "dealer.");
		}		
		hand1.runHand();
		Hand hand2 = new Hand(players);
		for(Player p : players) {
			System.out.println(p.getName() + (p.isDealer() ? " is " : " isn't ") + "dealer.");
		}	
	}

}
