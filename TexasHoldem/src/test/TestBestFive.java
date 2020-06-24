/**
 * 
 */
package test;

import java.util.Random;

import hu.ak_akademia.texasholdem.control.ApplicationController;
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

	private void run() {
		System.out.println("Random tests:");
		for(int i = 0; i < 50; i++) {
			Card[] cards = getRandomCards();
			print(cards);
			BestFive bf = new BestFive(cards[0], cards[1], cards[2], cards[3], cards[4]);
			print(bf.getBestFiveCards());
			System.out.println("The value of this poker hand is " +
					ApplicationController.bundle.getString(bf.getBestFiveValue().getTextual()));
			System.out.println("----------------------------------------------");
		}
		System.out.println("Royal Flush:");
		Card[] cards = new Card[5];
		cards[1] = new Card(CardColor.CLUBS,Figure.ACE);
		cards[0] = new Card(CardColor.CLUBS,Figure.KING);
		cards[4] = new Card(CardColor.CLUBS,Figure.QUEEN);
		cards[2] = new Card(CardColor.CLUBS,Figure.JACK);
		cards[3] = new Card(CardColor.CLUBS,Figure.TEN);
		print(cards);
		BestFive bf = new BestFive(cards[0], cards[1], cards[2], cards[3], cards[4]);
		print(bf.getBestFiveCards());
		System.out.println("The value of this poker hand is " + 
				ApplicationController.bundle.getString(bf.getBestFiveValue().getTextual())
		);
		System.out.println("----------------------------------------------");
		System.out.println("Straight Flush:");
		cards[1] = new Card(CardColor.CLUBS,Figure.ACE);
		cards[0] = new Card(CardColor.CLUBS,Figure.TWO);
		cards[4] = new Card(CardColor.CLUBS,Figure.THREE);
		cards[2] = new Card(CardColor.CLUBS,Figure.FIVE);
		cards[3] = new Card(CardColor.CLUBS,Figure.FOUR);
		print(cards);
		BestFive bf2 = new BestFive(cards[0], cards[1], cards[2], cards[3], cards[4]);
		print(bf2.getBestFiveCards());
		System.out.println("The value of this poker hand is " + 
				ApplicationController.bundle.getString(bf2.getBestFiveValue().getTextual())
		);
		System.out.println("----------------------------------------------");
		System.out.println("Straight:");
		cards[1] = new Card(CardColor.CLUBS,Figure.SIX);
		cards[0] = new Card(CardColor.DIAMOND,Figure.TWO);
		cards[4] = new Card(CardColor.HEARTS,Figure.THREE);
		cards[2] = new Card(CardColor.SPADES,Figure.FIVE);
		cards[3] = new Card(CardColor.CLUBS,Figure.FOUR);
		print(cards);
		BestFive bf3 = new BestFive(cards[0], cards[1], cards[2], cards[3], cards[4]);
		print(bf3.getBestFiveCards());
		System.out.println("The value of this poker hand is " + 
				ApplicationController.bundle.getString(bf3.getBestFiveValue().getTextual())
		);
		System.out.println("----------------------------------------------");
	}
}
