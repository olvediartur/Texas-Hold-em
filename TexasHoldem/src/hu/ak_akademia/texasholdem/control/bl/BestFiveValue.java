/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.model.deck.CardColor;
import hu.ak_akademia.texasholdem.model.deck.Figure;

/**
 * @author bnagy
 * @author Lidia
 *
 */
public enum BestFiveValue {
	ROYAL_FLUSH(1,"royalflush"),
	STRAIGHT_FLUSH(2,""),
	FOUR_OF_KIND(3,""),
	FULL_HOUSE(4),
	FLUSH(5),
	STRAIGHT(6),
	THREE_OF_KIND(7),
	TWO_PAIR(8),
	PAIR(9),
	HIGH_CARD(10);
	
	// poker
	// drill

	private int value; // mező
	private String textual;
	
	private BestFiveValue(int value, String textual) {
		this.value = value;
		this.textual = textual;
	}

	public int getValue() {
		return value;
	}
	
	public String getTextual(String text) {
		return textual;
	}

	

	public static BestFiveValue getValueOfCards(Card[] cards) {
		//ha royalflush, akkor return ROYAL_FLUSH,
		// egyébként ha .....
		if(isRoyalFlush(cards)) {
			return BestFiveValue.ROYAL_FLUSH;
		}
		if(isStraightFlush(cards)) {
			return BestFiveValue.STRAIGHT_FLUSH;
		}
		return null; //enum beli elemmel tér vissza
	}
	
	/**
	 * @param cards
	 * @return
	 */
	private static boolean isStraightFlush(Card[] cards) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isRoyalFlush(Card[] cards) {
		//egyszínű-e?
		CardColor cc = cards[0].getColor();
		for(Card c : cards) {
			if(!cc.equals(c.getColor())) {
				return false;
			};
		}
		// ász-e az első ?
		if(!cards[0].getFigure().equals(Figure.ACE)) {
			return false;
		}
		// Király-e a második
		if(!cards[1].getFigure().equals(Figure.KING)) {
			return false;
		}
		// dáma e a harmadik?
		if() {
			
		}
		// jack?
		if() {
			
		}
		// 10?
		if() {
			
		}
		return true;
	}

}
