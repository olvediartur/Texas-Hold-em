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
	ROYAL_FLUSH(1, "royalflush"), STRAIGHT_FLUSH(2, "straightflush"), FOUR_OF_KIND(3, "poker"),
	FULL_HOUSE(4, "full"), FLUSH(5, "flush"), STRAIGHT(6, "straight"), THREE_OF_KIND(7, "drill"),
	TWO_PAIR(8, "twopairs"), PAIR(9, "pair"), HIGH_CARD(10, "highcard");

	private int value; // mező
	private String textual;

	private BestFiveValue(int value, String textual) {
		this.value = value;
		this.textual = textual;
	}

	public int getValue() {
		return value;
	}

	public String getTextual() {
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
		return BestFiveValue.HIGH_CARD; // enum beli elemmel tér vissza (ha nem 1-9-ig akkor 10)
	}

	/**
	 * @param cards
	 * @return igaz, ha mind az 5 kártya egyszínű
	 */
	private static boolean isFlush(Card[] cards) { // szín megegyezik
		CardColor cc = cards[0].getColor();
		for (Card c : cards) {
			if (!cc.equals(c.getColor())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param cards
	 * @return igaz, az öt kártya figurájának az értéke sorban követi egymást
	 */
	private static boolean isStraight(Card[] cards) {
		// 5 egymás után következő kártya
		Card first = cards[0];
		for(int i = 1; i < cards.length;i++) {
			if(i + first.getFigure().getValue() != cards[i].getFigure().getValue()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param cards
	 * @return igaz, ha egyszínű és sor
	 */
	private static boolean isStraightFlush(Card[] cards) {
		if(!isFlush(cards)) {
			return false;
		}
		if(!isStraight(cards)) {
			return false;
		}
		return true;
	}

	/**
	 * @param cards
	 * @return igaz, ha színsor és Ász a legnagyobb
	 */
	private static boolean isRoyalFlush(Card[] cards) {
		if(!isStraightFlush(cards)) {
			return false;
		}
		if (!cards[0].getFigure().equals(Figure.ACE)) {
			return false;
		}
		return true;
	}

	/**
	 * @param cards
	 * @return
	 */
	private static boolean isFourOfKind(Card[] cards) {
		Card first = cards[0];
		Card second = cards[1];
		if(first.getFigure().getValue() == second.getFigure().getValue()) {
			for(int i = 2; i <= 3; i++) {
				if(cards[i].getFigure().getValue() != first.getFigure().getValue()) {
					return false;
				}
			}
		} else {
			for(int i = 2; i <= 4; i++) {
				if(cards[i].getFigure().getValue() != second.getFigure().getValue()) {
					return false;
				}
			}
		}
		return true;
	}



	/**
	 * @param cards
	 * @return akkor igaz, ha van két pár és egy drill
	 */
	private static boolean isFullHouse(Card[] cards) {
		if(!isThreeOfKind(cards)) {
			return false;
		}
		if(!isTwoPair(cards)) {
			return false;
		}
		return true;
	}

	/**
	 * @param cards
	 * @return
	 * Három féle képpen lehet
	 * AAAXY
	 * XAAAY
	 * XYAAA
	 * Akkor igaz, ha valamelyik fenáll
	 */
	private static boolean isThreeOfKind(Card[] cards) {
		// drill
		if(cards[0].getFigure().getValue() == cards[1].getFigure().getValue()
				&& cards[1].getFigure().getValue() == cards[2].getFigure().getValue()
			) {
			//AAAXY
			return true;
		}
		if(cards[1].getFigure().getValue() == cards[2].getFigure().getValue()
				&& cards[2].getFigure().getValue() == cards[3].getFigure().getValue()
			) {
			//XAAAY
			return true;
		}
		if(cards[2].getFigure().getValue() == cards[3].getFigure().getValue()
				&& cards[3].getFigure().getValue() == cards[4].getFigure().getValue()
			) {
			//XYAAA
			return true;
		}
		return false;
	}

	/**
	 * @param cards
	 * @return
	 * Három féle képpen lehet két pár a kézben.
	 * AABBX, AAXBB, XAABB
	 * Akkor igaz, ha ezek valamelyike fennáll
	 */
	private static boolean isTwoPair(Card[] cards) {
		if(cards[0].getFigure().getValue() == cards[1].getFigure().getValue()) {
			if(cards[2].getFigure().getValue() == cards[3].getFigure().getValue()) {
				//AABBX
				return true;
			}
			if(cards[3].getFigure().getValue() == cards[4].getFigure().getValue()) {
				//AAXBB
				return true;
			}
		}
		if(cards[1].getFigure().getValue() == cards[2].getFigure().getValue()
				&& cards[3].getFigure().getValue() == cards[4].getFigure().getValue()
			) {
			//XAABB
			return true;
		}
		return false;
	}

	/**
	 * @param cards
	 * @return
	 * Akkor igaz, ha két egymást követő kártya értéke egyenlő
	 */
	private static boolean isPair(Card[] cards) {
		// egy pár
		for(int i = 0; i < cards.length - 1;i++) {
			if(cards[i].getFigure().getValue() == cards[i + 1].getFigure().getValue()) {
				return true;
			}
		}
		return false;
	}

}
