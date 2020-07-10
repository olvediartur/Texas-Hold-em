/**
 * 
 */
package test;

import java.util.Random;

import hu.ak_akademia.texasholdem.control.DbController;
import hu.ak_akademia.texasholdem.control.bl.BestFive;
import hu.ak_akademia.texasholdem.model.db.GameEntity;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.model.deck.CardColor;
import hu.ak_akademia.texasholdem.model.deck.Figure;
import hu.ak_akademia.texasholdem.view.UI;

/**
 * @author bnagy
 *
 */
public class TestStatistic {
	public static void main(String[] args) {
		new TestStatistic().run();
	}
	
	private void run() {
		DbController dbc = DbController.getDbc();
		Card[] cards = getRandomCards();
		BestFive bf = new BestFive(cards[0], cards[1], cards[2], cards[3], cards[4]);
		dbc.getPlayerInGameController().setSelected(new PlayerInGameEntity(21, 4, bf));
		dbc.getPlayerInGameController().create();
	}
	
	private Card[] getRandomCards() {
		int n = 5;
		Card[] cards = new Card[n];
		Random rnd = new Random();
		for(int i = 0; i < n; i++) {
			cards[i] = new Card(CardColor.values()[rnd.nextInt(4)], Figure.values()[rnd.nextInt(13)]);
		}
		return cards;
	}
}
