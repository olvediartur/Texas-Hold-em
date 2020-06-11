/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Art�r �lvedi
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
	
	/**
	 * @param color
	 * @return
	 * A bemenetként kapott szöveg alapján
	 * visszatér a szövegnek megfelelő CardColor objektummal
	 */
	public static CardColor getColorEnum(String color) {
		for(CardColor cc : CardColor.values()) {
			if(("" + cc.getSymbol()).equals(color)) {
				return cc;
			}
		}		
		return null;		
	}
	
}
