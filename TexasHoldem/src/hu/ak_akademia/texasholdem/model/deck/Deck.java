/**
 * Ez a kártyapakli osztály.
 */
package hu.ak_akademia.texasholdem.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artúr Ölvedi
 *
 */
public class Deck {
	private List<Card> cards = new ArrayList<Card>();

	/**
	 * @param cards
	 */
	public Deck() {
		for (Figure f : Figure.values()) {
			for (CardColor cc : CardColor.values()) {
				cards.add(new Card(cc, f));
			}
		}
	}

	/**
	 * @param color-color of the card, figure-figure of the card
	 * 
	 */
	public Deck(String color, String figure) {
		CardColor.getColorEnum(color);
		Figure.getFigureEnum(figure);
	}

	public void shuffle() { // megkeveri a paklit
		Collections.shuffle(cards);
	}

	public Card draw() { // kiosztunk 1 lapot
		Card lastCard = cards.get(cards.size() - 1);
		cards.remove(cards.size() - 1);
		return lastCard;
	}

	public void burn() { // égetünk 1 lapot
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
