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
	ROYAL_FLUSH(1, "royalflush"), STRAIGHT_FLUSH(2, ""), FOUR_OF_KIND(3, ""), FULL_HOUSE(4, ""), FLUSH(5, ""),
	STRAIGHT(6, ""), THREE_OF_KIND(7, ""), TWO_PAIR(8, ""), PAIR(9, ""), HIGH_CARD(10, "");

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
		// ha royalflush, akkor return ROYAL_FLUSH,
		// egyébként ha .....

		if (isRoyalFlush(cards)) {
			return BestFiveValue.ROYAL_FLUSH;
		}
		if (isStraightFlush(cards)) {
			return BestFiveValue.STRAIGHT_FLUSH;
		}
		if (isFourOfKind(cards)) {
			return BestFiveValue.FOUR_OF_KIND;
		}
		if (isFullHouse(cards)) {
			return BestFiveValue.FULL_HOUSE;
		}
		if (isFlush(cards)) {
			return BestFiveValue.FLUSH;
		}
		if (isStraight(cards)) {
			return BestFiveValue.STRAIGHT;
		}
		if (isThreeOfKind(cards)) {
			return BestFiveValue.THREE_OF_KIND;
		}
		if (isTwoPair(cards)) {
			return BestFiveValue.TWO_PAIR;
		}
		if (isPair(cards)) {
			return BestFiveValue.PAIR;
		}

		return HIGH_CARD; // enum beli elemmel tér vissza (ha nem 1-9-ig akkor 10)
	}

	/**
	 * @param cards
	 * @return
	 */
//	private static boolean isStraightFlush(Card[] cards) { // színsor és 5 kártya egymás után következik
//		CardColor cc = cards[0].getColor();
//		for (Card c : cards) {
//			if (!cc.equals(c.getColor())) {
//				return false;
//			}
//			;
//		}
//	}

//	int max = cards[0]; // maximumkeresés az 5 kártya között - getValue();
//	for(
//	int i = 0;i<cards[4];i++)
//	{
//		int number = cards[i];
//
//		if (number > max) {
//			max = number;
//
//		}
//	}

	// ellenőrzöm, hogy a maradék 4 kártya sorban következik-e cards[1] > cards[2]
	// stb.
//}
	// vagy sorbarendezés és utána hasonlítom össze a kártyákat

//	sort(bestFiveCard); //-> a kárytákat sorba rendezi
//	bestFiveValue = BestFiveValue.getValueOfCards(bestFiveCard);
//}
//	return true;

//}

//	private static boolean isFourOfKind(Card[] cards) { //4 ugyanolyan értékű, de most mindet összehasonlítom!!
//		int figure = cards[0].getValue(); 				//szín nem egyezik meg
//		for(Figure f : Figure.values()) { 
//			if(!figure.equals(f.getValue())) {
//				return false;
//			};
//		}
//
//		//		
////		if(ha 4 db kártya megegyezik) {
////			
//		}
//		return false;
//	}

	private static boolean isFullHouse(Card[] cards) {
		// 1 drill és egy pár
		return false;
	}

	private static boolean isFlush(Card[] cards) { // szín megegyezik
		CardColor cc = cards[0].getColor();
		for (Card c : cards) {
			if (!cc.equals(c.getColor())) {
				return false;
			}
			;
		}
		return true;
	}

	private static boolean isStraight(Card[] cards) {
		// 5 egymás után következő kártya
		return false;
	}

	private static boolean ThreeOfKind(Card[] cards) {
		// drill
		return false;
	}

	private static boolean TwoPair(Card[] cards) {
		// két pár
		return false;
	}

	private static boolean Pair(Card[] cards) {
		// egy pár
		return false;
	}

	private static boolean isRoyalFlush(Card[] cards) {
		// egyszínű-e?
		CardColor cc = cards[0].getColor();
		for (Card c : cards) {
			if (!cc.equals(c.getColor())) {
				return false;
			}
			;
		}
		// ász-e az első ?
		if (!cards[0].getFigure().equals(Figure.ACE)) {
			return false;
		}
		// Király-e a második
		if (!cards[1].getFigure().equals(Figure.KING)) {
			return false;
		}
		// dáma e a harmadik?
		if (!cards[2].getFigure().equals(Figure.QUEEN)) {
			return false;
		}
		// jack e a 4.?
		if (!cards[3].getFigure().equals(Figure.QUEEN)) {
			return false;
		}
		// 10-es e az 5.?
		if (!cards[4].getFigure().equals(Figure.QUEEN)) {
			return false;
		}
		return true;
	}

}
