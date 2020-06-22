/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import java.util.Arrays;

/**
 * Meghívtam a deck packaget.
 */
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.model.deck.CardColor;
import hu.ak_akademia.texasholdem.model.deck.Figure;

/**
 * Ez a legjobb 5 kártyát tároló osztály.
 * 
 * @author bnagy
 * @author Lidia
 *
 */

public class BestFive { // osztály

	private Card[] bestFiveCard = new Card[5]; // 5 card objektum egységbe zárása
	private BestFiveValue bestFiveValue;

	/**
	 * konstruktorában 5 kártyát vár, amit
	 * eltárol magában
	 * @param card1
	 * @param card2
	 * @param card3
	 * @param card4
	 * @param card5
	 */
	public BestFive(Card card1, Card card2, Card card3, Card card4, Card card5) {
		bestFiveCard[0] = card1;
		bestFiveCard[1] = card2;
		bestFiveCard[2] = card3;
		bestFiveCard[3] = card4;
		bestFiveCard[4] = card5;
		sort(bestFiveCard); //-> a kárytákat sorba rendezi
		bestFiveValue = BestFiveValue.getValueOfCards(bestFiveCard);
	}

	/**
	 * visszatér a magában tárolt kártyák tömbjével
	 * @return
	 */
	public Card[] getBestFiveCards() {
		return bestFiveCard;
	}

	public BestFiveValue getBestFiveValue() {
		return bestFiveValue;
	}

	public String toString() {
		String result = "";
		String separator = "";
		for (Card card : bestFiveCard) {
			result = result + separator + card.toString();
			separator = " - ";
		}
		return result;
	}


//	public boolean equals(Card card){
//		 return (color.equals(card.getColor()) && figure.equals(card.getFigure()));
// meg kell fogalmazni azt a logikát, hogy két kéz mikor egyenlő 
//	} 

	// public enum Color {
	// GREEN, BLUE, BLACK, RED;

	// }

	

	public static void sort(Card[] cards) {
		CardComparator comp = new CardComparator();
		boolean sorted = false;
		Card temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < cards.length - 1; i++) {
				if (comp.compare(cards[i], cards[i + 1]) == -1) {
					temp = cards[i];
					cards[i] = cards[i + 1];
					cards[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bestFiveCard);
		result = prime * result + ((bestFiveValue == null) ? 0 : bestFiveValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BestFive other = (BestFive) obj;
		if (bestFiveValue != other.bestFiveValue) {
			return false;
		}
		if (!Arrays.equals(bestFiveCard, other.bestFiveCard)) {
			return false;
		}
		return true;
	}

}
