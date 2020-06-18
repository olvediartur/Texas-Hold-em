/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Artúr Ölvedi
 *
 */
public enum CardColor {
	CLUBS("\u2667", 1), DIAMOND("\u2662", 2), SPADES("\u2664", 3), HEARTS("\u2661", 4);

	private int value;
	private String symbol;

	/**
	 * @param value
	 * @param symbol
	 */
	private CardColor(String symbol, int value) {
		this.value = value;
		this.symbol = symbol;
	}

	public String getSymbol() {
		return "" + symbol;
	}

	public int getValue() {
		return value;
	}

	/**
	 * @param color
	 * @return A bemenetként kapott szöveg alapján visszatér a szövegnek megfelelő
	 *         CardColor objektummal
	 */
	public static CardColor getColorEnum(String color) {
		for (CardColor cc : CardColor.values()) {
			if (("" + cc.getSymbol()).equals(color)) {
				return cc;
			}
		}
		return null;
	}

	/**
	 * @param color
	 * @return A bemenetként kapott szám alapján visszatér a számnak megfelelő
	 *         CardColor objektummal
	 */
	public static CardColor getColorEnum(int color) {
		for (CardColor cc : CardColor.values()) {
			if (cc.getValue() == color) {
				return cc;
			}
		}
		return null;
	}

}
