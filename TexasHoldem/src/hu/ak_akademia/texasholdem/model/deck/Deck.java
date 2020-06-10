/**
 * Ez a k�rtyapakli oszt�ly.
 */
package hu.ak_akademia.texasholdem.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Art�r �lvedi
 *
 */
public class Deck {
	private List<Card> cards = new ArrayList<Card>();

	/**
	 * @param cards
	 */
	public Deck(List<Card> cards) {
		super();
		this.cards = cards;
	}

	/**
	 * @param color-color of the card, figure-figure of the card
	 * 
	 */
	public Deck(String color, String figure) {
		CardColor.getColorEnum(color);
		Figure.getFigureEnum(figure);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() {
		Card lastCard = cards.get(cards.size() - 1);
		cards.remove(cards.size() - 1);
		return lastCard;
	}

	public void burn() {
		int index = cards.size() - 1;
		cards.remove(index);
	}

	public String toString() {
		String deck = "";
		for (int i = 0; i < cards.size(); i++) {
			deck = deck + cards.get(i).toString() + " ";
		}
		return deck;
	}

}
