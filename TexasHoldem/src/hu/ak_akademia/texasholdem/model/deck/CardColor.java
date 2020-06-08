/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Artúr Ölvedi
 *
 */
public enum CardColor {
	CLUBS('\u2667', 1), DIAMOND('\u2662', 2), SPADES('\u2664', 3), HEARTS('\u2661', 3);

	private int value;
	private char symbol;

	/**
	 * @param value
	 * @param symbol
	 */
	private CardColor(char symbol, int value) {
		this.value = value;
		this.symbol = symbol;
	}

	public String getSymbol() {
		return "" + symbol;
	}

	public int getValue() {
		return value;
	}
	
	public static CardColor getColorEnum(String color) {
		return null;
		
	}
}
