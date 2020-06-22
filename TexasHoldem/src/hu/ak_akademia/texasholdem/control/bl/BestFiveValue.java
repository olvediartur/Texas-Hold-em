/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author bnagy
 * @author Lidia
 *
 */
public enum BestFiveValue {
	ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_KIND, TWO_PAIR, PAIR, HIGH_CARD;
	// poker
	// drill

	public int value = 0; // mező

//	public int value1 = ROYAL_FLUSH;
//	public int value2 = STRAIGHT_FLUSH;
//	public int value3 = FOUR_OF_A_KIND;
//	public int value4 = FULL_HOUSE;
//	public int value5 = FLUSH;
//	public int value6 = STRAIGHT;
//	public int value7 = THREE_OF_KIND;
//	public int value8 = TWO_PAIR;
//	public int value9 = PAIR;
//	public int value10 = HIGH_CARD;
//	

	String textual = "";
	

	public static int getValue(int value) {

		int valueOfCard = 0;
		return valueOfCard;
	}
	
	public static String getTextual(String text) {

		String texts = "";
		return texts;
	}

	

	public static BestFiveValue getValueOfCards(Card[] cards) {
	
		
		return null; //enum beli elemmel tér vissza
	}

}
