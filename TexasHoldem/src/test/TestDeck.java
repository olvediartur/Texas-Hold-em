/**
 * Ez a kártyapakli tesztelése.
 */
package test;

import hu.ak_akademia.texasholdem.model.deck.Deck;

/**
 * @author Artúr Ölvedi
 *
 */

public class TestDeck {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.draw());
		System.out.println(deck);
		deck.burn();
		System.out.println(deck);
	}

}
