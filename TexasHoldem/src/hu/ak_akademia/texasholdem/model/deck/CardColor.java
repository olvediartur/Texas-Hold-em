/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Artúr Ölvedi
 *
 */
public enum CardColor {
	CLUBS("\u2667", 1, Color.GREEN),
	DIAMOND("\u2662", 2, Color.BLUE),
	SPADES("\u2664", 3, Color.BLACK),
	HEARTS("\u2661", 4, Color.RED);

	private int value;
	private String symbol;
	private Color color;

	/**
	 * @param value
	 * @param symbol
	 */
	private CardColor(String symbol, int value, Color color) {
		this.value = value;
		this.symbol = symbol;
		this.color = color;
	}

	public String getSymbol() {
		return "" + symbol;
	}

	public Color getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	/**
	 * @param color
	 * @return A bemenetként kapott szöveg alapján visszatér a szövegnek megfelelő
	 *         CardColor objektummal
	 */
	public static CardColor getCardColorEnum(String color) {
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
	public static CardColor getCardColorEnum(int color) {
		for (CardColor cc : CardColor.values()) {
			if (cc.getValue() == color) {
				return cc;
			}
		}
		return null;
	}

}
