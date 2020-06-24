/**
 * 
 */
package test;

import java.util.Random;

import hu.ak_akademia.texasholdem.control.bl.BestFive;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.model.deck.CardColor;
import hu.ak_akademia.texasholdem.model.deck.Figure;

/**
 * @author bnagy
 *
 */
public class TestBestFive {
	
	public static void main(String[] args) {
		new TestBestFive().run();
	}

	private void run() {
		for(int i = 0; i < 100; i++) {
			Card[] cards = getRandomCards();
			print(cards);
			BestFive bf = new BestFive(cards[0], cards[1], cards[2], cards[3], cards[4]);
			print(bf.getBestFiveCards());
			System.out.println("The value of this poker hand is " + bf.getBestFiveValue().getTextual());
			System.out.println("----------------------------------------------");
		}
	}

	/**
	 * 
	 */
	private Card[] getRandomCards() {
		int n = 5;
		Card[] cards = new Card[n];
		Random rnd = new Random();
		for(int i = 0; i < n; i++) {
			cards[i] = new Card(CardColor.values()[rnd.nextInt(4)], Figure.values()[rnd.nextInt(13)]);
		}
		return cards;
	}
	
	private void print(Card[] cards) {
		String sep = "";
		String printMe = "";
		for(Card c : cards) {
			printMe = printMe + sep + c.toString();
			sep = " - ";
		}
		System.out.println(printMe);
	}
}
